package com.cajero.clases;

import java.util.SortedMap;

public class Cuenta{

    private int numeroCuenta;
    private double saldo;

    public Cuenta(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public Cuenta() {
    }

    //getters y setters


    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void inicializarCuenta(){
        numeroCuenta = (int) (Math.random() * 900000) + 100000 ;
        saldo = 0;
        System.out.println("Usuario y cuenta registrados con éxito");
    }
}
