package com.z5.zcms.admsys.common.web;

import scala.Serializable;

public class FileContext implements Serializable {
    private static final long serialVersionUID = -38331060124340967L;

    private String  name;
    private Integer size;
    private String  path;
    private int	no;

    public FileContext(String name, Integer size, String path, int no) {
        super();
        this.name = name;
        this.size = size;
        this.path = path;
        this.no = no;
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
    
}
