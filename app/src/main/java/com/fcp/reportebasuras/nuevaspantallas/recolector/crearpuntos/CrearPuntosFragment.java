package com.fcp.reportebasuras.nuevaspantallas.recolector.crearpuntos;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fcp.reportebasuras.R;

public class CrearPuntosFragment extends Fragment {

    private CrearPuntosViewModel mViewModel;

    private Button btnCrearPuntos;


    public static CrearPuntosFragment newInstance() {
        return new CrearPuntosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.crear_puntos_fragment, container, false);
        btnCrearPuntos = root.findViewById(R.id.btn_crear_puntos);
        btnCrearPuntos.setOnClickListener(clickBotonCreatPuntos());
        return root;
    }

    private View.OnClickListener clickBotonCreatPuntos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textoPuntos = ((View)v.getParent()).findViewById(R.id.txt_crear_puntos);
                
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CrearPuntosViewModel.class);
        // TODO: Use the ViewModel
    }

}
