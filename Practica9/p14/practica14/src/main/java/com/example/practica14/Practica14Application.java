package com.example.practica14;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class Practica14Application implements CommandLineRunner {

    @Autowired
    private TransactionRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Practica14Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        System.out.println("--- Base de datos limpiadaaaaa ---");

        Calendar cal = Calendar.getInstance();
        
        cal.set(2026, Calendar.MARCH, 1);
        repository.save(new Transaction("Compra Mercadona", 55.20, false, cal.getTime()));
        
        cal.set(2026, Calendar.MARCH, 5);
        repository.save(new Transaction("Nómina Marzo", 2100.00, true, cal.getTime()));
        
        cal.set(2026, Calendar.MARCH, 10);
        repository.save(new Transaction("Factura Luz", 85.00, false, cal.getTime()));
        
        cal.set(2026, Calendar.FEBRUARY, 20); // Fecha mes pasado
        repository.save(new Transaction("Compra Amazon", 120.50, false, cal.getTime()));
        
        cal.set(2026, Calendar.MARCH, 15);
        repository.save(new Transaction("Venta Wallapop", 40.00, true, cal.getTime()));

        System.out.println("--- 5 Transacciones insertadas ---");
        
        System.out.println("\n--- CONSULTA: Todos los Ingresos ---");
        repository.findByIncomeTrue().forEach(t -> System.out.println(t.getDescription() + ": " + t.getQuantity() + "€"));

        System.out.println("\n--- CONSULTA: Todos los Gastos ---");
        repository.findByIncomeFalse().forEach(t -> System.out.println(t.getDescription() + ": " + t.getQuantity() + "€"));

        System.out.println("\n--- CONSULTA: Entre dos fechas (Marzo 2026) ---");
        cal.set(2026, Calendar.MARCH, 1);
        Date inicio = cal.getTime();
        cal.set(2026, Calendar.MARCH, 31);
        Date fin = cal.getTime();
        repository.findByIncomeFalseAndDateBetween(inicio, fin).forEach(t -> System.out.println(t.getDescription() + " - " + t.getDate()));

        System.out.println("\n--- CONSULTA: Descripción contiene 'Compra' ---");
        repository.findByDescriptionContaining("Compra").forEach(t -> System.out.println(t.getDescription()));

        System.out.println("\n--- CONSULTA: Cantidad mayor a 100 ---");
        repository.findByQuantityGreaterThan(100.0).forEach(t -> System.out.println(t.getDescription() + ": " + t.getQuantity() + "€"));
    }
}



