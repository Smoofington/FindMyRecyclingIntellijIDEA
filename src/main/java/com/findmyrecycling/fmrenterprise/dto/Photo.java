package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="photos")
public @Data
class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int photoId;
    private String fileName;
    private String localUri;
    private String description;
    private String dateAdded;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="facility_id")
    private Facility facility;

    @java.lang.Override
    public java.lang.String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", localUri='" + localUri + '\'' +
                ", description='" + description + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                '}';
    }
}