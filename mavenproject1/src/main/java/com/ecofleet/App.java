package com.ecofleet;
import com.ecofleet.config.conexionDB;
import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        try (Connection conn = conexionDB.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexión exitosa a la base de datos.");
            } else {
                System.out.println("❌ No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
    }
}
