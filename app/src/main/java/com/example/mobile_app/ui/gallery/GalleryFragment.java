package com.example.mobile_app.ui.gallery;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobile_app.R;

public class GalleryFragment extends Fragment {

    //Grid declaration
    GridView gv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the View Layout
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Select Grid View
        gv = root.findViewById(R.id.grid_view);

        // Set image adapter to the Grid View
        gv.setAdapter(new ImageAdapter(getActivity()));

        // When user clicks on an image in grid view, we make a new intent that goes to FullScreenActivity
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), GalleryFullScreen.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });

        return root;

    }

}