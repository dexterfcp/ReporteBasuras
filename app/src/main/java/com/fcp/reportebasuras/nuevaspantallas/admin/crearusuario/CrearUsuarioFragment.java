package com.fcp.reportebasuras.nuevaspantallas.admin.crearusuario;

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

public class CrearUsuarioFragment extends Fragment {

    private CrearUsuarioViewModel crearUsuarioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        crearUsuarioViewModel =
                ViewModelProviders.of(this).get(CrearUsuarioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crear_usuario, container, false);

        return root;
    }
}