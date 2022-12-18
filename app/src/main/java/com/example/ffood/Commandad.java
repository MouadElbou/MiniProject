package com.example.ffood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Commandad extends RecyclerView.Adapter<Commandad.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Commande> CommandArrayList;
    private Context context;


    // constructor
    public Commandad(ArrayList<Commande> RestoArrayList, Context context ) {
        this.CommandArrayList = RestoArrayList;
        this.context = context;
           }

    @NonNull
    @Override
    public Commandad.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restoadapter, parent, false);
        return new Commandad.ViewHolder(view,null);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        // returning the size of our array list
        return CommandArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        // creating variables for our text views.
        private TextView t1, t2, t3, t4,t5,t6;
        RestoAdapter.onckick onckick;

        public ViewHolder(@NonNull View itemView, RestoAdapter.onckick onckick) {
            super(itemView);
            // initializing our text views
            t1 = itemView.findViewById(R.id.c);
            t2 = itemView.findViewById(R.id.c1);
            t3 = itemView.findViewById(R.id.c2);
            t4 = itemView.findViewById(R.id.c3);
            t5 =itemView.findViewById(R.id.c4);
            t6 =itemView.findViewById(R.id.c5);
            this.onckick=onckick;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onckick.onRestoClick(getAdapterPosition());
        }
    }}