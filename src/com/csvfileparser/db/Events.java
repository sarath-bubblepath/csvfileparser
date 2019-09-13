package com.csvfileparser.db;

public class Events {

    private Long objectId;
    private Integer objectType;

    public Events setObjectId(Long objectId) {
        this.objectId = objectId;
        return this;
    }

    public Events setObjectType(Integer objectType) {
        this.objectType = objectType;
        return this;
    }

    public Long getObjectId() {
        return objectId;
    }

    public Integer getObjectType() {
        return objectType;
    }
}
