package org.company.authenticator;

import java.util.Map;

import java.io.File;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.platform.api.login.UserIdentificationInfo;
import org.nuxeo.ecm.platform.login.LoginPlugin;


public class CompanyLoginPlugin implements LoginPlugin {


    private static final Log log = LogFactory.getLog(CompanyLoginPlugin.class);
    private String name = "CompanyLoginPlugin";
    private Map<String, String> params = null;


    @Override
    public String validatedUserIdentity(UserIdentificationInfo userIdent) {
        try {

	      File file = new File("c:\\mydrive\\validatedUserIdentity.txt");

	      if (file.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }

    	} catch (IOException e) {
	      e.printStackTrace();
	}
        return userIdent.getUserName();
    }


    @Override
    public Boolean initLoginModule() {
    	 try {

   	      File file = new File("c:\\mydrive\\initLoginModule.txt");

   	      if (file.createNewFile()){
   	        System.out.println("File is created!");
   	      }else{
   	        System.out.println("File already exists.");
   	      }

       	} catch (IOException e) {
   	      e.printStackTrace();
   	}
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