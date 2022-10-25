package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;

public @Data
class Facility {
    private int facilityId;
    private int materialId;
    private String facilityName;
    private String facilityPhotos;

    public int getFacilityId() {
        return facilityId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getFacilityPhotos() {
        return facilityPhotos;
    }

    public String getFacilityAddress() {
        return facilityAddress;
    }

    private String facilityAddress;

    public Facility(int facilityId, int materialId, String facilityName, String facilityPhotos, String facilityAddress) {
        this.facilityId = facilityId;
        this.materialId = materialId;
        this.facilityName = facilityName;
        this.facilityPhotos = facilityPhotos;
        this.facilityAddress = facilityAddress;
    }

    public Facility() {

    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Facility{" +
                "facilityId=" + facilityId +
                ", materialId=" + materialId +
                ", facilityName='" + facilityName + '\'' +
                ", facilityPhotos='" + facilityPhotos + '\'' +
                ", facilityAddress='" + facilityAddress + '\'' +
                '}';
    }
}