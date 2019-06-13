/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

public class Hidrante implements Serializable {
    
    private Integer numero_hidrante;
    private Double latitud;
    private Double longitud;
    private String calle;
    private String caudal_esperado;
    private Integer tamanio_salidas;
    private Boolean buen_estado;
    
    public Hidrante() {
    }

    public Hidrante(Integer numero_hidrante, Double latitud, Double longitud, String calle, String caudal_esperado, Integer tamanio_salidas, Boolean buen_estado) {
        this.numero_hidrante = numero_hidrante;
        this.latitud = latitud;
        this.longitud = longitud;
        this.calle = calle;
        this.caudal_esperado = caudal_esperado;
        this.tamanio_salidas = tamanio_salidas;
        this.buen_estado = buen_estado;
    }

    public Integer getNumero_hidrante() {
        return numero_hidrante;
    }

    public void setNumero_hidrante(Integer numero_hidrante) {
        this.numero_hidrante = numero_hidrante;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCaudal_esperado() {
        return caudal_esperado;
    }

    public void setCaudal_esperado(String caudal_esperado) {
        this.caudal_esperado = caudal_esperado;
    }

    public Integer getTamanio_salidas() {
        return tamanio_salidas;
    }

    public void setTamanio_salidas(Integer tamanio_salidas) {
        this.tamanio_salidas = tamanio_salidas;
    }

    public Boolean getBuen_estado() {
        return buen_estado;
    }

    public void setBuen_estado(Boolean buen_estado) {
        this.buen_estado = buen_estado;
    }

}