package com.example.ffood;

import android.view.ViewGroup;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<RestoClass> RestoArrayList;
    private Context context;
    private onckick onckick;

    // constructor
    public RestoAdapter(ArrayList<RestoClass> RestoArrayList, Context context,onckick onckick) {
        this.RestoArrayList = RestoArrayList;
        this.context = context;
        this.onckick=onckick;   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restoadapter, parent, false);
        return new ViewHolder(view,onckick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        RestoClass resto = RestoArrayList.get(position);
        holder.RestoNameTV.setText(resto.getRestoName());
        holder.AdressResto.setText(resto.getAdressResto());
        holder.EmailResto.setText(resto.getEmailResto());
        holder.NumeroResto.setText(resto.getNumeroResto());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return RestoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        // creating variables for our text views.
        private TextView RestoNameTV, AdressResto, EmailResto, NumeroResto;
        onckick onckick;

        public ViewHolder(@NonNull View itemView,onckick onckick) {
            super(itemView);
            // initializing our text views
            RestoNameTV = itemView.findViewById(R.id.idTVCourseName);
            AdressResto = itemView.findViewById(R.id.idTVCourseDescription);
            EmailResto = itemView.findViewById(R.id.idTVCourseDuration);
            NumeroResto = itemView.findViewById(R.id.idTVCourseTracks);
            this.onckick=onckick;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onckick.onRestoClick(getAdapterPosition());
        }
    }
    public interface  onckick{
        void onRestoClick(int position);
    }
}