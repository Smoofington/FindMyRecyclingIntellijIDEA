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
    @OneToMany(mappedBy = "facility")
    private List<Photo> facilityPhotos;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private RecyclableMaterial recyclableMaterial;

    public Facility(Long facilityId,RecyclableMaterial recyclableMaterial, String facilityName, List<Photo> facilityPhotos, String facilityAddress) {
        this.facilityId = facilityId;
        this.recyclableMaterial = recyclableMaterial;
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
                ", materialId=" + recyclableMaterial.getMaterialId() +
                ", facilityName='" + facilityName + '\'' +
                ", facilityPhotos='" + facilityPhotos + '\'' +
                ", facilityAddress='" + facilityAddress + '\'' +
                '}';
    }
}