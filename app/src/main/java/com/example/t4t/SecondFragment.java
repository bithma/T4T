package com.example.t4t;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.t4t.database.DBHelper;
import com.example.t4t.database.Student;
import com.example.t4t.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ContinueButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String school;
                if(AppState.email.contains("@mcmaster.ca"))
                    school = "McMaster University";
                else if(AppState.email.contains("@yorku.ca"))
                    school = "York University";
                else
                    school = "Unknown";
                Student newStudent = new Student(AppState.email.replace('.', ','), school, "NONE");
                DBHelper.CreateStudent(newStudent);
                AppState.student = newStudent;
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}