package org.company.authenticator;

import java.util.Map;

import org.nuxeo.ecm.platform.api.login.UserIdentificationInfo;
import org.nuxeo.ecm.platform.login.LoginPlugin;


public class CompanyLoginPlugin implements LoginPlugin {


    private String name = "CompanyLoginPlugin";
    private Map<String, String> params = null;


    @Override
    public String validatedUserIdentity(UserIdentificationInfo userIdent) {
        FileCreator.Create("validatedUserIdentity");
        return null;
    }


    @Override
    public Boolean initLoginModule() {
    	FileCreator.Create("initLoginModule");
        return true;
    }


    @Override
    public Map<String, String> getParameters() {
        return params;
    }


    @Override
    public void setParameters(Map<String, String> parameters) {
        params = parameters;
    }


    @Override
    public String getParameter(String parameterName) {
        return params.get(parameterName);
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public void setName(String pluginName) {
        name = pluginName;
    }
}