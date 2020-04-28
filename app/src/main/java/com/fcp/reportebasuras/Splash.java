package com.fcp.reportebasuras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.fcp.reportebasuras.modelo.dao.UsuarioDAO;
import com.fcp.reportebasuras.modelo.vo.Usuario;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SYSTEM_ALERT_WINDOW,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.CAMERA}, 225);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                UsuarioDAO daoUsu = new UsuarioDAO(getApplicationContext());
                Usuario vo = daoUsu.consultarUsuarioUnico();
                if(vo != null) {
                    Intent pantallaPrincipal = new Intent(getApplicationContext(), Terminos.class);
                    startActivity(pantallaPrincipal);
                }else{
                    Intent pantallaPrincipal = new Intent(getApplicationContext(), Terminos.class);
                    startActivity(pantallaPrincipal);
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }
}
