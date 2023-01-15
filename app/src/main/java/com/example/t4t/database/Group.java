package com.example.t4t.database;

public class Group {
    private String name;
    private String desc;
    private String type;
    private String link;
    private String faculty;

    public Group() {}

    public Group(String name, String desc, String type, String link, String faculty) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.link = link;
        this.faculty = faculty;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
