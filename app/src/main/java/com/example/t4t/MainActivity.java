package com.example.t4t;

import android.os.Bundle;

import com.example.t4t.database.DBHelper;
import com.example.t4t.database.Event;
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

        /* Student test = new Student("rd@example,com", "McMaster", "nothing", "qw");
        Student test1 = new Student("alshehak@mcmaster,ca", "McMaster", "", "qw");
        Student test2 = new Student("alib10@mcmaster,ca", "McMaster", "", "qw");
        Student test3 = new Student("davidr@mcmaster,ca", "McMaster", "", "qw");
        Student test4 = new Student("bsbt55@mcmaster,ca", "McMaster", "", "qw");

        DBHelper.CreateStudent(test);
        DBHelper.CreateStudent(test1);
        DBHelper.CreateStudent(test2);
        DBHelper.CreateStudent(test3);
        DBHelper.CreateStudent(test4); */

//       Event event1 = new Event ("Yoga Night", "Want to destrss and decopompress? Come join us for a fun night of yoga!", "Jan 17, 2023","DABC", "Engineeing","WIE");
//       Event event2 = new Event ("Health Sciences Charity Event  ", "Come join us for a fun event to support children", "March 19, 2023","HSL", "Health Sciences","Sciences");
//       Event event3 = new Event ("Board Games", "Join us for our board games social!", "Feb 15, 2023","BSB 135", "Religious / Spiritual ","COCA");
//       Event event4 = new Event ("Cycling class", "Come cycle with us to workout!", "April 1st, 2022","DABC", "Sports/Fitness","WIE");
//       DBHelper.CreateEvent(event1);
//       DBHelper.CreateEvent(event2);
//       DBHelper.CreateEvent(event3);
//       DBHelper.CreateEvent(event3);


        setSupportActionBar(binding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}