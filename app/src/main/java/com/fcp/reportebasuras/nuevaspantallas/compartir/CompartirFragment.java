package com.fcp.reportebasuras.nuevaspantallas.compartir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.fcp.reportebasuras.R;

public class CompartirFragment extends Fragment {

    private CompartirViewModel compartirViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        compartirViewModel =
                ViewModelProviders.of(this).get(CompartirViewModel.class);
        View root = inflater.inflate(R.layout.fragment_compartir, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        compartirViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}