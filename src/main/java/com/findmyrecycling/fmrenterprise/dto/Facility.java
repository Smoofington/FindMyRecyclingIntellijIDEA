package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;

public @Data
class Facility {


    private Long facilityId;
    private Long materialId;
    private String facilityName;
    private String facilityPhotos;
    private String facilityAddress;

    public Facility(Long facilityId, Long materialId, String facilityName, String facilityPhotos, String facilityAddress) {
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
    public Long getFacilityId() {
        return facilityId;
    }

    public Long getMaterialId() {
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
}