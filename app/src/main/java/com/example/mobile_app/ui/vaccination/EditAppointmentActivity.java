package com.example.mobile_app.ui.vaccination;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class EditAppointmentActivity extends AppCompatActivity {

    //Data base reference
    private DatabaseReference dbref;
    //Declare group for data base
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editappointment);

        //Change the title on the bar above layout
        getSupportActionBar().setTitle("Edit Appointment");

        // Get the reference to the data base
        //dbref = FirebaseDatabase.getInstance().getReference(USER_KEY);

       /* dbref.child(USER_KEY).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                //Gets edit text from the activity_editappointment.xml

                //Declaration of Variables
                EditText inDate = findViewById(R.id.inpDate);
                EditText inTime = findViewById(R.id.inpTime);

                String dt = inDate.getText().toString();
                String tm = inTime.getText().toString();

                EditText inAmka = findViewById(R.id.inpAmka);
                String amka = inAmka.getText().toString();

                if(!TextUtils.isEmpty(amka)){
                    if(snapshot.exists() && snapshot.getChildrenCount() > 0){
                        for (DataSnapshot sn : snapshot.getChildren()) {

                            //Vaccination v = sn.getKey();
                            if (sn.getKey().equals(amka)) {
                                //sn.child(amka)
                                dbref.
                                //sn.child(amka).setTime(tm);
                            }

                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                Log.d("FIREBASE CRUD", error.getMessage());

            }
        });*/

    }

    public void onClickEdit(View view){

        //Declaration of Variables
        EditText inDate = findViewById(R.id.inpDate);
        EditText inTime = findViewById(R.id.inpTime);

        String dt = inDate.getText().toString();
        String tm = inTime.getText().toString();


        EditText inAmka = findViewById(R.id.iAmka);
        String amka = inAmka.getText().toString();

        //Get the reference to the data base
        dbref = FirebaseDatabase.getInstance().getReference(USER_KEY);

        String key = dbref.child(amka+"data").push().getKey();


        Map<String, Object> updates = new HashMap<String,Object>();

        updates.put("date", dt);
        updates.put("time", tm);

        dbref.updateChildren(updates);

        //Change date time in database
        //dbref.child(amka+"data").child("date").setValue(dt);
        //dbref.child(amka+"data").child("time").setValue(tm);


        //Shows a message
        Toast.makeText(this, "Successful changes.", Toast.LENGTH_SHORT).show();
    }

}