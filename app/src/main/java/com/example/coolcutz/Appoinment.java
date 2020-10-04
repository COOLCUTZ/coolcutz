package com.example.coolcutz;



public class Appoinment {
    private Integer AppoinmentID;
    private String BeautyName;
    private String CusName;
    private String Phone;
    private long started,finished;

    public Appoinment() {

    }

    public Appoinment(Integer appoinmentID, String beautyName, String cusName, String phone, long started, long finished) {
        AppoinmentID = appoinmentID;
        BeautyName = beautyName;
        CusName = cusName;
        Phone = phone;
        this.started = started;
        this.finished = finished;
    }

    public Appoinment(String beautyName, String cusName, String phone, long started, long finished) {
        BeautyName = beautyName;
        CusName = cusName;
        Phone = phone;
        this.started = started;
        this.finished = finished;
    }

    public Appoinment(int parseInt, String beautyname, String cusname, Long updateDate, int finished) {
    }

    public Appoinment(String txtbeautyname, String txtcustomername, long started, int i) {
    }

    public Integer getAppoinmentID() {
        return AppoinmentID;
    }

    public void setAppoinmentID(Integer appoinmentID) {
        AppoinmentID = appoinmentID;
    }

    public String getBeautyName() {
        return BeautyName;
    }

    public void setBeautyName(String beautyName) {
        BeautyName = beautyName;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
