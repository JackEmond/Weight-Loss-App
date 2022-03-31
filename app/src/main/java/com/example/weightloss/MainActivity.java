package com.example.weightloss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addWeightButton;
    private ListView listWeights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listWeights = findViewById(R.id.lstWeights); //Initialize Button

        // Make it so the Add Weight button on the home page goes to the AddWeight Activity page
        addWeightButton = (Button) findViewById(R.id.btnAddWeight); //Initialize Button
        addWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddWeightPage();
            }
        });


        DataBaseHelper  dataBaseHelper = new DataBaseHelper(MainActivity.this);
        List<WeightLossModel> everyone = dataBaseHelper.getAll();
        ArrayAdapter weightLossArrayAdapter = new ArrayAdapter<WeightLossModel>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
        listWeights.setAdapter(weightLossArrayAdapter);
    }


    public void openAddWeightPage(){
        Intent intent = new Intent(this, AddWeight.class);
        startActivity(intent);
    }

}