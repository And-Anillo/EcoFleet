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
    private int id;
    private String marca;
    private String modelo;
    private boolean disponible;
    private int velocidadActual = 0;


    public bicicleta(int id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public bicicleta() {
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

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String getTipo() {
        return "bicicleta";
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
        // Una bicicleta no tiene placa. Retorna null para la BD.
        return null;
    }

    @Override
    public boolean isDisponible() {
        return disponible;
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

    
    
}
