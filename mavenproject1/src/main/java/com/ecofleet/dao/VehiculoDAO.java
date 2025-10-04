/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecofleet.dao;

import com.ecofleet.modelo.vehiculo;
import java.util.List;
/**
 *
 * @author supersayagym
 */
public interface VehiculoDAO {
    /**
     * Busca un vehículo por su ID en la base de datos.
    * @param
    id El ID único del vehículo
    .
     * @return Un objeto  
     
    'vehiculo' (que será un  
     
    'auto' o  
     
    'bicicleta'), o null si no se encuentra

    .
     */
    vehiculo getById(int id);

    List<vehiculo> getAll();

    void save(vehiculo v);

    void update(vehiculo v);

    void delete(int id);
}
