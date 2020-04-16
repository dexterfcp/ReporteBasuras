package com.fcp.reportebasuras.modelo.vo;

/**
 * Created by fabian on 2/01/18.
 */

public class Usuario {

    public static final String TABLE_NAME = "usuario";

    private int idfuncionario = 0;
    private String nombres = "";
    private String apellidos= "";
    private String correo= "";
    private String celular= "";
    private String tiposangre= "";


    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTiposangre() {
        return tiposangre;
    }

    public void setTiposangre(String tiposangre) {
        this.tiposangre = tiposangre;
    }

    public static String getSQL(){
        return "CREATE TABLE " + TABLE_NAME + " "+
                "(id INTEGER PRIMARY KEY, " +
                " nombre TEXT NOT NULL, " +
                " apellido TEXT NOT NULL, " +
                " correo TEXT, " +
                " celular TEXT NOT NULL, " +
                " tipoSangre TEXT);";
    }
}
