package com.cajero.clases;

import java.util.HashMap;

public class Banco{

    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private HashMap<Integer, Cuenta> cuentas = new HashMap<>();

    //constructor
    public Banco(){
        usuarios = new HashMap<>();
        cuentas = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.put(usuario.getNombre(), usuario);
        System.out.println("Usuario registrado de manera exitosa");
    }

    public Usuario buscarUsuario(String nombre){
        return usuarios.get(nombre);
    }

    public void registrarCuenta(Cuenta cuenta){
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
        System.out.println("La cuenta ha sido registrada");

    }

    public Cuenta buscarCuenta(int numeroCuenta){
        return cuentas.get(numeroCuenta);
    }
}
