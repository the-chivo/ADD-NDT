/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.addt4ef1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adria
 */
public class ADDT4EF1 {
        
    static EntrenadorDao entrenadorDao;
    static JugadorDao jugadorDao;
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String url = ConfiguracionXML.getUrl();
        String user = ConfiguracionXML.getUsuario();
        String pass = ConfiguracionXML.getPassword();
        
        String entrenadorQuery = createEntrenador();
        String jugadorQuery = createJugador();
                                
        Connection conn = null;
        Statement stm = null;

        try {                       
            conn = DriverManager.getConnection(url, user, pass);  //Conexion con la base de datos
            entrenadorDao = new EntrenadorDao(conn);
            jugadorDao = new JugadorDao(conn);
            stm = conn.createStatement();           
            stm.executeUpdate(entrenadorQuery);   //crea las tablas si no existian
            stm.executeUpdate(jugadorQuery);
            
        } catch (SQLException e) {
            // Aquí manejas la excepción
            e.printStackTrace(); // imprime el error en consola
            System.out.println("Error en la base de datos: " + e.getMessage());     
        }        
        
        do{
            System.out.println("1. Añadir entrenador/jugador");
            System.out.println("2. Eliminar entrenador/jugador");
            System.out.println("3. Listar todos los entrenadores/jugadores.");
            System.out.println("4. Listar todos los jugadores asociados a un entrenador.");
            System.out.println("5. Partir pierna a jugador");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            switch(opcion){
                
                case 1:
                    añadirJugadorEntrenador();
                    break;
                case 2:
                    eliminarJugadorEntrenador();
                    break;
                case 3:
                    listarJugadorEntrenador();
                    break;
                case 4:
                    listarJugadoresdeEntrenadores();
                    break;
                case 5:
                    lesionarJugador();
            }
        }while(opcion != 0);
    }
    
    private static String createEntrenador(){
        
        String entrenadorQuery = "CREATE TABLE IF NOT EXISTS Entrenador (" +
            "ID SERIAL PRIMARY KEY, " +
            "Nombre VARCHAR(100), " +
            "Raza VARCHAR(50), " +
            "N_Partidos INT" +
            ")";
        return entrenadorQuery;
    }
    
    private static String createJugador(){
        
        String jugadorQuery = "CREATE TABLE IF NOT EXISTS Jugador (" +
            "ID SERIAL PRIMARY KEY, " +
            "Nombre VARCHAR(100), " +
            "Posicion VARCHAR(50), " +
            "Herido BOOLEAN, " +
            "Entrenador_ID INT, " +
            "FOREIGN KEY (Entrenador_ID) REFERENCES Entrenador(ID) ON DELETE SET NULL\n" +
            ")";
        return jugadorQuery;
    }
    
    private static void añadirJugadorEntrenador(){
        
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Añadir jugador");
            System.out.println("2. Añadir entrenador");
            System.out.println("0. Anterior");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                
                case 1:
                    System.out.println("Introduzca el nombre");
                    String nombreJugador = sc.nextLine();
                    System.out.println("Introduzca la posicion");
                    String posicion = sc.nextLine();
                    System.out.println("Introduzca la id del entrenador del jugador");
                    int idEntrenador = sc.nextInt();
                    Jugador jugador = new Jugador(nombreJugador, posicion, false, idEntrenador);
                    jugadorDao.add(jugador);
                    System.out.println("Has creado un entrenador con nombre: " + nombreJugador + " posicion: " + posicion + " y " + idEntrenador + "como id de entrenador");
                    break;
                case 2:
                    System.out.println("Introduzca el nombre");
                    String nombreEntrenador = sc.nextLine();
                    System.out.println("Introduzca la raza");
                    String razaEntrenador = sc.nextLine();
                    System.out.println("Introduzca el numero de partidos jugados(puede ser 0)");
                    int nPartidos = sc.nextInt();
                    Entrenador entrenador = new Entrenador(nombreEntrenador, razaEntrenador, nPartidos);
                    entrenadorDao.add(entrenador);
                    System.out.println("Has creado un entrenador con nombre: " + nombreEntrenador + " raza: " + razaEntrenador + " y " + nPartidos + " partidos jugados");
            }
        }while(opcion != 0);
        
    }
    
    
    private static void eliminarJugadorEntrenador(){
        
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Eliminar jugador");
            System.out.println("2. Eliminar entrenador");
            System.out.println("0. Anterior");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                
                case 1:
                   
                    System.out.println("Introduzca la id del jugador que quieres eliminar");
                    int idJugador = sc.nextInt();
                    jugadorDao.deleteJugador(idJugador);
                    break;
                case 2:
                    System.out.println("Introduzca la id del entrenador que quieres eliminar");
                    int idEntrenador = sc.nextInt();
                    entrenadorDao.deleteEntrenador(idEntrenador);
                    break;
            }
        }while(opcion != 0);
        
    }
    
    private static void listarJugadorEntrenador(){
        
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Listar jugadores");
            System.out.println("2. Listar entrenadores");
            System.out.println("0. Anterior");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                
                case 1:
                    List<Jugador> jugadores = jugadorDao.findAll();
                    for(Jugador jugador : jugadores){                       
                        System.out.println("ID: " + jugador.getId() + " Nombre: " + jugador.getNombre() + " Posicion: " + jugador.getPosicion() + " Herido: " + jugador.getHerido() + " ID de su entrenador: " + jugador.getEntrenadorId());
                    }
                    break;
                case 2:
                    List<Entrenador> entrenadores = entrenadorDao.findAll();
                    for(Entrenador entrenador : entrenadores){                       
                        System.out.println("ID: " + entrenador.getId() + " Nombre: " + entrenador.getNombre() + " Raza: " + entrenador.getRaza() + " Partidos jugados: " + entrenador.getPartidos());
                    }
                    break;
            }
        }while(opcion != 0);
        
    }
    
    private static void listarJugadoresdeEntrenadores(){
        
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("Introduzca la id del entrenador del cual quiere obtener los jugadores");
        id = sc.nextInt();
        ArrayList<Jugador> jugadores = jugadorDao.findJugadoresdeEntrenadores(id);
        for(Jugador jugador : jugadores){                       
            System.out.println("ID: " + jugador.getId() + " Nombre: " + jugador.getNombre() + " Posicion: " + jugador.getPosicion() + " Herido: " + jugador.getHerido() + " ID de su entrenador: " + jugador.getEntrenadorId());
        }
        
    }
    
    private static void lesionarJugador(){
                    
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("Introduzca la id del jugador que desea lesionar");
        id = sc.nextInt();
        jugadorDao.modifyLesion(id);
    }
    
}
