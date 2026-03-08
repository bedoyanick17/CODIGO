package storeapp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
    Scanner sc = new Scanner(System.in);

    private int id;
    private String nombre;
    private double precio;
    private  int cantidad;
    private boolean estado;
    private String categoria;

    private List<Product> products = new ArrayList<>();

    public Product(Scanner sc, int id, String nombre, double precio, int cantidad, boolean estado, String categoria) {
        this.sc = sc;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.estado = estado;
        this.categoria = categoria;
    }

    public Product() {
    }

    //getters y setters


    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Product createProduct(Product product){

    }
}
