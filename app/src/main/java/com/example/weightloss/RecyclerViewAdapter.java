package com.example.weightloss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

   Context context;
   ArrayList<WeightLossModel> weightLossModel;


   public  RecyclerViewAdapter(Context context, ArrayList<WeightLossModel> weightLossModel){
      this.context = context;
      this.weightLossModel = weightLossModel;

   }
;
   @NonNull
   @Override
   public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     // designing rows
      LayoutInflater inflater = LayoutInflater.from(context);
      View view = inflater.inflate(R.layout.rv_row, parent, false);
      return new RecyclerViewAdapter.MyViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
   // binding values to rows
      holder.weight.setText(String.valueOf(weightLossModel.get(position).getWeight()));
      holder.date.setText(String.valueOf(weightLossModel.get(position).getDate()));

   }

   @Override
   public int getItemCount() {
      //how many items in total
      return weightLossModel.size();
   }

   public static class MyViewHolder extends  RecyclerView.ViewHolder{
      // Grab views and assign to variables

      TextView weight, date;

      public MyViewHolder(@NonNull View itemView) {
         super(itemView);

         weight = itemView.findViewById(R.id.txtWeightRV);
         date = itemView.findViewById(R.id.txtDateRV);


      }
   }
}
