/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Mavenproject1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        String userName;
        String userPass;
        int userID = 0;
        int lastID = 0;
        File cinema2000 = new File("Cinema2000");
        File userFile = new File("Cinema2000/Users.txt");
        
        if(!cinema2000.exists()){
            cinema2000.mkdirs();
            userFile.createNewFile();
            User user = new User("Admin", "AdminPass", 0);
            createUser(user, userFile);
        }    
        lastID = getLastID(userFile);
        userID = lastID;
        do{
            System.out.println("Menu biblioteca2000");
            System.out.println("1.Crear usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("Añadir review de un usuario");
            System.out.println("Mostrar reviews de un usuario");
            System.out.println("Salir");
            
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                
                case 1:
                    System.out.println("crear user");
                    System.out.println("Escriba su nombre de usuario");
                    userName = sc.nextLine();
                    System.out.println("Contraseña");
                    userPass = sc.nextLine();
                    lastID = getLastID(userFile);
                    userID = lastID;
                    User user = new User(userName, userPass, (userID + 1));
                    createUser(user, userFile);
                    break;
                case 2:
                    System.out.println("eliminar");
                    break;
                case 3:
                    System.out.println("Añadir review");
                    defineUsers(userFile);
                    break;
                case 4:
                    System.out.println("Mostrar review");
                    break;
                default:
                    System.out.println("ue as puesto");
            }   
        }while( opcion != 5);
    }
    
    public  static void createUser(User user, File file) throws IOException{
        FileWriter fw = new FileWriter(file ,true);
        fw.write(user.getUserName() + " " + user.getUserPass() + " " + user.getUserID() + " #" + "\n");
        fw.close();
    }
    
    public static void setID(File file, int ID) throws FileNotFoundException, IOException{
        RandomAccessFile raf = new RandomAccessFile(file, "rws");
        long position = -1;
        int c;
        char character;
        while ((c = raf.read()) != -1) {
            if ((char) c == '#' && raf.getFilePointer() - 3 == ID) {
                position = raf.getFilePointer() - 3;
                break;
            }       
        }
        if(position >= 0){
            raf.seek(position);
            int byteID = raf.read();
            System.out.println((char) byteID );

        }      
    }
    
    public static int getLastID(File file) throws FileNotFoundException, IOException{
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        int id;
        raf.seek(file.length() - 4);
        id = raf.read();
        return id - '0';
    }
    
    public static void defineUsers(File file) throws IOException {
    try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
        while (raf.getFilePointer() < raf.length()) {
            StringBuilder name = new StringBuilder();
            StringBuilder pass = new StringBuilder();

            // Leer nombre hasta espacio
            int b;
            while ((b = raf.read()) != 32 && b != -1) {
                name.append((char) b);
            }

            // Leer contraseña hasta espacio
            while ((b = raf.read()) != 32 && b != -1) {
                pass.append((char) b);
            }

            // Leer ID (asumimos que es un entero de 4 bytes)
            int id = raf.readInt();

            System.out.println("Nombre: " + name + ", Contraseña: " + pass + ", ID: " + id);
        }
    }
}
}

