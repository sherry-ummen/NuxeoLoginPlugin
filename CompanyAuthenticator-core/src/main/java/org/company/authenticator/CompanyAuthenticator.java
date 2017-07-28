package org.company.authenticator;

import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoPrincipal;
import org.nuxeo.ecm.platform.api.login.UserIdentificationInfo;
import org.nuxeo.ecm.platform.ui.web.auth.interfaces.NuxeoAuthenticationPlugin;
import org.nuxeo.ecm.platform.ui.web.auth.interfaces.NuxeoAuthenticationPluginLogoutExtension;
import org.nuxeo.ecm.platform.usermanager.UserManager;
import org.nuxeo.runtime.api.Framework;

public class CompanyAuthenticator implements NuxeoAuthenticationPlugin, NuxeoAuthenticationPluginLogoutExtension {

    private static final Log log = LogFactory.getLog(CompanyAuthenticator.class);

    private String company_api_url = "";

    private String company_login_url = "";

    private final String COMPANY_COOKIE = "companycookie";

    @Override
    public UserIdentificationInfo handleRetrieveIdentity(HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) {
        try {

            File file = new File("c:\\mydrive\\handleRetrieveIdentity.txt");

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void initPlugin(Map<String, String> parameters) {

        try {

            File file = new File("c:\\mydrive\\initPlugin.txt");

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("init Company Authenticator");
        if (parameters.containsKey("companyAPIURL") && parameters.containsKey("companyLoginURL")) {
            log.info("API_URL_PARAM: " + parameters.get("companyAPIURL"));
            log.info("API_LOGIN_PARAM: " + parameters.get("companyLoginURL"));
            company_api_url = parameters.get("companyAPIURL");
            company_login_url = parameters.get("companyLoginURL");
               try {

            File file = new File("c:\\mydrive\\company_login_url.txt");

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        log.debug("end init");
    }

    @Override
    public Boolean needLoginPrompt(HttpServletRequest httpRequest) {
        return true;
    }

    @Override
    public Boolean handleLoginPrompt(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String baseURL) {
        try {

            File file = new File("c:\\mydrive\\handleLoginPrompt.txt");

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Cookie cookie = getCookie(httpRequest, "companycookie");
        Boolean keepalive = isLoggedIn(httpRequest, cookie);
        log.debug("keepalive success: " + keepalive);
        if (!keepalive) {
            try {
                String redirect_url = httpRequest.getRequestURL().toString();
                String security_header = httpRequest.getHeader("X-Forwarded-Proto");
                if (security_header != null && security_header.toLowerCase().equals("https")) {
                    redirect_url = redirect_url.replace("http://", "https://");
                }
                redirect_url = URLEncoder.encode(redirect_url, "UTF-8");
                httpResponse.sendRedirect(getLoginUrl(httpRequest, company_login_url) + "?redirect=" + redirect_url);
                return true;
            } catch (Exception ex) {
                log.error("unable to redirect", ex);
            }
        }
        return false;
    }

    @Override
    public List<String> getUnAuthenticatedURLPrefix() {
        log.debug("In unauth url prefix: there are no urls we deny access");
        return null;
    }

    private Boolean isLoggedIn(HttpServletRequest httpRequest, Cookie cookie) {
        return false;
    }

    @Override
    public Boolean handleLogout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        return false;
    }

    private String getApiUrl(HttpServletRequest httpRequest, String property) {
        if (property.equals("AUTOMATIC")) {
            try {
                return "http://" + httpRequest.getServerName() + "/api/";
            } catch (Exception ex) {
                log.debug("error converting to url");
            }

        }

        return property;
    }

    private String getLoginUrl(HttpServletRequest httpRequest, String property) {
        if (property.equals("AUTOMATIC")) {
            try {
                return "http://" + httpRequest.getServerName();
            } catch (Exception ex) {
                log.debug("error converting to url");
            }

        }

        return property;
    }

    private static Cookie getCookie(HttpServletRequest httpRequest, String cookieName) {
        log.debug("trying to get cookie: " + cookieName);
        Cookie cookies[] = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
