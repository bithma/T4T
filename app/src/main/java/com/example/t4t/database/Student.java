package com.example.t4t.database;

public class Student {
    private String email;
    private String school;
    private String tags;

    private String favs;

    public Student() {}

    public Student(String email, String school, String tags) {
        this.email = email;
        this.school = school;
        this.tags = tags;
    }

    public Student(String email, String school, String tags, String favs) {
        this.email = email;
        this.school = school;
        this.tags = tags;
        this.favs = favs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setFavs(String favs) {
        this.favs += "," + favs;
    }

    public String getFavs() {
        return this.favs;
    }
}
