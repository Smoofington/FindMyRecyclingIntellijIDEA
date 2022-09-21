package com.findmyrecycling.fmrenterprise;

public class Facility {
    private Long facilityId;
    private Long materialId;
    private String facilityName;
    private String facilityPhotos;
    private String facilityAddress;
    private Decimal facilityCoordinates;

    public Facility(Long facilityId, Long materialId, String facilityName, String facilityPhotos, String facilityAddress, Decimal facilityCoordinates) {
        this.facilityId = facilityId;
        this.materialId = materialId;
        this.facilityName = facilityName;
        this.facilityPhotos = facilityPhotos;
        this.facilityAddress = facilityAddress;
        this.facilityCoordinates = facilityCoordinates;
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

    public Decimal getFacilityCoordinates() {
        return facilityCoordinates;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public void setFacilityPhotos(String facilityPhotos) {
        this.facilityPhotos = facilityPhotos;
    }

    public void setFacilityAddress(String facilityAddress) {
        this.facilityAddress = facilityAddress;
    }

    public void setFacilityCoordinates(Decimal facilityCoordinates) {
        this.facilityCoordinates = facilityCoordinates;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Facility{" +
                "facilityId=" + facilityId +
                ", materialId=" + materialId +
                ", facilityName='" + facilityName + '\'' +
                ", facilityPhotos='" + facilityPhotos + '\'' +
                ", facilityAddress='" + facilityAddress + '\'' +
                ", facilityCoordinates=" + facilityCoordinates +
                '}';
    }
}