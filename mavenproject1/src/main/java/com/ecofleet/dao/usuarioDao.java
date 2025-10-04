package com.ecofleet.dao;

import com.ecofleet.config.conexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioDao {
    
    public void insertar(int id ,String nombre, String email, String telefono) {
        String sql = "INSERT INTO usuarios (id, nombre, email, telefono) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexionDB.getConnection(); 
                PreparedStatement stm = conn.prepareStatement(sql)) {
            
            stm.setInt(1, id);
            stm.setString(2, nombre);
            stm.setString(3, email);
            stm.setString(4, telefono);
            
            int filas = stm.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ usuarios insertado correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar: " + e.getMessage());
        }

    }
    
    public void listar (){
        
        String sql = "SELECT  id ,nombre, email, telefono FROM usuarios";

        try (Connection conn = conexionDB.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                System.out.println("Nombre: " + nombre + " | Email: " + email + " | Teléfono: " + telefono);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar: " + e.getMessage());
        }
    }
    
    
    public void actualizar(int id, String nombre, String email, String telefono) {
        String sql = "UPDATE usuarios SET nombre=?, email=?, telefono=? WHERE id=?";

    try (Connection conn = conexionDB.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nombre);
        stmt.setString(2, email);
        stmt.setString(3, telefono);
        stmt.setInt(4, id);

        int filas = stmt.executeUpdate();
        if (filas > 0) {
            System.out.println("✅ usuarios actualizado correctamente.");
        } else {
            System.out.println("⚠️ No se encontró usuarios con id " + id);
        }
    } catch (SQLException e) {
        System.out.println("❌ Error al actualizar: " + e.getMessage());
    }
}
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        
        try (Connection conn = conexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            
            if (filas > 0) {
                System.out.println("✅ Usuario eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró usuario con id " + id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar: " + e.getMessage());
        }
    }
    
}