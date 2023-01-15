package com.example.t4t.database;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;

public class DBHelper {
    public static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    private static final String TAG = "DBHelper";

    public static void CreateStudent(Student stu) {
        mDatabase.child("students").child(stu.getEmail()).setValue(stu);
    }

    public static void CreateEvent(Event event) {
        mDatabase.child("events").child(event.getName()).setValue(event);
    }

    public static void CreateGroup(Group group) {
        mDatabase.child("groups").child(group.getName()).setValue(group);
    }

    public static void UpdateHearts(String name, int likes) {
        Log.v("blah", "HEREEEEEEEEEE");
        mDatabase.getRef().child("events").child(name).child("hearts").setValue(likes);
    }
}
