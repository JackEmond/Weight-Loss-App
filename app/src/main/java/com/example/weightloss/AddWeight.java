package com.example.weightloss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddWeight extends AppCompatActivity {

    Button btnSubmit;
    EditText inputWeight, inputDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weight);

    btnSubmit = findViewById(R.id.btnSubmit);
    inputWeight = findViewById(R.id.inputWeight);
    inputDate = findViewById(R.id.inputDate);

    btnSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            WeightLossModel weightLossModel = new WeightLossModel(-1, Integer.parseInt(inputWeight.getText().toString()), Integer.parseInt(inputDate.getText().toString()));
            Toast.makeText(AddWeight.this, weightLossModel.toString(), Toast.LENGTH_SHORT).show();
        }
    });
    }
}