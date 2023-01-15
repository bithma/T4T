package com.example.t4t.database;

public class Event {
    private String name;
    private String desc;
    private String date;
    private String location;
    private String tags;
    private String group;

    public Event() {}

    public Event(String name, String desc, String date, String location, String tags, String group) {
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.location = location;
        this.tags = tags;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public String getDescription() {
        return mDesc;
    }
    public Date getDate() {
        return mDate;
    }
}
