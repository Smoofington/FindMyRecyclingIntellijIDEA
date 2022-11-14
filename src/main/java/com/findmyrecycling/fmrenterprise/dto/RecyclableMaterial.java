package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "materials")
public @Data
class RecyclableMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long materialId;
    private String materialName;
    @ToString.Exclude
    @OneToMany(mappedBy = "recyclableMaterial")
    private List<Facility> facility;



    public RecyclableMaterial(Long materialId, String materialName, List<Facility> facility) {
        this.materialId = materialId;
        this.materialName = materialName;
        this.facility = facility;
    }

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