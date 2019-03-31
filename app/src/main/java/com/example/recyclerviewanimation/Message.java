package com.example.recyclerviewanimation;

import java.util.Date;

public class Message {
    private String title;
    private String descripton;
    private Date mDate;
    private int photoUrl;

    public Message(String title, String description, Date date, int photoUrl) {
        this.title = title;
        this.descripton = description;
        mDate = date;
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public int getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(int photoUrl) {
        this.photoUrl = photoUrl;
    }
}
