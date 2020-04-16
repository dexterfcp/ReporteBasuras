package com.fcp.reportebasuras.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.fcp.reportebasuras.modelo.sqlitevigia.HelperSQLiteVigia;
import com.fcp.reportebasuras.modelo.vo.Usuario;

/**
 * Created by fabian on 2/01/18.
 */

public class UsuarioDAO extends HelperSQLiteVigia {

    public UsuarioDAO(Context context) {
        super(context);
    }

    public void insert(Usuario vo){
        ContentValues values = new ContentValues();
        values.put("id" , vo.getIdfuncionario());
        values.put("nombre" , vo.getNombres());
        values.put("apellido" , vo.getApellidos());
        values.put("correo" , vo.getCorreo());
        values.put("celular" , vo.getCelular());
        values.put("tipoSangre" , vo.getTiposangre());

        db.insert(Usuario.TABLE_NAME, null,values);
    }

    public Usuario consultarUsuarioUnico(){
        String[] projection = {"id",
                "nombre",
                "apellido",
                "correo",
                "celular",
                "tipoSangre"};

        Cursor cursor =
                db.query(Usuario.TABLE_NAME,
                        projection,
                        "",
                        null,
                        null,
                        null,
                        null,
                        null);
        Usuario vo = null;

        if (cursor != null) {
            if(cursor.moveToFirst()) {
                vo = new Usuario();
                vo.setIdfuncionario(cursor.getInt(cursor.getColumnIndex(projection[0])));
                vo.setNombres(cursor.getString(cursor.getColumnIndex(projection[1])));
                vo.setApellidos(cursor.getString(cursor.getColumnIndex(projection[2])));
                vo.setCorreo(cursor.getString(cursor.getColumnIndex(projection[3])));
                vo.setCelular(cursor.getString(cursor.getColumnIndex(projection[4])));
                vo.setTiposangre(cursor.getString(cursor.getColumnIndex(projection[5])));
            }
        }

        return vo;
    }

}
