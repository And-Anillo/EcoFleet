/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecofleet.modelo;

/**
 *
 * @author supersayagym
 */
public interface vehiculo {
    
    public String getTipo();
    public void acelerar(int kmh);
    public void frenar();
    public double calcularCostoUso(double kmRecorridos);
    
    
}
