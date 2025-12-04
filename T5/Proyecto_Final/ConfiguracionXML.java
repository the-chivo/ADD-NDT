
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.addt4ef1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author adria
 */
public class ConfiguracionXML {
    
    private static String driver;
    private static String url;
    private static String usuario;
    private static String password;

    // Bloque estático para cargar la configuración al iniciar la clase sin necesidad de crear un objeto de la clase
    static {
        try {
            // TODO: Establecer la ruta relativa del fichero XML
            File file = new File("config.xml");
            
            DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.normalize();
            
            Element root = doc.getDocumentElement();
            driver = root.getElementsByTagName("driver").item(0).getTextContent();
            url = root.getElementsByTagName("url").item(0).getTextContent();
            usuario = root.getElementsByTagName("user").item(0).getTextContent();
            password = root.getElementsByTagName("password").item(0).getTextContent();
            
            // TODO: leer el contenido del fichero XML tal y como vimos en el tema 3

        } catch (Exception e) {
            System.err.println("Error al leer el fichero config.xml");
            e.printStackTrace();
        }
    }

    public static String getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getPassword() {
        return password;
    }
}
