package com.example.t4t.database;

public class Student {
    private String mEmail;
    private String mPassword;
    private String mSchool;
    private String mPreferences;
    private String mMisc;

    public Student(String email, String password, String school, String preferences, String misc) {
        this.mEmail = email;
        this.mPassword = password;
        this.mSchool = school;
        this.mPreferences = preferences;
        this.mMisc = misc;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getPreferences() {
        return this.mPreferences;
    }
}
