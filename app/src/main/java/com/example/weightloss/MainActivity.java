package com.example.weightloss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
    private RecyclerView rvWeights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Make it so the Add Weight button on the home page goes to the AddWeight Activity page
        addWeightButton = (Button) findViewById(R.id.btnAddWeight); //Initialize Button
        addWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddWeightPage();
            }
        });

        rvWeights = findViewById(R.id.rvWeights); //Initialize Button
        DataBaseHelper  dataBaseHelper = new DataBaseHelper(MainActivity.this);
        ArrayList<WeightLossModel> everyone = (ArrayList<WeightLossModel>) dataBaseHelper.getAll();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, everyone);
        rvWeights.setAdapter(adapter);
        rvWeights.setLayoutManager(new LinearLayoutManager(this));

        //Adapter weightLossArrayAdapter = new ArrayAdapter<WeightLossModel>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
        //rvWeights.setAdapter((RecyclerView.Adapter) weightLossArrayAdapter);
    }


    public void setUpWeightLossModel(){

    }


    public void openAddWeightPage(){
        Intent intent = new Intent(this, AddWeight.class);
        startActivity(intent);
    }

}