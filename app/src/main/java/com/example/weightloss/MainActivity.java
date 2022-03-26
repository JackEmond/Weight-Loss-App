package com.example.weightloss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button addWeightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make it so the Add Weight button on the home page goes to the AddWeight Activity page
        addWeightButton = (Button) findViewById(R.id.btnAddWeight);
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

}