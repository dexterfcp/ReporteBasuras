package com.fcp.reportebasuras.nuevaspantallas.usuario.solicitarrecoleccion;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fcp.reportebasuras.R;

public class SolicitarRecoleccionFragment extends Fragment {

    private SolicitarRecoleccionViewModel mViewModel;

    public static SolicitarRecoleccionFragment newInstance() {
        return new SolicitarRecoleccionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.solicitar_recoleccion_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SolicitarRecoleccionViewModel.class);
        // TODO: Use the ViewModel
    }

}
