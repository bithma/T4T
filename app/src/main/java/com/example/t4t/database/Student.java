package com.example.t4t.database;

public class Student {
    private String email;
    private String school;
    private String preferences;
    private String misc;

    public Student() {}

    public Student(String email, String school, String preferences, String misc) {
        this.email = email;
        this.school = school;
        this.preferences = preferences;
        this.misc = misc;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPreferences() {
        return this.preferences;
    }

    public String getSchool() { return  this.school; }

    public String getMisc() { return this.misc; }

    public void setEmail(String email) { this.email = email; }

    public void setPreferences(String preferences) { this.preferences = preferences; }

    public void setSchool(String school) { this.school = school; }

    public void setMisc(String misc) { this.misc = misc; }
}
