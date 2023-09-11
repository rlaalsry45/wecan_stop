package com.z5.zcms.admsys.common.domain;

import java.io.Serializable;

public class SerialContainer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2718276576663998290L;
	
	private Object instance;

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object instance) {
		this.instance = instance;
	}

	
}
