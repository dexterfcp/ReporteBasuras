package com.fcp.reportebasuras.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fcp.reportebasuras.modelo.sqlitevigia.HelperSQLiteVigia;
import com.fcp.reportebasuras.modelo.vo.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabian on 31/01/18.
 */

public class ContactoDAO extends HelperSQLiteVigia{

    public ContactoDAO(Context context) {
        super(context);
    }

    public void insert(Contacto vo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("idFuncionario", vo.getIdfuncionario());
        values.put("nombres" , vo.getNombres());
        values.put("apellidos" , vo.getApellidos());
        values.put("celular" , vo.getCelular());
        values.put("urlImagen" , vo.getUrlImagen());
        db.insert(Contacto.TABLE_NAME, null,values);
        //db.close();
    }

    public void edit(Contacto vo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put("idFuncionario", vo.getIdfuncionario());
        values.put("nombres" , vo.getNombres());
        values.put("apellidos" , vo.getApellidos());
        values.put("celular" , vo.getCelular());
        values.put("urlImagen" , vo.getUrlImagen());
        values.put("enChat", vo.isEnChat()?1:0);
        db.update(Contacto.TABLE_NAME,values, "idFuncionario=?" ,new String[]{String.valueOf(vo.getIdfuncionario())});
        db.close();
    }

    public void editEnChat(Contacto vo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put("idFuncionario", vo.getIdfuncionario());
        values.put("enChat", vo.isEnChat());
        db.update(Contacto.TABLE_NAME,values, "idFuncionario=?" ,new String[]{String.valueOf(vo.getIdfuncionario())});
        db.close();
    }

    public List<Contacto> consultar(){
        String[] projection = {"idFuncionario",
                "nombres",
                "apellidos",
                "celular",
                "urlImagen",
                "enChat"};
        Cursor cursor =
                db.query(Contacto.TABLE_NAME,
                        projection,
                        "",
                        null,
                        null,
                        null,
                        "idFuncionario",
                        null);
        List<Contacto> listaContactos = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()){
                Contacto contacto = new Contacto();
                contacto.setIdfuncionario(cursor.getInt(cursor.getColumnIndex("idfuncionario")));
                contacto.setNombres(cursor.getString(cursor.getColumnIndex("nombres")));
                contacto.setApellidos(cursor.getString(cursor.getColumnIndex("apellidos")));
                contacto.setCelular(cursor.getString(cursor.getColumnIndex("celular")));
                contacto.setEnChat(cursor.getInt(cursor.getColumnIndex("enChat"))==1?true:false);
                listaContactos.add(contacto);
            }
        }else{
            return null;
        }
        return listaContactos;
    }
}