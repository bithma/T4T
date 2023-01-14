package com.example.t4t.database;

import java.util.Date;

public class Event {
    private String mEventName;
    private String mDesc;
    private Date mDate;

    public Event(String name, String description, Date date) {
        this.mEventName = name;
        this.mDesc = description;
        this.mDate = date;
    }

    public String getEventName() {
        return mEventName;
    }
}
