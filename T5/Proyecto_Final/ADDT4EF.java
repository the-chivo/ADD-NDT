/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.addt4ef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumnos
 */
    public class ADDT4EF {

        public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(ConfiguracionXML.getUrl());

        String url = ConfiguracionXML.getUrl();
        String user = ConfiguracionXML.getUsuario();
        String pass = ConfiguracionXML.getPassword();
        
        String createEntrenador = "CREATE TABLE IF NOT EXISTS Entrenador (" +
            "ID SERIAL PRIMARY KEY, " +
            "Nombre VARCHAR(100), " +
            "Raza VARCHAR(50), " +
            "N_Partidos INT" +
            ")";

        String createJugador = "CREATE TABLE IF NOT EXISTS Jugador (" +
            "ID SERIAL PRIMARY KEY, " +
            "Nombre VARCHAR(100), " +
            "Posicion VARCHAR(50), " +
            "Herido BOOLEAN, " +
            "Entrenador_ID INT, " +
            "FOREIGN KEY (Entrenador_ID) REFERENCES Entrenador(ID)" +
            ")";
                         
        Connection conn = null;
        Statement stm = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement();

            // INSERT usa executeUpdate
            //String query1 = "INSERT INTO entrenador(nombre, raza) VALUES ('Juan', 'Humano')";
            //int filasAfectadas = stm.executeUpdate(query1);
            //System.out.println("Filas insertadas: " + filasAfectadas);

            // SELECT usa executeQuery
            stm.executeUpdate(createEntrenador);
            stm.executeUpdate(createJugador);
            
            String query = "SELECT * FROM entrenador";
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("nombre");
                System.out.println(id + " " + nombre);
            }

        } catch (SQLException e) {
            // Aquí manejas la excepción
            e.printStackTrace(); // imprime el error en consola
            System.out.println("Error en la base de datos: " + e.getMessage());     
        }
    }
   
    
}
