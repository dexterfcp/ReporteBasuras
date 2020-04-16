package com.fcp.reportebasuras.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.fcp.reportebasuras.modelo.sqlitevigia.HelperSQLiteVigia;
import com.fcp.reportebasuras.modelo.vo.Reporte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabian on 3/01/18.
 */

public class ReporteDAO extends HelperSQLiteVigia {
    public ReporteDAO(Context context) {
        super(context);
    }

    public void insert(Reporte vo){
        Log.e("Insert : ", "Reporte");
        ContentValues values = new ContentValues();
        values.put("mensaje" , vo.getMensaje());
        values.put("autor" , vo.getAutor());
        values.put("idautor" , vo.getIdautor());
        values.put("idreceptor" , vo.getIdreceptor());
        values.put("latitud" , vo.getLatitud());
        values.put("tipomensaje" , vo.getTipomensaje());
        values.put("longitd" , vo.getLongitd());

        long id = db.insert(Reporte.TABLE_NAME, null,values);
        Log.e("Insert : ", "Id Reporte " + id + "  --< " + vo.getIdreceptor()  + " --< " + vo.getIdautor());
        Log.e("Insert : ", "SQLMensaje " + id + "  --< " + values.get("idreceptor")  + " --< " + values.get("idautor"));
        vo.setIdmensajes(id);
    }


    public List<Reporte> consultarGlobal() {
        Log.e("consultarGlobal : ", "Global");
        String[] projection = {"id",
                "mensaje",
                "autor",
                "idautor",
                "idreceptor",
                "tipomensaje",
                "latitud",
                "longitd"};
        Cursor cursor =
                db.query(Reporte.TABLE_NAME,
                        projection,
                        "",
                        new String[]{},
                        null,
                        null,
                        "id",
                        null);
        List<Reporte> listaReportes = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()){
                Log.e("Cursor ADD : ", "Hay dato Global");
                Reporte reporte = new Reporte();
                reporte.setIdmensajes(cursor.getLong(cursor.getColumnIndex("id")));
                reporte.setIdautor(cursor.getInt(cursor.getColumnIndex("idautor")));
                reporte.setIdreceptor(cursor.getInt(cursor.getColumnIndex("idreceptor")));
                reporte.setAutor(cursor.getString(cursor.getColumnIndex("autor")));
                reporte.setMensaje(cursor.getString(cursor.getColumnIndex("mensaje")));
                reporte.setTipomensaje(cursor.getString(cursor.getColumnIndex("tipomensaje")));
                //reporte.setIdperimetro(cursor.getLong(cursor.getColumnIndex("idfuncionario")));
                reporte.setLatitud(cursor.getDouble(cursor.getColumnIndex("latitud")));
                reporte.setLongitd(cursor.getDouble(cursor.getColumnIndex("longitd")));
                listaReportes.add(reporte);
            }
        }else{
            return null;
        }
        return listaReportes;
    }

    public List<Reporte> consultarExterno(int idFuncionarioExterno) {
        Log.e("ConsultarExterno : ", "Datos para : " + idFuncionarioExterno);
        String[] projection = {"id",
                "mensaje",
                "autor",
                "idautor",
                "idreceptor",
                "tipomensaje",
                "latitud",
                "longitd"};
        Cursor cursor =
                db.query(Reporte.TABLE_NAME,
                        projection,
                        "",
                        new String[]{},
                        null,
                        null,
                        "id",
                        null);

        List<Reporte> listaReportes = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()){
                Reporte reporte = new Reporte();
                reporte.setIdmensajes(cursor.getLong(cursor.getColumnIndex("id")));
                reporte.setIdautor(cursor.getInt(cursor.getColumnIndex("idautor")));
                reporte.setIdreceptor(cursor.getInt(cursor.getColumnIndex("idreceptor")));
                reporte.setAutor(cursor.getString(cursor.getColumnIndex("autor")));
                reporte.setMensaje(cursor.getString(cursor.getColumnIndex("reporte")));
                reporte.setTipomensaje(cursor.getString(cursor.getColumnIndex("tipomensaje")));
                //reporte.setIdperimetro(cursor.getLong(cursor.getColumnIndex("idfuncionario")));
                reporte.setLatitud(cursor.getDouble(cursor.getColumnIndex("latitud")));
                reporte.setLongitd(cursor.getDouble(cursor.getColumnIndex("longitd")));
                listaReportes.add(reporte);
            }
        }else{
            return null;
        }
        return listaReportes;
    }
}
