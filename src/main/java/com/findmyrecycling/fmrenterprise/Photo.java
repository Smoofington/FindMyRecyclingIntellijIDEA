package com.findmyrecycling.fmrenterprise;

public class Photo {

    private Long photoId;
    private String localUri;
    private String description;
    private String dateAdded;

    public Photo(Long photoId, String localUri, String description, String dateAdded) {
        this.photoId = photoId;
        this.localUri = localUri;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getLocalUri() {
        return localUri;
    }

    public void setLocalUri(String localUri) {
        this.localUri = localUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
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