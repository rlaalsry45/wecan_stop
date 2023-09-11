package com.z5.zcms.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.z5.zcms.admsys.common.domain.QueryMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerMapping;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class Converter {

    public static String[] listToArray(List<String> list) {
        String[] array = new String[list.size()];
        array = list.toArray(array);
        return array;
    }

    public static List<String> textToList(String text) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isNotBlank(text)) {
            String[] items = text.split(",");
            Collections.addAll(list, items);
        }
        return list;
    }

    public static String listToText(List<String> list) {
        StringBuilder text = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (String item : list) {
                if (text.length() != 0) {
                    text.append(',');
                }
                text.append(item);
            }
        }
        return text.toString();
    }

    public static Map<String, String> jsonToMap(String json) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        try {
            if (StringUtils.isNotBlank(json)) {
                TypeReference<LinkedHashMap<String, String>> tr = new TypeReference<LinkedHashMap<String, String>>() {};
                ObjectMapper                                 om = new ObjectMapper();
                map = om.readValue(json, tr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, List<String>> jsonToMapList(String json) {
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        try {
            if (StringUtils.isNotBlank(json)) {
                TypeReference<LinkedHashMap<String, List<String>>> tr = new TypeReference<LinkedHashMap<String, List<String>>>() {};
                ObjectMapper                                       om = new ObjectMapper();
                map = om.readValue(json, tr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static List<List<String>> jsonToListList(String json) {
        List<List<String>> map = new ArrayList<List<String>>();
        try {
            if (StringUtils.isNotBlank(json)) {
                TypeReference<List<List<String>>> tr = new TypeReference<List<List<String>>>() {};
                ObjectMapper                      om = new ObjectMapper();
                map = om.readValue(json, tr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String mapToJson(Map<String, String> map) {
        String json = "";
        try {
            if (map.size() > 0) {
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Map<Object, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<Object, Object> retMap = new HashMap<Object, Object>();

        if (json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map<Object, Object> toMap(JSONObject object) throws JSONException {
        Map<Object, Object> map = new HashMap<Object, Object>();

        Iterator keys = object.keys();
        while (keys.hasNext()) {
            String key   = keys.next().toString();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

    public static List<String> toMapK(String storage) {
        List<String> map = new ArrayList<String>();
        if (StringUtils.isNotBlank(storage)) {
            Map<String, String> mapFiles = jsonToMap(storage);

            if (mapFiles != null) {
                for (Entry<String, String> entry : mapFiles.entrySet()) {
                    map.add(entry.getKey());
                }
            }
        }

        return map;
    }

    public static List<String> toMapV(String storage) {
        List<String> map = new ArrayList<String>();
        if (StringUtils.isNotBlank(storage)) {
            Map<String, String> mapFiles = jsonToMap(storage);

            if (mapFiles != null) {
                for (Entry<String, String> entry : mapFiles.entrySet()) {
                    map.add(entry.getValue());
                }
            }
        }

        return map;
    }

    public static List<QueryMap> queryMap1(String json) {
        List<QueryMap>      list = new ArrayList<QueryMap>();
        Map<String, String> pair = jsonToMap(json);
        Set                 sets = pair.entrySet();
        for (Object set : sets) {
            Entry  entry = (Entry) set;
            String value = entry.getValue().toString();
            if (StringUtils.isNotBlank(value)) {
                QueryMap map = new QueryMap();
                map.setKey(entry.getKey().toString());
                map.setValue(value);
                list.add(map);
            }
        }
        return list;
    }

    public static List<QueryMap> queryMap2(String json) {
        List<QueryMap>            list = new ArrayList<QueryMap>();
        Map<String, List<String>> pair = jsonToMapList(json);

        for (Map.Entry<String, List<String>> entry : pair.entrySet()) {
            int index = 0;
            for (String value : entry.getValue()) {
                if (StringUtils.isNotBlank(value)) {
                    QueryMap map = new QueryMap();
                    map.setKey(entry.getKey());
                    map.setValue(value);
                    if (index > 0) map.setJoint("OR");
                    list.add(map);
                }
                index++;
            }
        }

        return list;
    }

    public static List<QueryMap> queryMapList(String json) {
        List<QueryMap>     maps = new ArrayList<QueryMap>();
        List<List<String>> list = jsonToListList(json);

        int index = 0;
        for (List<String> each : list) {
            QueryMap map = new QueryMap();
            map.setKey(each.get(0));
            map.setValue(each.get(1));
            if (index == 0) {
                map.setJoint("");
            } else {
                map.setJoint(each.size() >= 2 ? each.get(2) : "OR");
            }
            maps.add(map);
            index++;
        }

        return maps;
    }

    public static List<QueryMap> queryMap(Map<String, String> pair) {
        List<QueryMap> list = new ArrayList<QueryMap>();
        Set            sets = pair.entrySet();
        for (Object set : sets) {
            Entry  entry = (Entry) set;
            String value = entry.getValue().toString();
            if (StringUtils.isNotBlank(value)) {
                QueryMap map = new QueryMap();
                map.setKey(entry.getKey().toString());
                map.setValue(value);
                list.add(map);
            }
        }
        return list;
    }

    public static List<QueryMap> queryMap(String key, String value) {
        List<QueryMap> list = new ArrayList<QueryMap>();
        QueryMap       map  = new QueryMap();
        map.setKey(key);
        map.setValue(value);
        list.add(map);
        return list;
    }

    public static String replaceFileWing(String file, String wing) {
        if (StringUtils.isNotBlank(file) && StringUtils.isNotBlank(wing)) {
            int    ndex = file.indexOf(".");
            String name = file.substring(0, ndex + 1);
            return name + wing;
        }
        return file;
    }


    public static String formatDate(String date, String form) {
        String fmt = date.replaceAll("-", "").replaceAll(" ", "");
        int    siz = fmt.length();

        if (form.equalsIgnoreCase("yyyy-mm-dd") && siz >= 8) {
            return fmt.substring(0, 4) + "-" + fmt.substring(4, 6) + "-" + fmt.substring(6, 8);
        } else if (form.equalsIgnoreCase("yyyy-mm-dd hh:mm") && siz >= 12) {
            return fmt.substring(0, 4) + "-" + fmt.substring(4, 6) + "-" + fmt.substring(6, 8) + " " + fmt.substring(8, 10) + ":" + fmt.substring(10, 12);
        } else if (form.equalsIgnoreCase("yyyy-mm-dd hh:mm:ss") && siz >= 14) {
            return fmt.substring(0, 4) + "-" + fmt.substring(4, 6) + "-" + fmt.substring(6, 8) + " " + fmt.substring(8, 10) + ":" + fmt.substring(10, 12) + ":" + fmt.substring(12, 14);
        }
        return date;
    }

    public static String toDate(String date) {
        if (StringUtils.isNotBlank(date)) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        }
        return date;
    }

    public static String toDate(String date, String pattern) {
        if (StringUtils.isNotBlank(date)) {
            return new SimpleDateFormat(pattern).format(date);
        }
        return date;
    }

    public static String toString(List<QueryMap> list) {
        StringBuilder s = new StringBuilder();
        if (list != null && list.size() > 0) {
            s.append("{ ");
            for (QueryMap m : list) {
                s.append("[").append(m.getKey()).append(", ").append(m.getValue()).append(", ").append(m.getJoint()).append("], ");
            }
            s.append("}");
        } else {
            s.append("{}");
        }
        return s.toString();
    }

    public static String itoa(Integer value) {
        return value != null ? value.toString() : "0";
    }

    public static int atoi(String value) {
        return StringUtils.isNumeric(value) ? Integer.parseInt(value) : 0;
    }

    public static String toHuman(double bytes, int digits) {
        String[] units = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        int      index;
        for (index = 0; index < units.length; index++) {
            if (bytes < 1024) {
                break;
            }
            bytes = bytes / 1024;
        }
        return String.format("%." + digits + "f", bytes) + " " + units[index];
    }

    public static String toHuman(Integer bytes) {
        String readable = "";
        if (bytes != null) {
            readable = toHuman((double) bytes, 2);
        }
        return readable;
    }

    public static String fileSize(File file) {
        String readable = "";
        if (file != null) {
            readable = toHuman((double) file.length(), 2);
        }
        return readable;
    }

    public static String comma(long size) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(size);
    }

    public static String fileName(String path) {
        if (StringUtils.isNotBlank(path)) {
            if (path.contains("/")) {
                return path.substring(path.lastIndexOf("/") + 1);
            }
            if (path.contains("\\")) {
                return path.substring(path.lastIndexOf("\\") + 1);
            }
        }
        return path;
    }

    public static String baseName(String path) {
        String file = fileName(path);
        if (StringUtils.isNotBlank(file) && file.contains(".")) {
            return file.substring(0, file.lastIndexOf("."));
        }
        return file;
    }

    public static String fuseName(String path) {
        String file = fileName(path);
        if (StringUtils.isNotBlank(file) && file.contains(".")) {
            return file.substring(file.lastIndexOf(".") + 1);
        }
        return file;
    }

    public static String htmlName(HttpServletRequest req) {
        String path = "";
        if (req != null) {
            path = (String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
            if (StringUtils.isNotBlank(path)) {
                return path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
            }
        }
        return path;
    }
}
