package com.fcp.reportebasuras.nuevaspantallas.usuario.resumenactividad;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fcp.reportebasuras.R;

public class ResumenActividadFragment extends Fragment {

    private ResumenActividadViewModel mViewModel;

    public static ResumenActividadFragment newInstance() {
        return new ResumenActividadFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.resumen_actividad_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ResumenActividadViewModel.class);
        // TODO: Use the ViewModel
    }

}
