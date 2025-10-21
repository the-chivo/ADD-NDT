/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
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
        int id;
        File cinema2000 = new File("Cinema2000/reviews");
        File userFile = new File("Cinema2000/Users.txt");
        
        if(!cinema2000.exists()){
            cinema2000.mkdirs();
            userFile.createNewFile();
            User user = new User("Admin", "AdminPass", 0);
            createUser(user, userFile);
        }
        List<User> userList = defineUsers(userFile);
        lastID = getLastID(userList);
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
                    
                    if(userName.matches(".*\\d.*")){
                        System.out.println("El nombre de usuario no puede llevar numeros");
                        break;
                    }
                    
                    for(User user : userList){
                        if(userName.equals(user.getUserName())){
                            System.out.println("Nombre de ususario existente, usa otro");
                            break;
                        }
                    }
                    
                    System.out.println("Contraseña");
                    userPass = sc.nextLine();
                    
                    if(userPass.matches(".*\\d.*")){
                        System.out.println("La contraseña no puede llevar numeros");
                        break;
                    }
                    
                    
                    lastID = getLastID(userList);
                    userID = lastID;
                    User user = new User(userName, userPass, (userID + 1));
                    createUser(user, userFile);
                    userList = defineUsers(userFile); 
                    break;
                case 2:
                    System.out.println("Introduzca la id de el usuario a eliminar");
                    id = sc.nextInt();
                    userList = defineUsers(userFile);
                    deleteUser(userList, userFile, id);
                    break;
                case 3:
                    System.out.println("Añadir review");
                    System.out.println("Escriba el id del usuario del cual es la review");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Escriba el nombre de la pelicula");
                    String moovie = sc.nextLine();
                    System.out.println("Escriba su review");
                    String review = sc.nextLine();
                    userList = defineUsers(userFile);
                    addReview(userList, id, moovie, review);
                    break;
                case 4:
                    System.out.println("Mostrar review");
                    System.out.println("Escriba la id del usuario el cual quiere ver sus reviews");
                    id = sc.nextInt();
                    showReview(userList, id);
                    
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }   
        }while( opcion != 5);
    }
    
    public  static void createUser(User user, File file) throws IOException{
        FileWriter fw = new FileWriter(file ,true);         
        fw.write(user.getUserName() + " " + user.getUserPass() + " " + user.getUserID() + "\n");
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
    
    public static int getLastID(List<User> userList) throws FileNotFoundException, IOException{ 
        int id;
        int index = userList.size() -1;
        id = userList.get(index).getUserID();     
        return id;
    }
    
    public static List<User> defineUsers(File file) throws IOException {
    List<User> userList = new ArrayList<>();

    try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
        while (raf.getFilePointer() < raf.length()) {
            String name = "";
            String pass = "";
            String idStr = "";
            int b;

            while ((b = raf.read()) != 32 && b != -1) {
                name += (char) b;
            }

            while ((b = raf.read()) != 32 && b != -1) {
                pass += (char) b;
            }

            while ((b = raf.read()) != 10 && b != -1 && b != 13) {
                idStr += (char) b;
            }

            if (b == 13 && raf.getFilePointer() < raf.length()) {
                raf.read(); 
            }

            int id = Integer.parseInt(idStr.trim());
            userList.add(new User(name, pass, id));
        }
    }
    return userList;
}
    
    public static void deleteUser(List<User> userList, File file, int id) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.setLength(0); 

        for (User user : userList) {
            if (user.getUserID() != id) {
            createUser(user, file);
            }
        }
    }
    
    public static void addReview(List<User> userList, int id, String moovie, String review) throws IOException{
        User userTarget = null;
        for (User user : userList) {
            if (user.getUserID() == id) {
                userTarget = user;
                break;
            }
        }
        if(userTarget == null){
            System.out.println("User no encontrado");
            return;
        }
        File file = new File("Cinema2000/reviews/" + userTarget.getUserName()+ "-" + userTarget.getUserID() + ".txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        fw.write("Pelicula: " + moovie + "\n");
        fw.write("Reseña: " + review + "\n");
        fw.write("--------------------------------------------" + "\n");
        fw.close();
    }
    
    public static void showReview(List<User> userList, int id) throws FileNotFoundException, IOException{
        User userTarget = null;
        for (User user : userList) {
            if (user.getUserID() == id) {
                userTarget = user;
                break;
            }
        }
        File file = new File("Cinema2000/reviews/" + userTarget.getUserName()+ "-" + userTarget.getUserID() + ".txt");
        FileReader fr = new FileReader(file);
        int i;
        StringBuilder review = new StringBuilder();
        while((i = fr.read()) != -1){
            review.append((char)i);
        }
        fr.close();
        System.out.println(review);
    }  
    
    
    
    
}

