package com.example.mobile_app.ui.vaccination;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.installations.Utils;

import org.jetbrains.annotations.NotNull;

public class ReadAppointmentActivity extends AppCompatActivity {

    //Data base reference
    private DatabaseReference dbref;
    //Declare group for data base
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readappointment);

        //Change the title on the bar above layout
        getSupportActionBar().setTitle("My Appointment");

        DatabaseReference dbref= FirebaseDatabase.getInstance().getReference(USER_KEY);

        // Get the reference to the data base
        /*final DatabaseReference reference= FirebaseDatabase.getInstance().getReference(USER_KEY);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Declaration of variables
                TextView tvName = findViewById(R.id.tvname);
                TextView tvSurname = findViewById(R.id.tvsurname);
                TextView tvAmka = findViewById(R.id.tvamka);
                TextView tvTel = findViewById(R.id.tvtel);
                TextView tvEmail = findViewById(R.id.tvemail);
                TextView tvDate = findViewById(R.id.tvdate);
                TextView tvTime = findViewById(R.id.tvtime);

                String n = "";
                String s = "";
                String a = "";
                String p = "";
                String e = "";
                String d = "";
                String t = "";

                //EditText etamka = findViewById(R.id.inAmka);
                //String amka = etamka.getText().toString();


                    //In the end we have the last insertion which we show
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        //We need somebody specific
                        //Vaccination v = snapshot.getValue(Vaccination.class);

                        /*if (v.getAmka().equals(amka)) {
                            n = v.getName();
                            s = v.getSurname();
                            a = v.getAmka();
                            p = v.getPhone();
                            e = v.getEmail();
                            d = v.getDate();
                            t = v.getTime();
                       // }*/
/*
                            //This gets the last entry to database
                                n = snapshot.child("name").getValue().toString();
                                s = snapshot.child("surname").getValue().toString();
                                a = snapshot.child("amka").getValue().toString();
                                p = snapshot.child("phone").getValue().toString();
                                e = snapshot.child("email").getValue().toString();
                                d = snapshot.child("date").getValue().toString();
                                t = snapshot.child("time").getValue().toString();

                    }


                tvName.setText(n);
                tvSurname.setText(s);
                tvAmka.setText(a);
                tvTel.setText(p);
                tvEmail.setText(e);
                tvDate.setText(d);
                tvTime.setText(t);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.d("FIREBASE CRUD", databaseError.getMessage());
            }
        });*/

    }

    public void onClickEdit(View view){

        //Declaration of Variables
        EditText inAmka = findViewById(R.id.iAmka);
        String amka = inAmka.getText().toString();

        TextView tvName = findViewById(R.id.tvname);

        dbref= FirebaseDatabase.getInstance().getReference(amka);

        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                TextView tvName = findViewById(R.id.tvname);
                TextView tvSurname = findViewById(R.id.tvsurname);
                TextView tvAmka = findViewById(R.id.tvamka);
                TextView tvTel = findViewById(R.id.tvtel);
                TextView tvEmail = findViewById(R.id.tvemail);
                TextView tvDate = findViewById(R.id.tvdate);
                TextView tvTime = findViewById(R.id.tvtime);

                //Declaration of Variables
                EditText inAmka = findViewById(R.id.iAmka);
                String amka = inAmka.getText().toString();

                String n = "";
                String s = "";
                String p = "";
                String e = "";
                String d = "";
                String t = "";

                for (DataSnapshot sn : snapshot.getChildren()){

                    Vaccination v = snapshot.getValue(Vaccination.class);

                    n = v.getName();
                    s = v.getSurname();
                    p = v.getPhone();
                    e = v.getEmail();
                    d = v.getDate();
                    t = v.getTime();

                }

                tvName.setText(n);
                tvSurname.setText(s);
                tvAmka.setText(amka);
                tvTel.setText(p);
                tvEmail.setText(e);
                tvDate.setText(d);
                tvTime.setText(t);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        //find which child to edit and change values of date and time
        /*for (DataSnapshot snapshot : dataSnapshot.getChildren()){
            if(snapshot.child(amka).equals(amka)){
                //We need somebody specific
                //Vaccination v = snapshot.getValue(Vaccination.class);

                        /*if (v.getAmka().equals(amka)) {
                            n = v.getName();
                            s = v.getSurname();
                            p = v.getPhone();
                            e = v.getEmail();
                            d = v.getDate();
                            t = v.getTime();
            }
        }*/

       /* n = dbref.child("name").get().toString();
        s = dbref.child("surname").get().toString();
        p = dbref.child("phone").get().toString();
        e = dbref.child("email").get().toString();
        d = dbref.child("date").get().toString();
        t = dbref.child("time").get().toString();

        tvName.setText(n);
        tvSurname.setText(s);
        tvAmka.setText(amka);
        tvTel.setText(p);
        tvEmail.setText(e);
        tvDate.setText(d);
        tvTime.setText(t);*/

        //tvName.setText(dbref.child("name").getKey());

        //Shows a message
        Toast.makeText(this, "Successful.", Toast.LENGTH_SHORT).show();
    }
}
