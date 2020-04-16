package com.fcp.reportebasuras.modelo.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by fabian on 4/12/17.
 */

public class Reporte {

    public static final String TABLE_NAME = "mensaje";

    private Long idmensajes;
    private Long idperimetro;
    private int idreceptor;
    private String tipomensaje; //P Propio | A Ajeno | G Global | L Global Propio
    private String mensaje;
    private int idautor;
    private String autor; //Que contancto envia o Recibe el mensaje | se define el TIPO con el tipo mensaje
    private List<Object> adjuntos;
    private Double latitud;
    private Double longitd;

    //VTR-L29C605B166


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Object> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<Object> adjuntos) {
        this.adjuntos = adjuntos;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitd() {
        return longitd;
    }

    public void setLongitd(Double longitd) {
        this.longitd = longitd;
    }


    public static String getSQL(){
        return "CREATE TABLE " + TABLE_NAME + " "+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " mensaje TEXT NOT NULL, " +
                " autor TEXT, " +
                " tipomensaje TEXT, "+
                " idautor INTEGER, " +
                " idreceptor INTEGER, " +
                " latitud REAL, " +
                " longitd REAL);";
    }

    public String getTipomensaje() {
        return tipomensaje;
    }

    public void setTipomensaje(String tipomensaje) {
        this.tipomensaje = tipomensaje;
    }

    public Long getIdmensajes() {
        return idmensajes;
    }

    public void setIdmensajes(Long idmensajes) {
        this.idmensajes = idmensajes;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public Long getIdperimetro() {
        return idperimetro;
    }

    public void setIdperimetro(Long idperimetro) {
        this.idperimetro = idperimetro;
    }

    public int getIdreceptor() {
        return idreceptor;
    }

    public void setIdreceptor(int idreceptor) {
        this.idreceptor = idreceptor;
    }
}
