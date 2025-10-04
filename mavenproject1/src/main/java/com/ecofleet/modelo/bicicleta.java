/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecofleet.modelo;

/**
 *
 * @author supersayagym
 */
public class bicicleta implements vehiculo {
    private int velocidadActual = 0;
    private final double CostoPorHora = 0.15;

    @Override
    public String getTipo() {
        return "bicicleta";
    }

    @Override
    public void acelerar(int kmh) {
        this.velocidadActual += kmh;
        System.out.println("Bicicleta acelerada. Nueva velocidad: " + this.velocidadActual + " km/h");
    }

    @Override
    public void frenar() {
        this.velocidadActual = 0;
        System.out.println("Bicicleta detenida.");
    }

    @Override
    public double calcularCostoUso(double kmRecorridos) {
        double CostoTotalR = CostoPorHora * kmRecorridos;// El costo de uso para una bicicleta es típicamente cero (sin combustible)
        System.out.println("costo total por" + kmRecorridos + " km: $ " + String.format("%.2f", CostoTotalR) );
        return CostoTotalR;
    }
    
}
