/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecofleet.modelo;

/**
 *
 * @author supersayagym
 */
public class auto implements vehiculo {
    private int id; // Columna 'id'
    private String marca; // Columna 'marca'
    private String modelo; // Columna 'modelo'
    private String placa; // Columna 'placa'
    private boolean disponible; // Columna 'disponible
    private int velocidadActual = 0;
    private double nivelCombustible = 50.0;
    private final double CostoPorKm = 0.15;

    public auto(int id, String marca, String modelo, String placa, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.disponible = disponible;
    }

    public auto() {
    }

    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    
    @Override
    public String getTipo() {
        return "auto";
    }
    
    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public String getPlaca() {
        return placa; // El auto tiene placa
    }

    @Override
    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public void acelerar(int kmh) {
    this.velocidadActual += kmh;
    this.nivelCombustible -= (kmh * 0.05);
    
    System.out.println("El auto aceleró a: " + this.velocidadActual + " km/h");
    System.out.println("Combustible restante: " + String.format("%.2f", this.nivelCombustible) + " L");
}

    @Override
    public void frenar() {
    // Frenar completamente, pero podrías añadir lógica de freno progresivo si quisieras
    this.velocidadActual = 0; 
    System.out.println("El auto se ha detenido.");
}
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }    
}
