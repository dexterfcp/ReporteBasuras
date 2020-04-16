package com.fcp.reportebasuras.nuevaspantallas.admin.verificarestadisticas;

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

public class VerificarEstadisticasFragment extends Fragment {

    private VerificarEstadisticasViewModel verificarEstadisticasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        verificarEstadisticasViewModel =
                ViewModelProviders.of(this).get(VerificarEstadisticasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_verificar_estadisticas, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        verificarEstadisticasViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}