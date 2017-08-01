package org.company.authenticator;

import org.nuxeo.ecm.platform.api.login.UserIdentificationInfo;
import org.nuxeo.ecm.platform.ui.web.auth.interfaces.NuxeoAuthenticationPlugin;
import org.nuxeo.ecm.platform.ui.web.auth.interfaces.NuxeoAuthenticationPluginLogoutExtension;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class CompanyAuthenticator implements NuxeoAuthenticationPlugin, NuxeoAuthenticationPluginLogoutExtension {

    @Override
    public UserIdentificationInfo handleRetrieveIdentity(HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) {
        FileCreator.Create("handleRetrieveIdentity");
        return null;
    }

    @Override
    public void initPlugin(Map<String, String> parameters) {
        FileCreator.Create("initPlugin");
    }

    @Override
    public Boolean needLoginPrompt(HttpServletRequest httpRequest) {
        return true;
    }

    @Override
    public Boolean handleLoginPrompt(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String baseURL) {
        FileCreator.Create("handleLoginPrompt");
        return true;
    }

    @Override
    public List<String> getUnAuthenticatedURLPrefix() {
        FileCreator.Create("getUnAuthenticatedURLPrefix");
        return null;
    }

    private Boolean isLoggedIn(HttpServletRequest httpRequest, Cookie cookie) {
        return false;
    }

    @Override
    public Boolean handleLogout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        return false;
    }
}
