/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.model;

/**
 *
 * @author josepabloramirez
 */
public class Farmaco {

    private Integer id;

    private String nombreComercial;

    private String nombreClinico;

    private String compuestoClinico;

    private String ubicacion;

    private String codigoProveedor;

    public Farmaco() {

    }

    public Farmaco(Integer id, String nombreComercial, String nombreClinico, String compuestoClinico, String ubicacion, String codigoProveedor) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.nombreClinico = nombreClinico;
        this.compuestoClinico = compuestoClinico;
        this.ubicacion = ubicacion;
        this.codigoProveedor = codigoProveedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreClinico() {
        return nombreClinico;
    }

    public void setNombreClinico(String nombreClinico) {
        this.nombreClinico = nombreClinico;
    }

    public String getCompuestoClinico() {
        return compuestoClinico;
    }

    public void setCompuestoClinico(String compuestoClinico) {
        this.compuestoClinico = compuestoClinico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

}
