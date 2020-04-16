package com.fcp.reportebasuras.modelo.vo;

/**
 * Created by fabian on 29/01/18.
 */

public class Contacto {

    public static final String TABLE_NAME = "contacto";


    private int idfuncionario;
    private String nombres;
    private String apellidos;
    private String celular;
    private String urlImagen;
    private boolean enChat;
    private int numNuevoMensaje;


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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public boolean isEnChat() {
        return enChat;
    }

    public void setEnChat(boolean enChat) {
        this.enChat = enChat;
    }


    public static String getSQL(){
        return "CREATE TABLE " + TABLE_NAME + " "+
                "(idfuncionario INTEGER PRIMARY KEY , " +
                " nombres TEXT NOT NULL, " +
                " apellidos TEXT NOT NULL, " +
                " celular TEXT NOT NULL, " +
                " urlImagen TEXT, " +
                " enChat INTEGER," +
                " numNuevoMensaje INTEGER);";
    }


}
