package com.z5.zcms.admsys.ftp;

import scala.Serializable;

public class FtpContext implements Serializable {
    private static final long serialVersionUID = -38331060124340967L;

    private String  name;
    private Integer size;
    private String  path;

    FtpContext(String name, Integer size, String path) {
        super();
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
