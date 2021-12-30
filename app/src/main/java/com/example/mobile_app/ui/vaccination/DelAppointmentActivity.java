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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class DelAppointmentActivity extends AppCompatActivity {

    //Data base reference
    private DatabaseReference dbref;
    //Declare group for data base
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delappointment);

        //Change the title on the bar above layout
        getSupportActionBar().setTitle("Delete Appointment");

        // Get the reference to the data base
        dbref = FirebaseDatabase.getInstance().getReference(USER_KEY);

    }

    public void onClickDelete(View view){

        //Gets edit text from the activity_delappointment.xml
        EditText inAmka = findViewById(R.id.iAmka);
        String amka = inAmka.getText().toString();

        //If it is not null, delete, show a message
        //Otherwise, user should insert amka
        if(!TextUtils.isEmpty(amka)){
            dbref.child(amka+"data").removeValue();
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "All fields are mandatory.", Toast.LENGTH_SHORT).show();
        }
    }
}