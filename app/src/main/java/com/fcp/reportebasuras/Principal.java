package com.fcp.reportebasuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.fcp.reportebasuras.adptadoreslistas.AdaptadorReportes;
import com.fcp.reportebasuras.modelo.dao.ReporteDAO;

public class Principal extends AppCompatActivity {


    public static Bitmap imagenEnviar;

    private ListView listaMensajes;
    private AdaptadorReportes adaptadorGenericoReportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listaMensajes = (ListView) findViewById(R.id.listaReportes);
        adaptadorGenericoReportes = new AdaptadorReportes(this);
        ReporteDAO dao = new ReporteDAO(getApplicationContext());
        adaptadorGenericoReportes.getListaOpciones().addAll(dao.consultarGlobal());
        listaMensajes.setAdapter(adaptadorGenericoReportes);
        listaMensajes.setSelection(adaptadorGenericoReportes.getListaOpciones().size()-1);

        Button btnNuevoReporte = findViewById(R.id.btn_reporte);
        btnNuevoReporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantallaPrincipal = new Intent(getApplicationContext(), NuevoReporte.class);
                startActivity(pantallaPrincipal);
            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
