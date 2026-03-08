package com.cajero.clases;

import java.util.Scanner;

public class Transaccion {

    private int id;
    private String tipo;
    private double monto;
    private String fecha;
    private Cuenta cuenta;
    private Usuario usuario;

    public Transaccion(int id, String tipo, double monto, String fecha, Cuenta cuenta) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.cuenta = cuenta;
        this.usuario = usuario;
    }

    public void registrarTransacción(){
        int usuarioid = usuario.getId();
        System.out.println("La Transación ha sido registrada para: " + usuarioid);
    }
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor a $0.");
            return false;
        }
        if (monto <= cuenta.getSaldo()) {
            double saldoActualizado = cuenta.getSaldo() - monto;
            cuenta.setSaldo(saldoActualizado);
            System.out.println("Retiro de $" + monto + " exitoso. Saldo restante: $" + saldoActualizado);
            return true;
        } else {
            System.out.println("Fondos insuficientes. Saldo disponible: $" + cuenta.getSaldo());
            return false;
        }
    }

    public boolean consignar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a consignar debe ser mayor a $0.");
            return false;
        }
        double saldoActualizado = cuenta.getSaldo() + monto;
        cuenta.setSaldo(saldoActualizado);
        System.out.println("Consignación de $" + monto + " exitosa. Nuevo saldo: $" + saldoActualizado);
        return true;
    }
}
