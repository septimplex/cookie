package com.example.cookie2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, naslov;

    CustomAdapter(Context context, ArrayList id, ArrayList naslov){
        this.context = context;
        this.id = id;
        this.naslov = naslov;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idT, naslovT;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            idT = itemView.findViewById(R.id.id);
            naslovT = itemView.findViewById(R.id.naslov);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //uzima sve podatke iz arrays/ umece text u textview
        holder.idT.setText(String.valueOf(id.get(position)));
        holder.idT.setText(String.valueOf(naslov.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }


}
