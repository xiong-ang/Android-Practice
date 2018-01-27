package com.example.xiongang.criminalintent;

import java.util.UUID;
import java.util.Date;

/**
 * Created by xiongang on 2018/1/21.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSloved;
    public Crime()
    {
        mId=UUID.randomUUID();
        mDate=new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public boolean isSloved() {
        return mSloved;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDate(Date data) {
        mDate = data;
    }

    public void setSloved(boolean sloved) {
        mSloved = sloved;
    }
}
