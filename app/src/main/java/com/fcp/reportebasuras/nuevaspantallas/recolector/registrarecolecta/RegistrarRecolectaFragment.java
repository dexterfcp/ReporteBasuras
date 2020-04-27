package com.fcp.reportebasuras.nuevaspantallas.recolector.registrarecolecta;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fcp.reportebasuras.R;

public class RegistrarRecolectaFragment extends Fragment {

    Button btnCrearPuntos;

    private RegistrarRecolectaViewModel mViewModel;

    public static RegistrarRecolectaFragment newInstance() {
        return new RegistrarRecolectaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registrar_recolecta, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegistrarRecolectaViewModel.class);
        // TODO: Use the ViewModel
    }

}
