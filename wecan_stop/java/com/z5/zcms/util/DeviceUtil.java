package com.z5.zcms.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;

public class DeviceUtil {
    public static String getDevice(HttpServletRequest request) {
    	Device currentDevice = DeviceUtils.getCurrentDevice(request);
    	String deviceType = "1";
    	if (currentDevice.isNormal()) {
    		deviceType = "1";
    	}
    	else if (currentDevice.isMobile()) {
    		deviceType = "2";
		}
		else if (currentDevice.isTablet()) {
			deviceType = "3";
		}
    	System.out.println(deviceType);
    	return deviceType;
    }
}
