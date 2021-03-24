package com.example.trackingapp;

class TrackingStatusModel {

    private String timestamp;
    private String datetime;
    private String location;
    private String details;

    @Override
    public String toString() {
        return "TrackingStatusModel{" +
                "timestamp='" + timestamp + '\'' +
                ", datetime='" + datetime + '\'' +
                ", location='" + location + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public TrackingStatusModel(String timestamp, String datetime, String location, String details) {
        this.timestamp = timestamp;
        this.datetime = datetime;
        this.location = location;
        this.details = details;
    }

    public TrackingStatusModel() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
