package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;

/**
 * Represents facility data
 * facilityId: ID to track facility
 * materialId: ID to track material
 * facilityName: Name of facility
 * facilityPhotos: Photo of facility
 * facilityAddress: Address of facility
 */
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
}