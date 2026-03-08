package main;

import com.cajero.clases.*;

import java.util.Scanner;

public class Main {

  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      Banco banco = new Banco();
      Autenticacion autenticacion = new Autenticacion();
      boolean sesionActiva = false;
      Usuario usuarioActual = null;

      boolean ejecutando = true;

      while (ejecutando){
          System.out.println("MI PLATA \n" +
                  "1. Iniciar sesión\n" +
                  "2. Registrarse.\n");
          int opt = sc.nextInt();
          sc.nextLine();

          if (opt == 2){
              System.out.println("Ingrese su ID:");
              int id = sc.nextInt();
              sc.nextLine();

              System.out.println("Ingrese su nombre: ");
              String nombre = sc.nextLine();

              System.out.println("Ingrese su contraseña: ");
              String contrasena = sc.nextLine();

              //crea usuario con los datos
              Usuario nuevoUsuario = new Usuario(id, nombre, contrasena, 0, true);

              //inicializa la cuenta con saldo=0 y numero cuenta = numero aleatorio
              Cuenta nuevaCuenta = new Cuenta();
              nuevaCuenta.inicializarCuenta();


              //ESTA PARTE NO SE COMO PERO FUNCIONA. MEJOR NO LO TOQUEMOS
              int numero = nuevaCuenta.getNumeroCuenta();
              nuevoUsuario.setNumeroCuenta(numero);

            banco.registrarCuenta(nuevaCuenta);
            banco.registrarUsuario(nuevoUsuario);

              System.out.println("Registro Exitoso");

          }
          //LOGIN
          else if(opt ==1){

              while (!sesionActiva) {
                  System.out.print("Nombre de usuario: ");
                  String nombreLogin = sc.nextLine();

                  Usuario encontrado = banco.buscarUsuario(nombreLogin);

                  if (encontrado == null) {
                      System.out.println("Usuario no encontrado.");
                      break;
                  }

                  System.out.print("Contraseña: ");
                  String contrasenaLogin = sc.nextLine();

                  boolean loginExitoso = autenticacion.login(encontrado, contrasenaLogin);

                  if (loginExitoso) {
                      sesionActiva = true;
                      usuarioActual = encontrado;
                  } else if (autenticacion.statusBloqueo()) {
                      break;
                  }
              }
          }

          //MENU DESPUES DE HABER HECHO EL LOGIN

          if (sesionActiva && usuarioActual != null) {

              Cuenta cuentaActual = banco.buscarCuenta(usuarioActual.getNumeroCuenta()); 

              boolean enSesion = true;
              while (enSesion) {
                  System.out.println("Saldo actual: $" + cuentaActual.getSaldo());
                  System.out.println("1. Consignar dinero");
                  System.out.println("2. Retirar dinero");
                  System.out.println("3. Cerrar sesión");
                  System.out.print("Seleccione: ");
                  int opMenu = sc.nextInt();
                  sc.nextLine();

                  Transaccion transaccion = new Transaccion(1, "", 0, "", cuentaActual);

                  if (opMenu == 1) {
                      System.out.print("Monto a consignar: $");
                      double monto = sc.nextDouble();
                      sc.nextLine();
                      transaccion.consignar(monto);

                  } else if (opMenu == 2) {
                      System.out.print("Monto a retirar: $");
                      double monto = sc.nextDouble();
                      sc.nextLine();
                      transaccion.retirar(monto);

                  } else if (opMenu == 3) {
                      System.out.println("Sesión cerrada. Hasta luego, " + usuarioActual.getNombre() + ".");
                      enSesion = false;
                  } else {
                      System.out.println("Opción no válida.");
                  }
              }
          }else {
              System.out.println("Opción no válida.");

      }
      }
  }

      }

