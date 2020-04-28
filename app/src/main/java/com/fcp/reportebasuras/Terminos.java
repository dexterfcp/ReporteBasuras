package com.fcp.reportebasuras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;


public class Terminos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos);
        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.SYSTEM_ALERT_WINDOW,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_WIFI_STATE}, 225);


        WebView webTerminosCondiciones =(WebView) findViewById(R.id.webTerminosCondiciones);
        webTerminosCondiciones.loadUrl("https://fabicastro89.wixsite.com/fabiancastro/t-y-c-limpiando-colombia");
        webTerminosCondiciones.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webTerminosCondiciones.reload();

        final Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        final CheckBox checkAceptar = (CheckBox) findViewById(R.id.checkAceptar);
        btnSiguiente.setEnabled(false);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAceptar.isChecked()) {
                    Intent pantallaRegistro = new Intent(getApplicationContext(), Registro.class);
                    startActivity(pantallaRegistro);
                }
            }
        });

        checkAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAceptar.isChecked()){
                    btnSiguiente.setEnabled(true);
                }else{
                    btnSiguiente.setEnabled(false);
                }
            }
        });

    }
}
