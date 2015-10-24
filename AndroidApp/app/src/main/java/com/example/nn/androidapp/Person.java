package com.example.nn.androidapp;

import java.util.Date;
import java.util.UUID;

/**
 * Created by NN on 21.10.2015.
 */
public class Person  {

    private UUID mId;
    private String mName;
    private String mSurname;
    private Date mDate;


    public Person(String name, String surname){
        mId = UUID.randomUUID();
        mDate = new Date();
        this.mName = name;
        this.mSurname = surname;
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }

    public Date getmDate() {
        return mDate;
    }


    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
