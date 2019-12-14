/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Servicio;
import com.ulatina.proyecto.service.ControlProcAlmac;
import com.ulatina.proyecto.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kenneth
 */
@ManagedBean(name = "controllerUsuario")
@SessionScoped
public class ControllerUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuario;

    private String usuario;

    private String contrasena;

    private Servicio servicio;

    private String nombre;

    private String direccion;

    private String telefono;

    private String tipoUsuario;

    private List<Usuario> usuarios = new ArrayList<>();

    private Usuario usuarioConect;

    public ControllerUsuario() {
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.usuarios = usu.listarUsuarios();
    }

    public void eliminarUsuario() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.eliminarUsuario(this.idUsuario);
    }

    public void editar_usuario() {
        ControlProcAlmac usu = new ControlProcAlmac();
        System.out.println(this.usuarioConect.getId());
        System.out.println(this.nombre);
        System.out.println(this.direccion);
        System.out.println(this.telefono);
        usu.editarUsuario(this.usuarioConect.getId(), this.nombre, this.direccion, this.telefono);
    }

    public void crear_usuario() {
        ControlProcAlmac usu = new ControlProcAlmac();
        if (this.servicio == null) {
            usu.crearUsuario(this.nombre, this.usuario, this.contrasena, this.direccion, this.telefono, this.tipoUsuario, 0);
        } else {
            usu.crearUsuario(this.nombre, this.usuario, this.contrasena, this.direccion, this.telefono, this.tipoUsuario, this.servicio.getIdServicio());
        }

    }

    public String login() {
        FacesMessage msg = null;
        ControlProcAlmac usu = new ControlProcAlmac();
        this.usuarioConect = usu.login(this.usuario, this.contrasena);
        this.nombre = this.usuarioConect.getNombre();
        this.direccion = this.usuarioConect.getDireccion();
        this.telefono = this.usuarioConect.getTelefono();
        if (this.usuarioConect != null) {
            System.out.println(this.usuarioConect.getId());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuarioConect.getNombre());
            return "userProfile.xhtml?faces-redirect=true";
        } else {
            msg = new FacesMessage("Datos incorrectos,volver a ingresar los datos");
        }
        return null;
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .invalidateSession();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void redirect(String url) {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(
                            request.getContextPath()
                            + "faces/pages/" + url);
        } catch (IOException e) {
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuarioConect() {
        return usuarioConect;
    }

    public void setUsuarioConect(Usuario usuarioConect) {
        this.usuarioConect = usuarioConect;
    }
}