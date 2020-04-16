package com.fcp.reportebasuras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.fcp.reportebasuras.modelo.dao.ReporteDAO;
import com.fcp.reportebasuras.modelo.dao.UsuarioDAO;
import com.fcp.reportebasuras.modelo.vo.Reporte;
import com.fcp.reportebasuras.modelo.vo.Usuario;
import com.fcp.reportebasuras.utils.MailJob;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NuevoReporte extends AppCompatActivity {

    ImageButton btnImagen;
    Bitmap bmp;
    LocationManager locationManager;
    private double longitudeBest;
    private double latitudeBest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_reporte);
        checkCameraPermission();
        checkPositionPermission();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        isLocationEnabled();

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);

        String provider = locationManager.getBestProvider(criteria, true);
        System.out.println(provider);
        if (provider != null){
            locationManager.requestLocationUpdates(provider, 1000, 10, locationListenerBest);
            Toast.makeText(this, "Best Provider is " + provider, Toast.LENGTH_LONG).show();
        }


        Button btnCancelar = findViewById(R.id.btn_cancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnImagen = findViewById(R.id.btn_imagenrep);
        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Activar Camara.
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);
            }
        });

        Button btnEnviar = findViewById(R.id.btn_enviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarCorreo();
            }
        });
    }

    private final LocationListener locationListenerBest = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitudeBest = location.getLongitude();
            latitudeBest = location.getLatitude();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }

        @Override
        public void onProviderEnabled(String s) {
        }

        @Override
        public void onProviderDisabled(String s) {
        }
    };

    @SuppressLint("MissingPermission")
    private void enviarCorreo() {
        Reporte reporte = new Reporte();
        EditText texto = findViewById(R.id.txt_reporte);



        String lat= "" + latitudeBest;
        String lgt= "" + longitudeBest;
        UsuarioDAO dao = new UsuarioDAO(getApplicationContext());
        Usuario usu = dao.consultarUsuarioUnico();

        reporte.setMensaje("Enviado por :"+usu.getNombres() +" \n\n Correo : "+usu.getCorreo()+"\n\n" + texto.getText().toString() + "\n\n https://maps.google.com/?q="+lat+","+lgt);
        reporte.setTipomensaje(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        ByteArrayOutputStream outp = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG,100, outp );

        new MailJob("applimpiandocolombia@gmail.com", "limpiacol").execute(
                new MailJob.Mail("applimpiandocolombia@gmail.com", "camaraambientaldelplastico@gmail.com", "Reporte Limpiando Colombia "+new SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()), reporte.getMensaje(),outp.toByteArray())
        );
        ReporteDAO daoRep = new ReporteDAO(getApplicationContext());
        daoRep.insert(reporte);
        AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
        alertDialog.setTitle("Mensaje");
        alertDialog.setMessage("Su reporte a sido enviado y sera gestionado lo antes posible");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
        Toast.makeText(this, "Reporte Generado", Toast.LENGTH_LONG).show();
        onBackPressed();

    }


    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode== Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            bmp = (Bitmap)ext.get("data");
            Principal.imagenEnviar  = (Bitmap)ext.get("data");
            btnImagen.setImageBitmap(bmp);
            btnImagen.setAdjustViewBounds(true);
        }
    }

    public void checkCameraPermission(){
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Reporte", "No se tiene permiso para la camara!.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 225);
        } else {
            Log.i("Reporte", "Tienes permiso para usar la camara.");
        }
    }

    public void checkPositionPermission(){
        int permissionCheck1 = ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck2 = ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck1 != PackageManager.PERMISSION_GRANTED || permissionCheck2 != PackageManager.PERMISSION_GRANTED) {
            Log.i("Reporte", "No se tiene permiso para la localizacion!.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 226);
        } else {
            Log.i("Reporte", "Tienes permiso para usar la localizacion.");
        }
    }
}
