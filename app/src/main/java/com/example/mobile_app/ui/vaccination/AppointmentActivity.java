package com.example.mobile_app.ui.vaccination;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppointmentActivity extends AppCompatActivity {

    //Data base reference
    private DatabaseReference dbref;
    //Declare group for data base
    private String USER_KEY = "User";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        //Change the title on the bar above layout
        getSupportActionBar().setTitle("Create Appointment");

        // Get the reference to the data base
        dbref = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    public void onClickSave(View view){

        //Gets edit texts from the activity_appointment.xml
        EditText inName = findViewById(R.id.inputName);
        EditText inSurname = findViewById(R.id.inputSurname);
        EditText inAmka = findViewById(R.id.inputAmka);
        EditText inPhone = findViewById(R.id.inputTelephone);
        EditText inEmail = findViewById(R.id.inputEmail);
        EditText inDate = findViewById(R.id.inputDate);
        EditText inTime = findViewById(R.id.inputTime);

        //Id is declared by the database


        //Stringify edit texts to strings to work with
        String name = inName.getText().toString();
        String surname = inSurname.getText().toString();
        String amka = inAmka.getText().toString();
        String tel = inPhone.getText().toString();
        String email = inEmail.getText().toString();
        String date = inDate.getText().toString();
        String time = inTime.getText().toString();

        //Creating the object that will be added to data base
        Vaccination vac = new Vaccination(name, surname, amka, tel, email, date, time);

        //Checking if there are any empty fields
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(surname) && !TextUtils.isEmpty(amka) && !TextUtils.isEmpty(tel) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(date) && !TextUtils.isEmpty(time)){
            //Add to data base
            dbref.child(amka+"data").setValue(vac);
            //Show message to user
            Toast.makeText(this, "Request Accepted.", Toast.LENGTH_SHORT).show();
        }
        else{
            //Show message to user
            Toast.makeText(this, "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        }
    }
}