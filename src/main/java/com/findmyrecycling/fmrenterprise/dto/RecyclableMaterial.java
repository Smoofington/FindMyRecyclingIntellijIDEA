package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;

public @Data
class RecyclableMaterial {

    private Long materialId;
    private String materialName;



    public RecyclableMaterial(Long materialId, String materialName) {
        this.materialId = materialId;
        this.materialName = materialName;
    }

    public RecyclableMaterial() {
        this.materialName = materialName;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "RecyclableMaterial{" +
                "materialId=" + materialId +
                ", materialName='" + materialName + '\'' +
                '}';
    }
}