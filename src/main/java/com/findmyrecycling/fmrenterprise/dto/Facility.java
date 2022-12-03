package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facilities")
public @Data
class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long facilityId;
    private String facilityName;
    private String facilityAddress;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private RecyclableMaterial recyclableMaterial;

    public Facility(Long facilityId,RecyclableMaterial recyclableMaterial, String facilityName, Photo photo, String facilityAddress) {
        this.facilityId = facilityId;
        this.recyclableMaterial = recyclableMaterial;
        this.facilityName = facilityName;
        this.photo = photo;
        this.facilityAddress = facilityAddress;
    }

    public Facility() {

    }

    @Override
    public String toString() {
        return "Facility{" +
                "facilityId=" + facilityId +
                ", materialId=" + recyclableMaterial.getMaterialName() +
                ", facilityName='" + facilityName + '\'' +
                ", facilityPhotos='" + photo.getPhotoId() + '\'' +
                ", facilityAddress='" + facilityAddress + '\'' +
                '}';
    }
}