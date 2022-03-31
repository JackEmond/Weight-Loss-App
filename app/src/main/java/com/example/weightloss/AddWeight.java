package com.example.weightloss;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormatSymbols;


public class AddWeight extends AppCompatActivity {

    private static final String TAG = "Add Weight";
    Button btnSubmit;
    EditText inputWeight;
    private TextView txtDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    long dateLong; // used to store date as a long which is how it is stored in the database


    protected  void settxtDateAsCurrentDate(){
        Calendar c = Calendar.getInstance();
        dateLong = c.getTimeInMillis(); //Store time in long so you can store in database
        Date dt = c.getTime(); //Get the current time
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy", Locale.getDefault()); //format date
        String formattedDate = df.format(dt); // convert to string
        txtDate.setText(formattedDate);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weight);

        //Initialize Buttons
        btnSubmit = findViewById(R.id.btnSubmit);
        inputWeight = findViewById(R.id.inputWeight);

        // Initialize the date text and set the Date as the Current Date
        txtDate = (TextView) findViewById(R.id.txtDate);
        settxtDateAsCurrentDate();



        //pop up the Calendar when the Date Text is clicked
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddWeight.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day );

                //Show Date Picker
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });



        // Change the date text
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //store new calendar date as a long date to store in database
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, day);
                dateLong = cal.getTimeInMillis();

                // Convert a long back to a date
                // SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                // String dateString = formatter.format(new Date(dateLong));
                // Toast.makeText(AddWeight.this, "Date = " + dateString, Toast.LENGTH_SHORT).show();

                //Set
                String formattedMonth = new SimpleDateFormat("MMM").format(cal.getTime());
                String date =  formattedMonth + " " + day + " " + year;
                txtDate.setText(date);
            }
        };

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWeightToDatabase();
                openMainActivity();
            }
        });
    }



    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public void addWeightToDatabase(){
        WeightLossModel weightLossModel;

        try{
            weightLossModel = new WeightLossModel(-1, Float.parseFloat(inputWeight.getText().toString()), dateLong);

        }
        catch(Exception e){
            Toast.makeText(AddWeight.this, "Please fill in your weight", Toast.LENGTH_SHORT).show();
            weightLossModel = new WeightLossModel(-1, 0, 0);
        }

        DataBaseHelper dataBaseHelper = new DataBaseHelper(AddWeight.this);
        boolean success = dataBaseHelper.addOne(weightLossModel);
    }
}