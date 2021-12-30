package com.example.mobile_app.ui.stat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobile_app.R;
import com.example.mobile_app.databinding.FragmentStatBinding;

public class StatFragment extends Fragment{

    private FragmentStatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentStatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Fields from the layout with dates by user
        EditText datefrom = root.findViewById(R.id.date_from);
        EditText dateto = root.findViewById(R.id.date_to);

        // These fields will show the Statistical results of vaccination
        TextView resemv = root.findViewById(R.id.res_emv);
        TextView resemva = root.findViewById(R.id.res_emva);
        TextView resemvb = root.findViewById(R.id.res_emvb);
        TextView restotal = root.findViewById(R.id.res_sunemv);

        // Matching a button to a listener and (after connection) downloading the JSON data
        Button btn = root.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(root.getContext(), datefrom, dateto, resemv, resemva, resemvb, restotal).execute();
            }
        });

        // Return view
        return root;
    }

}
