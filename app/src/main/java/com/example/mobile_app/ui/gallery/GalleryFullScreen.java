package com.example.mobile_app.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_app.R;


public class GalleryFullScreen extends AppCompatActivity {

    //Declaration of variable
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Setting fullscreen.xml as current View
        setContentView(R.layout.fullscreen);

        // Get image view from layout
        imageView = findViewById(R.id.covid19);

        // Hide Action Bar
        getSupportActionBar().hide();


        // Get Intent from GalleryFragment
        Intent i = getIntent();

        // Get image id from intent
        int position = i.getExtras().getInt("id");

        // Find image based on id
        ImageAdapter imageAdapter = new ImageAdapter(this);

        // Display image
        imageView.setImageResource(imageAdapter.imageArray[position]);
    }
}