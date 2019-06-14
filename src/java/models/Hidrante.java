/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

public class Hidrante implements Serializable {
    
    //private Integer numero_hidrante;
    //private Point2D.Double ubicacion;
//    private String calle;
//    private String caudal_esperado;
//    private Integer tamanio_salidas;
//    private Boolean buen_estado;
    
    String latitud;
    String longitud;
    String caudal_esperado;
    String tamanio_salidas;
    Boolean estado;
    
    public Hidrante() {
    }
    
    

//    public Hidrante(Integer numero_hidrante, Point2D.Double ubicacion, String calle, String caudal_esperado, Integer tamanio_salidas, Boolean buen_estado) {
//        this.numero_hidrante = numero_hidrante;
//        this.ubicacion = ubicacion;
//        this.calle = calle;
//        this.caudal_esperado = caudal_esperado;
//        this.tamanio_salidas = tamanio_salidas;
//        this.buen_estado = buen_estado;
//    }
//
//    public Integer getNumero_hidrante() {
//        return numero_hidrante;
//    }
//
//    public void setNumero_hidrante(Integer numero_hidrante) {
//        this.numero_hidrante = numero_hidrante;
//    }
//
//    public Point2D.Double getUbicacion() {
//        return ubicacion;
//    }
//
//    public void setUbicacion(Point2D.Double ubicacion) {
//        this.ubicacion = ubicacion;
//    }
//
//    public String getCalle() {
//        return calle;
//    }
//
//    public void setCalle(String calle) {
//        this.calle = calle;
//    }
//
//    public String getCaudal_esperado() {
//        return caudal_esperado;
//    }
//
//    public void setCaudal_esperado(String caudal_esperado) {
//        this.caudal_esperado = caudal_esperado;
//    }
//
//    public Integer getTamanio_salidas() {
//        return tamanio_salidas;
//    }
//
//    public void setTamanio_salidas(Integer tamanio_salidas) {
//        this.tamanio_salidas = tamanio_salidas;
//    }
//
//    public Boolean getBuen_estado() {
//        return buen_estado;
//    }
//
//    public void setBuen_estado(Boolean buen_estado) {
//        this.buen_estado = buen_estado;
//    }

    public Hidrante(String latitud, String longitud, String caudal_esperado, String tamanio_salidas, Boolean estado) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.caudal_esperado = caudal_esperado;
        this.tamanio_salidas = tamanio_salidas;
        this.estado = estado;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getCaudal_esperado() {
        return caudal_esperado;
    }

    public void setCaudal_esperado(String caudal_esperado) {
        this.caudal_esperado = caudal_esperado;
    }

    public String getTamanio_salidas() {
        return tamanio_salidas;
    }

    public void setTamanio_salidas(String tamanio_salidas) {
        this.tamanio_salidas = tamanio_salidas;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}

//INSERT INTO app(p_id, the_geom)
//VALUES(2, ST_GeomFromText('POINT(-71.060316 48.432044)', 4326));