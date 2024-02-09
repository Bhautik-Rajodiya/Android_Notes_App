package com.example.notesapp.adpter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.R;
import com.example.notesapp.model.NotesModel;

import java.util.ArrayList;
import java.util.List;

public class NotesAdpter extends RecyclerView.Adapter<NotesAdpter.DataViewHolder> {

    Activity activity;
    List<NotesModel> notesModelList = new ArrayList<>();

    public NotesAdpter(Activity activity,List<NotesModel> notesModelList){
        this.activity = activity;
        this.notesModelList = notesModelList;
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(activity).inflate(R.layout.notes_page,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.noteText.setText(notesModelList.get(position).notes);
    }

    @Override
    public int getItemCount() {
        return notesModelList.size();
    }

    class DataViewHolder extends  RecyclerView.ViewHolder{
        LinearLayout tileLiner;
        TextView noteText;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tileLiner = itemView.findViewById(R.id.tileLiner);
            noteText = itemView.findViewById(R.id.noteText);

        }
    }
}
