package com.example.t4t;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.t4t.database.DBHelper;
import com.example.t4t.database.Event;
import com.example.t4t.database.Group;
import com.example.t4t.database.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class main extends Fragment {

    private static final String TAG = "Main";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button bTitle, bDesc, bGroup, bLocation, bDate, bNumLikes;
    private Button bPrev, bNext;
    private Button bHeart, bTeams, bNotifications, bFeedback;

    private Button bLike;
    private ArrayList<Event> events = new ArrayList<>();
    private int index = 0;
    private boolean liked = false;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public main() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment main.
     */
    // TODO: Rename and change types and number of parameters
    public static main newInstance(String param1, String param2) {
        main fragment = new main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        bTitle = view.findViewById(R.id.title);
        bDesc = view.findViewById(R.id.description);
        bGroup = view.findViewById(R.id.group);
        bLocation = view.findViewById(R.id.location);
        bDate = view.findViewById(R.id.date);
        bPrev = view.findViewById(R.id.prev);
        bNext = view.findViewById(R.id.next);
        bHeart = view.findViewById(R.id.heart);
        bTeams = view.findViewById(R.id.teams);
        bNotifications = view.findViewById(R.id.notification);
        bFeedback = view.findViewById(R.id.feedback);
        bNumLikes = view.findViewById(R.id.numlikes);
        bLike = view.findViewById(R.id.bLike);
        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = index>0?index-1:index;
                updateCard();
            }
        });
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = index<events.size()-1?index+1:index;
                updateCard();
            }
        });
        bHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(main.this)
                        .navigate(R.id.action_fragmentmain_to_teamssaved);
            }
        });
        bTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(main.this)
                        .navigate(R.id.action_fragmentmain_to_fragmentteams);
            }
        });
        bNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(main.this)
                        .navigate(R.id.action_fragmentmain_to_fragmentnotifications);
            }
        });
        bFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(main.this)
                        .navigate(R.id.action_FirstFragment_to_fragmentmain2);
            }
        });

        bLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCard();
            }
        });
        loadEvents();
        return view;
    }

    public void loadEvents() {
        Query test = FirebaseDatabase.getInstance().getReference("events")
                .orderByChild("name");
        test.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                        events.add(snap.getValue(Event.class));
                    }
                } else {
                    Log.v(TAG, "NO EVENTS!");
                }
                Log.v(TAG, "STRING "+events.get(0).getDate());
                updateCard();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
    }

    public void updateCard() {
        Event e = events.get(index);
        bTitle.setText(e.getName());
        bDesc.setText(e.getDesc());
        bGroup.setText(e.getGroup());
        bLocation.setText(e.getLocation());
        bDate.setText(e.getDate());
        bNumLikes.setText(e.getHearts());


        Query teamQuery = FirebaseDatabase.getInstance().getReference("events")
                .orderByChild("name");

        teamQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                        Event event = snap.getValue(Event.class);
                        if (event.getName() == e.getName()) {
                            int curr_hearts = event.getHearts();
                            DBHelper.UpdateHearts(e.getName(),curr_hearts + 1);
                        }
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}