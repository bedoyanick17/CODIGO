package com.cajero.clases;

public class Usuario {

    private int id;
    private String nombre;
    private String contrasena;
    private int IntentosLogin;
    private boolean estado;
    private int numeroCuenta;

    // constructor

    public Usuario(int id, String nombre, String contrasena, int intentosLogin, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        IntentosLogin = intentosLogin;
        this.estado = estado;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIntentosLogin() {
        return IntentosLogin;
    }

    public void setIntentosLogin(int intentosLogin) {
        IntentosLogin = intentosLogin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
