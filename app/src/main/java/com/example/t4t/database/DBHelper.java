package com.example.t4t.database;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DBHelper {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    private static final String TAG = "DBHelper";

    public void writeNewStudent(Student stu) {
        mDatabase.child("students").child(stu.getEmail()).setValue(stu);
    }

    public void writeNewEvent(Event event) {
        mDatabase.child("events").child(event.getEventName()).setValue(event);
    }

    public void writeNewGroup(Group group) {
        mDatabase.child("groups").child(group.getTeamName()).setValue(group);
    }

    public Student getStudent(String email) {
        DatabaseReference ref = mDatabase.child("students");
        Student student;
        Query studentQuery = ref.orderByChild("mEmail").equalTo(email);
        studentQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    //student = singleSnapshot.getValue(Student.class);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
        return null;
    }
}
