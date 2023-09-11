package com.z5.zcms.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertUtils {

	public static Map<String, Object> convertToMap(Object obj) throws IllegalAccessException, InstantiationException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (obj == null) {
			return Collections.emptyMap();
		}

		Map<String, Object> convertMap = new HashMap<>();

		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			convertMap.put(field.getName(), field.get(obj));
		}
		return convertMap;
	}

	public static <T> T convertToValueObject(Map<String, Object> map, Class<T> type)
			throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		if (type == null) {
			throw new NullPointerException("Class cannot be null");
		}

		T instance = type.getConstructor().newInstance();

		if (map == null || map.isEmpty()) {
			return instance;
		}

		for (Map.Entry<String, Object> entrySet : map.entrySet()) {
			Field[] fields = type.getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);

				String fieldName = field.getName();

				boolean isSameType = entrySet.getValue().getClass().equals(field.getType());
				boolean isSameName = entrySet.getKey().equals(fieldName);

				if (isSameType && isSameName) {
					field.set(instance, map.get(fieldName));
				}
			}
		}
		return instance;
	}

	public static List<Map<String, Object>> convertToMaps(List<?> list)
			throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}

		List<Map<String, Object>> convertList = new ArrayList<>();

		for (Object obj : list) {
			convertList.add(ConvertUtils.convertToMap(obj));
		}
		return convertList;
	}

	public static <T> List<T> convertToValueObjects(List<Map<String, Object>> list, Class<T> type)
			throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}

		List<T> convertList = new ArrayList<>();

		for (Map<String, Object> map : list) {
			convertList.add(ConvertUtils.convertToValueObject(map, type));
		}
		return convertList;
	}
}
