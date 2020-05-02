package com.fcp.reportebasuras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fcp.reportebasuras.menuapp.MenuAppRBas;
import com.fcp.reportebasuras.modelo.dao.UsuarioDAO;
import com.fcp.reportebasuras.modelo.vo.Usuario;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

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
                TextInputLayout txtUsuario = findViewById(R.id.txt_nombre);
                TextInputLayout txtEmail = findViewById(R.id.txt_email);
                user.setCorreo(txtEmail.getEditText().getText().toString());
                user.setNombres(txtUsuario.getEditText().getText().toString());
                if (user.getCorreo() != null && !user.getCorreo().isEmpty() &&
                        user.getNombres() != null && !user.getNombres().isEmpty()) {
                    //crearUsuarioenDB(user);
                    Intent pantallaPrincipal = new Intent(getApplicationContext(), MenuAppRBas.class);
                    startActivity(pantallaPrincipal);
                } else {
                    new MaterialAlertDialogBuilder(getApplicationContext())
                            .setTitle("Mensaje")
                            .setMessage("Por favor registre su nombre y un correo valido")
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
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
