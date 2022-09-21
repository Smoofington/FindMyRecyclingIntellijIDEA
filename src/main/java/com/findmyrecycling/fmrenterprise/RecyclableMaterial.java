package com.findmyrecycling.fmrenterprise;

public class RecyclableMaterial {

    private Long materialId;
    private String materialName;

    public RecyclableMaterial(Long materialId, String materialName) {
        this.materialId = materialId;
        this.materialName = materialName;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
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