package com.ecofleet.dao;

import com.ecofleet.modelo.vehiculo;
import com.ecofleet.modelo.auto;
import com.ecofleet.modelo.bicicleta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author supersayagym
 */
public class VehiculoDaoImpl implements VehiculoDAO {
    
    // Suponemos una utilidad para obtener la conexión
    private Connection getConnection() throws SQLException {
        // Lógica de conexión real a la BD (Ejemplo simplificado)
        // return DriverManager.getConnection(DB_URL, USER, PASS);
        return null; // Reemplazar con tu lógica
    }
    
    // --- Método Auxiliar de Mapeo ---
    private vehiculo mapResultSetToVehicle(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String tipo = rs.getString("tipo");
        String marca = rs.getString("marca");
        String modelo = rs.getString("modelo");
        String placa = rs.getString("placa"); 
        boolean disponible = rs.getBoolean("disponible");
        
        // Mapeo Polimórfico: Decide qué clase instanciar
        if ("AUTO".equalsIgnoreCase(tipo)) {
            return new auto(id, marca, modelo, placa, disponible);
        } else if ("BICICLETA".equalsIgnoreCase(tipo)) {
            return new bicicleta(id, marca, modelo, disponible);
        }
        return null; // Tipo de vehículo desconocido
    }

    // --- Implementación de getById (Ya usa PreparedStatement) ---
    @Override
    public vehiculo getById(int id) {
        String sql = "SELECT id, tipo, marca, modelo, placa, disponible FROM vehiculos WHERE id = ?";
        vehiculo v = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usamos el método auxiliar de mapeo
                v = mapResultSetToVehicle(rs); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    // --- Implementación de getAll (CORREGIDA con PreparedStatement) ---
    @Override
    public List<vehiculo> getAll() {
        List<vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT id, tipo, marca, modelo, placa, disponible FROM vehiculos";

        try (Connection conn = getConnection();
             // ¡Ahora se usa PreparedStatement! Aunque no tenga parámetros.
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) { 
            
            while (rs.next()) {
                vehiculo v = mapResultSetToVehicle(rs);
                if (v != null) {
                    vehiculos.add(v);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los vehículos: " + e.getMessage());
        }
        return vehiculos;
    }

    // --- Implementación de save (Ya usa PreparedStatement) ---
    @Override
    public void save(vehiculo v) {
        String sql = "INSERT INTO vehiculos (tipo, marca, modelo, placa, disponible) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, v.getTipo());
            stmt.setString(2, v.getMarca());
            stmt.setString(3, v.getModelo());
            stmt.setString(4, v.getPlaca()); 
            stmt.setBoolean(5, v.isDisponible());

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- Implementación de update (CORREGIDA para usar v.getId()) ---
    @Override
    public void update(vehiculo v) {
        // NOTA: ASUMIMOS QUE LA INTERFAZ 'VEHICULO' TIENE AHORA 'getId()'
        String sql = "UPDATE vehiculos SET tipo = ?, marca = ?, modelo = ?, placa = ?, disponible = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, v.getTipo());
            stmt.setString(2, v.getMarca());
            stmt.setString(3, v.getModelo());
            stmt.setString(4, v.getPlaca()); 
            stmt.setBoolean(5, v.isDisponible());
            
            // ¡Uso correcto de getId() polimórfico!
            stmt.setInt(6, v.getId()); 
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar el vehículo con ID " + v.getId() + ": " + e.getMessage());
        }
    }

    // --- Implementación de delete (Ya usa PreparedStatement) ---
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM vehiculos WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar el vehículo con ID " + id + ": " + e.getMessage());
        }
    }
}