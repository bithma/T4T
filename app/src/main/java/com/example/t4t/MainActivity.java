package com.example.t4t;

import android.os.Bundle;

import com.example.t4t.database.DBHelper;
import com.example.t4t.database.Student;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Debug;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.t4t.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Student test = new Student("rd@example,com", "McMaster", "nothing", "qw");
        Student test1 = new Student("alshehak@mcmaster,ca", "McMaster", "", "qw");
        Student test2 = new Student("alib10@mcmaster,ca", "McMaster", "", "qw");
        Student test3 = new Student("davidr@mcmaster,ca", "McMaster", "", "qw");
        Student test4 = new Student("bsbt55@mcmaster,ca", "McMaster", "", "qw");

        DBHelper.CreateStudent(test);
        DBHelper.CreateStudent(test1);
        DBHelper.CreateStudent(test2);
        DBHelper.CreateStudent(test3);
        DBHelper.CreateStudent(test4);

        setSupportActionBar(binding.toolbar);

//        btn_continue = findViewById(R.id.ContinueButton);
//       btn_continue.setOnClickListener(new View.OnClickListener() {
           // @Override

            /*public void onClick(View view) {
                String email = txt_email.getText().toString();
                Log.v("Email", email);
                AppState.email = email;
                Query test = FirebaseDatabase.getInstance().getReference("students")
                        .orderByChild("email")
                        .equalTo(email.replace('.', ','));
                test.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                Student student = snap.getValue(Student.class);
                                Log.v(TAG, "TEST " + student.getEmail());
                                AppState.student = student;

                                  NavHostFragment.findNavController(FirstFragment.this)
                                       .navigate(R.id.action_FirstFragment_to_fragmentmain2);

                            }
                        } else {
                            NavHostFragment.findNavController(FirstFragment.this)
                                    .navigate(R.id.action_FirstFragment_to_SecondFragment);
                            // Create new student
                            // Go to fragment second

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }
                });

            }
        });*/

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}