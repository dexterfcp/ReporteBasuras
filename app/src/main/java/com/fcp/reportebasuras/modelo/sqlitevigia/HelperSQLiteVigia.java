package com.fcp.reportebasuras.modelo.sqlitevigia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fcp.reportebasuras.modelo.vo.Contacto;
import com.fcp.reportebasuras.modelo.vo.Reporte;
import com.fcp.reportebasuras.modelo.vo.Usuario;

/**
 * Created by fabian on 2/01/18.
 */



public class HelperSQLiteVigia extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "limpiacol.db";
    protected SQLiteDatabase db;


    public HelperSQLiteVigia(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    public void closeDB(){
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("SQLITE FCP  ", "Creando DATABASE");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Usuario.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Reporte.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contacto.TABLE_NAME);
        sqLiteDatabase.execSQL(Usuario.getSQL());
        sqLiteDatabase.execSQL(Reporte.getSQL());
        sqLiteDatabase.execSQL(Contacto.getSQL());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        Log.i("SQLITE FCP  ", "UPDATE DATABASE "+oldversion +" - " + newversion);
        onCreate(sqLiteDatabase);
    }
}
