package com.example.qrhunter;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class QRCode {
    private int score;
    private String  QRId;
    private Boolean sharedLocation;
    private Boolean sharedPicture;
    private String comment;
    ArrayList<String> scanners;
    ArrayList<String> http;

    /**
     * construct code
     */
    public QRCode() {
    }

    /**
     * construct a code
     * @param QRId
     * @param score
     */

    public QRCode(String QRId, int score) {
        this.score = score;
        this.QRId = QRId;
        this.sharedLocation = false;
        this.sharedPicture = false;
        this.comment = "";
        this.scanners = new ArrayList<String>();
        this.http = new ArrayList<String>();
    }

    /**
     * set score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * get score
     * @return int
     */

    public int getScore() {
        return score;
    }

    /**
     * set comment
     * @param comment
     */

    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * get comment
     * @return
     */

    public String getComment() {
        return comment;
    }

    /**
     * add scanner
     * @param scanner
     */
    public void addScanner(String scanner) {
        this.scanners.add(scanner);
    }

    /**
     * setHttp
     * @param http
     */
    public void setHttp(ArrayList<String> http) {
        this.http = http;
    }

    /**
     * get http
     * @return
     */

    public ArrayList<String> getHttp() {
        return http;
    }

}

