package com.mycompany.addt4ef1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adria
 */
public class JugadorDao {
    
    private Connection connection;
    
    public JugadorDao(Connection connection) {
        this.connection = connection;
    }
    
    public void add(Jugador jugador) {
        String sql = "INSERT INTO jugador (nombre, posicion, herido, entrenador_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jugador.getNombre());
            statement.setString(2, jugador.getPosicion());
            statement.setBoolean(3, jugador.getHerido());
            statement.setInt(4, jugador.getEntrenadorId());
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    }
    
    public void deleteJugador(int id) {
        String sql = "DELETE FROM jugador WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
    
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    }
    
    public void modifyLesion(int id) {
        String sql = "UPDATE jugador SET herido = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, true);          
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    }
    
    public ArrayList<Jugador> findAll() {
        String sql = "SELECT * FROM jugador ORDER BY id";
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String posicion = resultSet.getString("posicion");
                Boolean herido = resultSet.getBoolean("herido");
                int entrenadorID = resultSet.getInt("entrenador_id");
                Jugador jugador = new Jugador(nombre, posicion, herido, entrenadorID);
                jugador.setId(resultSet.getInt("id"));
                jugadores.add(jugador);
            }
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }

        return jugadores;
    }
    
    public ArrayList<Jugador> findJugadoresdeEntrenadores(int id) {
        String sql = "SELECT * FROM jugador WHERE entrenador_id = ?";
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id); // asignamos el parámetro id
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String posicion = resultSet.getString("posicion");
                Boolean herido = resultSet.getBoolean("herido");
                int entrenadorID = resultSet.getInt("entrenador_id");

                Jugador jugador = new Jugador(nombre, posicion, herido, entrenadorID);
                jugador.setId(resultSet.getInt("id"));
                jugadores.add(jugador);
            }
        } catch (SQLException sqle) {
            System.out.println("No se ha podido conectar con el servidor de base de datos. Comprueba que los datos son correctos y que el servidor se ha iniciado");
            sqle.printStackTrace();
        }
    return jugadores;
    
    }
}
