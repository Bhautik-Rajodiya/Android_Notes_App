package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notesapp.adpter.NotesAdpter;
import com.example.notesapp.databinding.ActivityMainBinding;
import com.example.notesapp.model.NotesModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
   static List<NotesModel> notesModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddNotesActivit.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        NotesAdpter adpter= new NotesAdpter(this,notesModelList);
        binding.notesRecycler.setAdapter(adpter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        binding.notesRecycler.setLayoutManager(lm);

    }
}