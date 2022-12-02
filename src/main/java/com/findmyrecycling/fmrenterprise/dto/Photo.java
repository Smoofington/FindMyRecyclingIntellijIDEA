package com.findmyrecycling.fmrenterprise.dto;

import ch.qos.logback.classic.db.names.ColumnName;
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
    @Column(length = 2147483647)
    private String base64;

    @ToString.Exclude
    @OneToOne(mappedBy = "photo")
    private Facility facility;

    @java.lang.Override
    public java.lang.String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                '}';
    }
}