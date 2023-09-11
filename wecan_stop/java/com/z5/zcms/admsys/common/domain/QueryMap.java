package com.z5.zcms.admsys.common.domain;

import java.util.Objects;

public class QueryMap {
    private String key;
    private String value;
    private String joint;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryMap queryMap = (QueryMap) o;
        return key.equals(queryMap.key) &&
                value.equals(queryMap.value) &&
                Objects.equals(joint, queryMap.joint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, joint);
    }

    public QueryMap() {
    }

    public QueryMap(String key, String value) {
        this.key = key;
        this.value = value;
        this.joint = "";
    }

    public QueryMap(String key, String value, String joint) {
        this.key = key;
        this.value = value;
        this.joint = joint;
    }

    public QueryMap(String key, Integer value, String joint) {
        this.key = key;
        this.value = Integer.toString(value);
        this.joint = joint;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getJoint() {
        return joint;
    }

    public void setJoint(String joint) {
        this.joint = joint;
    }

    public void setKV(String... values) {
        if (values.length >= 2) {
            this.key = values[0];
            this.value = values[1];
            this.joint = values.length >= 3 ? values[2] : "OR";
        }
    }
}

