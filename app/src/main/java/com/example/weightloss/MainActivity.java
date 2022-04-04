package com.example.weightloss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addWeightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addRecyclerView();

        // Make it so the Add Weight button on the home page goes to the AddWeight Activity page
        addWeightButton = (Button) findViewById(R.id.btnAddWeight); //Initialize Button
        addWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddWeightPage();
            }
        });



    }


    public void openAddWeightPage(){
        Intent intent = new Intent(this, AddWeight.class);
        startActivity(intent);
    }


    public void addRecyclerView(){
        RecyclerView rvWeights = findViewById(R.id.rvWeights); //Initialize Button

        //Get items in database as an Array List
        DataBaseHelper  dataBaseHelper = new DataBaseHelper(MainActivity.this);
        ArrayList<WeightLossModel> everyone = (ArrayList<WeightLossModel>) dataBaseHelper.getAll();

        //Create adapter with list of weights
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, everyone);
        rvWeights.setAdapter(adapter);
        rvWeights.setLayoutManager(new LinearLayoutManager(this));

    }

}