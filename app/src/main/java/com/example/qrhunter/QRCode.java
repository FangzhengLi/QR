package com.example.qrhunter;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class QRCode {
    private int score;
    private String  QRId;
    private Boolean sharedLocation;
    private Boolean sharedPicture;
    private String comment;
    private GeoPoint geoPoint;
    ArrayList<String> scanners;

    public QRCode() {}

    public void setSharedLocation(Boolean sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void setSharedPicture(Boolean sharedPicture) {
        this.sharedPicture = sharedPicture;
    }

    public Boolean getSharedLocation() {
        return sharedLocation;
    }

    public Boolean getSharedPicture() {
        return sharedPicture;
    }

    public QRCode(String QRId, int score) {
        this.score = score;
        this.QRId = QRId;
        this.sharedLocation = false;
        this.sharedPicture = false;
        this.comment = "";
        this.geoPoint =null;
        this.scanners = new ArrayList<String>();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setQRId(String QRId) {
        this.QRId = QRId;
    }

    public String getQRId() {
        return QRId;
    }



    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setScanners(ArrayList<String> scanners) {
        this.scanners = scanners;
    }

    public ArrayList<String> getScanners() {
        return scanners;
    }

    public void addScanner(String scanner) {
        this.scanners.add(scanner);
    }
}
