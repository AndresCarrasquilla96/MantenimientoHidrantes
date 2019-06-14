/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.geom.Point2D;
import java.io.Serializable;

public class Hidrante implements Serializable {
    
    private Integer id_hidrante;
    private Point2D.Double ubicacion;
    String caudal_esperado;
    String tamanio_salidas;
    Boolean buen_estado;
    
    public Hidrante() {
    }

    public Hidrante(Integer id_hidrante, Point2D.Double ubicacion, String caudal_esperado, String tamanio_salidas, Boolean buen_estado) {
        this.id_hidrante = id_hidrante;
        this.ubicacion = ubicacion;
        this.caudal_esperado = caudal_esperado;
        this.tamanio_salidas = tamanio_salidas;
        this.buen_estado = buen_estado;
    }

    public Integer getId_hidrante() {
        return id_hidrante;
    }

    public void setId_hidrante(Integer id_hidrante) {
        this.id_hidrante = id_hidrante;
    }

    public Point2D.Double getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Point2D.Double ubicacion) {
        this.ubicacion = ubicacion;
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

    public Boolean getBuen_estado() {
        return buen_estado;
    }

    public void setBuen_estado(Boolean buen_estado) {
        this.buen_estado = buen_estado;
    }
}