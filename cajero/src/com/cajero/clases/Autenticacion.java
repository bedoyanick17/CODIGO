package com.cajero.clases;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Autenticacion {
    private int intentos;
    private boolean bloqueado;
    private LocalDateTime tiempoBloqueo;


    public Autenticacion(){
        this.intentos = 0;
        this.bloqueado = false;
        this.tiempoBloqueo = null;
    }

    public void resetIntentos(){
        intentos = 0;
    }

    public void bloquearCuenta(){
        bloqueado = true;
        tiempoBloqueo = LocalDateTime.now();
        System.out.println("La cuenta ha sido bloqueada por exceso de intentos. Intente nuevamente en 24 Horas.");
    }

    public boolean statusBloqueo() {
        if (bloqueado && tiempoBloqueo != null) {
            LocalDateTime hora = LocalDateTime.now();
            if (hora.isAfter(tiempoBloqueo.plusHours(24))) {
                bloqueado = false;
                intentos = 0;
                tiempoBloqueo = null;
                System.out.println("El bloqueo ha expirado. Ya puede iniciar sesión.");
                return false;
            }
            return true;
        }
        return false;
    }

    public void registrarintentos(){
        intentos++;
        if (intentos >= 3){
        bloquearCuenta();
        }
    }

    public boolean login(Usuario Usuario, String contrasena) {
        if (statusBloqueo()) {
            System.out.println("cuenta bloqueada. Intente despues de 24 Horas");
            return false;
        }
        if (Usuario.getContrasena().equals(contrasena)) {
            resetIntentos();
            System.out.println("Login Exitoso");
            return true;
        }else {
            registrarintentos();
            int intentosRestantes = 3 - intentos;
            System.out.println("Contraseña Incorrecta. Intentos restantes. " + intentosRestantes);
            return false;
        }
    }
}

