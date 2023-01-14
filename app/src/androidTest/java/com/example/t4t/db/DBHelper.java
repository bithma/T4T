package com.example.t4t.db;

public class DBHelper {
    private DatabaseReference mDatabase;

    mDatabase = FirebaseDatabase.getInstance().getReference();

    public void writeNewStudent(Students stu) {
        mDatabase.child("students").child(stu.getEmail()).setValue(stu);
    }

    public void writeNewEvent() {

    }

    public void writeNewGroup() {

    }

    public Student getStudent(String email) {
        databaseReference ref = mDatabase.child("students");

        Query studentQuery = ref.orderByChild(mString).equalTo(email);
        studentQuery.addListenerForSingleValueEvent(new ValueEventListner () {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    Students stu = singleSnapshot.getValue(Students.class);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
        return stu;
    }
}
