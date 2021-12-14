package com.example.makhrijal_hurf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyViewHolder> {
    List<Question> questionsList;

    public myRecyclerViewAdapter(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_record, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.data = questionsList.get(position);
        holder.textViewLetter.setText(holder.data.getLetter());
        holder.textViewMarked.setText(String.valueOf(holder.data.getMarked()));
        holder.textViewAnswer.setText(holder.data.getAnswer());
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewLetter;
        TextView textViewMarked;
        TextView textViewAnswer;
        Question data;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAnswer=itemView.findViewById(R.id.answer);
            textViewLetter=itemView.findViewById(R.id.letter);
            textViewMarked=itemView.findViewById(R.id.marked);
        }
    }
}
