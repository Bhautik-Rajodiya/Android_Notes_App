package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.notesapp.databinding.ActivityAddNotesBinding;
import com.example.notesapp.databinding.ActivityMainBinding;
import com.example.notesapp.model.NotesModel;

public class AddNotesActivit extends AppCompatActivity {

    ActivityAddNotesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNotesBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_add_notes);
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String notes = binding.notesText.getText().toString();
                NotesModel model = new NotesModel(notes);
                MainActivity.notesModelList.add(model);
                finish();

            }
        });
    }
}