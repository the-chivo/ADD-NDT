package com.adrian.practica;

import javax.swing.SwingUtilities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticaApplication {

	public static void main(String[] args) {
            
            SwingUtilities.invokeLater(() -> {
                new MenuFrame().setVisible(true);
            });
            
		SpringApplication.run(PracticaApplication.class, args);
                        
                
	}

}
