package com.findmyrecycling.fmrenterprise.dto;

import lombok.Data;

/**
 * Represents facility photo
 * photoId: ID to track photo
 * localUri: URI of photo
 * description: Description of photo
 * dateAdded: Timestamp of photo
 */
public @Data
class Photo {


    private int photoId;
    private String localUri;
    private String description;
    private String dateAdded;

    public Photo(int photoId, String localUri, String description, String dateAdded) {
        this.photoId = photoId;
        this.localUri = localUri;
        this.description = description;
        this.dateAdded = dateAdded;
    }
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