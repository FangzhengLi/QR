package com.example.qrhunter;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class User  {
    private String userID;
    private String userName;
    private String userPasscode;
    private int highest;
    private int sum;
    private int unique;
    private int total;
    String comment;
    //String email;
    List<CodeScore> code;
    private ArrayList<QRCode> codes = new ArrayList<>();
    private String userEmail;
    ArrayList<String> scanned;

    /**
     * construct user
     * @param name
     * @param password
     */

    public User(String name, String password) {
        this.userName = name;
        this.userPasscode = password;
        this.sum = 0;
        this.total = 0;
        this.userEmail = "";
        this.comment = "";
        this.code = new ArrayList<CodeScore>();
        // this.codes = new ArrayList<>();
        //this.comment = "";
        // this.scanned = new ArrayList<String>();


    }

    /**
     * construct user
     * @param userName
     * @param userID
     * @param codes
     */
    public User(String userName, String userID, ArrayList<QRCode> codes) {
        this.userID = userID;
        this.userName = userName;
        this.codes = codes;
    }

    /**
     * construct user
     * @param userID
     * @param userName
     * @param userPasscode
     */

    public User(String userID, String userName, String userPasscode) {
        this.userID = userID;
        this.userName = userName;
        this.userPasscode = userPasscode;
        this.codes = new ArrayList<>();


    }

    /**
     * construct user
     * @param userName
     * @param amount
     */

    public User(String userName,int amount) {
        // this.userID = userID;
        this.userName = userName;
        this.codes = new ArrayList<>();
        this.total=amount;
        this.highest = amount;
        this.unique=amount;
        this.sum = amount;

    }

    /**
     * construct user
     */

    public User() {
    }

    /**
     * get name
     * @return
     */

    public String getUserName() {
        return userName;
    }

    /**
     * get code
     * @return
     */

    public ArrayList<QRCode> getCodes() {
        return codes;
    }

    /**
     * get sum
     * @return
     */
    public int getSum(){

        return sum;
    }

    /**
     * get total
     * @return
     */
    public int getTotal(){

        return total;
    }

    /**
     * get highest
     * @return
     */
    public int getHighest(){

        return highest;
    }

    /**
     * get unique
     * @return
     */

    public int getUnique(){

        return unique;
    }








}
