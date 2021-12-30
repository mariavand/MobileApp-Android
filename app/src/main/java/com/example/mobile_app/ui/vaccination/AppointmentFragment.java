package com.example.mobile_app.ui.vaccination;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobile_app.R;
import com.example.mobile_app.ui.gallery.GalleryFullScreen;
import com.example.mobile_app.ui.stat.JSONDownloader;

public class AppointmentFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_appontment, container, false);

        //Assigning 4 buttons from fragment_appontment.xml
        Button btnAdd = root.findViewById(R.id.btnAdd);
        Button btnEdit = root.findViewById(R.id.btnEdit);
        Button btnDelete = root.findViewById(R.id.btnDelete);
        Button btnRead = root.findViewById(R.id.btnRead);

        //Setting Listeners on buttons
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AppointmentActivity.class);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditAppointmentActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DelAppointmentActivity.class);
                startActivity(intent);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReadAppointmentActivity.class);
                startActivity(intent);
            }
        });

        //Returns view
        return root;
    }
}
