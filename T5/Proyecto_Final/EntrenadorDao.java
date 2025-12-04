/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.addt4ef1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class EntrenadorDao {
 
    private Connection connection;
    
    public EntrenadorDao(Connection connection) {
        this.connection = connection;
    }
    
    public void add(Entrenador entrenador) {
        String sql = "INSERT INTO entrenador (nombre, raza, n_partidos) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entrenador.getNombre());
            statement.setString(2, entrenador.getRaza());
            statement.setInt(3, entrenador.getPartidos());           
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    }
    
    public void deleteEntrenador(int id) {
        String sql = "DELETE FROM entrenador WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt
        (1, id);
            statement.executeUpdate();
    
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    }
    
    public void modifyNPartidos(int id, Entrenador entrenador) {
        String sql = "UPDATE entrenador SET n_partidos = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, entrenador.getPartidos());          
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    }
    
    public ArrayList<Entrenador> findAll() {
        String sql = "SELECT * FROM entrenador ORDER BY id";
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String raza = resultSet.getString("raza");
                int nPartidos = resultSet.getInt("n_partidos");
                Entrenador entrenador = new Entrenador(nombre, raza, nPartidos);
                entrenador.setId(resultSet.getInt("id"));
                entrenadores.add(entrenador);
            }
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }

        return entrenadores;
    }    
    
}
