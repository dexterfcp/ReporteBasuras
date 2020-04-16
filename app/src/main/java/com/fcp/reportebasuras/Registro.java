package com.fcp.reportebasuras;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fcp.reportebasuras.modelo.dao.UsuarioDAO;
import com.fcp.reportebasuras.modelo.vo.Usuario;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button btnRegistro = findViewById(R.id.btn_registrar);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario user = new Usuario();
                EditText txtUsuario = findViewById(R.id.txt_nombre);
                EditText txtEmail = findViewById(R.id.txt_email);
                user.setCorreo(txtEmail.getText().toString());
                user.setNombres(txtUsuario.getText().toString());
                if(user.getCorreo() != null && !user.getCorreo().isEmpty() &&
                        user.getNombres() != null && !user.getNombres().isEmpty()) {
                    crearUsuarioenDB(user);
                    Intent pantallaPrincipal = new Intent(getApplicationContext(), PrincipalAdmin.class);
                    startActivity(pantallaPrincipal);
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
                    alertDialog.setTitle("Mensaje");
                    alertDialog.setMessage("Por favor registre su nombre y un correo valido");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                            }
                        });
                    alertDialog.show();
                }
            }
        });


    }

    private void crearUsuarioenDB(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(getApplicationContext());
        dao.insert(usuario);
        dao.closeDB();
    }
}
