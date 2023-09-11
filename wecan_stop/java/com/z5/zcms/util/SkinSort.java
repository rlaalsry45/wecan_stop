package com.z5.zcms.util;

import java.util.Comparator;

public abstract class SkinSort implements Comparator<Object>{
	@Override
	public int compare(Object arg1, Object arg2) {
		DataTable o1 = (DataTable)arg1;
		DataTable o2 = (DataTable)arg2;

		int result1 = o1.get("type").compareToIgnoreCase(o2.get("type"));
		int result2 = o1.get("skin").compareToIgnoreCase(o2.get("skin"));

		if (result1>0){
			return 1;
		}

		if (result1<0){
			return -1;
		}

		if (result1==0){
			return result2;
		}

		return 0;
	}
}
