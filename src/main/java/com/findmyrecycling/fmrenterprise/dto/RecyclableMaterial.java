package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;

public @Data
class RecyclableMaterial {

    private int materialId;
    private String materialName;



    public RecyclableMaterial(int materialId, String materialName) {
        this.materialId = materialId;
        this.materialName = materialName;
    }

    public RecyclableMaterial() {
        //You are trying to set the class variables to themselves
        //this.materialId = materialId;
        //this.materialName = materialName;
    }

    public int getMaterialId() {
        return materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RecyclableMaterial{" +
                "materialId=" + materialId +
                ", materialName='" + materialName + '\'' +
                '}';
    }
}