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
    private int velocidadActual = 0;
    private double nivelCombustible = 50.0;
    private final double CostoPorKm = 0.15;

    @Override
    public String getTipo() {
        return "auto";
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

    @Override
    public double calcularCostoUso(double kmRecorridos) {
    double costoTotal = kmRecorridos * CostoPorKm;
    System.out.println("Costo total de uso para " + kmRecorridos + " km: $" + String.format("%.2f", costoTotal));
    return costoTotal;
}
    
}
