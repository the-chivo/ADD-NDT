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
        File cinema2000 = new File("Cinema2000");
        File userFile = new File("Cinema2000/Users.txt");
        
        if(!cinema2000.exists()){
            cinema2000.mkdirs();
            userFile.createNewFile();
        }
  
        
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
                    User user = new User(userName, userPass, userID ++);
                    createUser(user, userFile);
                    break;
                case 2:
                    System.out.println("eliminar");
                    break;
                case 3:
                    System.out.println("Añadir review");
                    setID(userFile);
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
    
    public static void setID(File file) throws FileNotFoundException, IOException{
        RandomAccessFile raf = new RandomAccessFile(file, "rws");
        long position = -1;
        int c;
        char character;
        while ((c = raf.read()) != -1) {
            if ((char) c == '#') {
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
    
    public static void setLastID(File file){
        char character;
    }
}
