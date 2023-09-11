package com.z5.zcms.admsys.common.domain;

import java.io.Serializable;

public class ComSetVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1134152113463852242L;

    private String projectName  = "ZCM003지정";
    private String adminIPCheck = "N";

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAdminIPCheck() {
        return adminIPCheck;
    }

    public void setAdminIPCheck(String adminIPCheck) {
        this.adminIPCheck = adminIPCheck;
    }

    @Override
    public String toString() {
        return "ComSetVO{" +
               "projectName='" + projectName + '\'' +
               ", adminIPCheck='" + adminIPCheck + '\'' +
               '}';
    }
}
