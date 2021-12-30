package com.example.mobile_app.ui.qa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobile_app.R;
import com.example.mobile_app.databinding.FragmentQaBinding;

public class QaFragment  extends Fragment {

    // Variable declaration
    private FragmentQaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_qa, container, false);

        // Creating webview and match it with webview from layout
        WebView wv = v.findViewById(R.id.questansw);

        // Loading quest.html which is a simple html file with Q&A in a list format
        wv.loadUrl("file:///android_asset/quest.html");

        // Returns View
        return v;
    }

}