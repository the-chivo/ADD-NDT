/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica14;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;
/**
 *
 * @author adria
 */

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    // Obtener gastos
    List<Transaction> findByIncomeFalse();
    // Obtener ingresos
    List<Transaction> findByIncomeTrue();

    // Obtener todas las transacciones del último mes
    List<Transaction> findByDateAfter(Date date);

    // Obtener las transacciones con un valor superior a un valor
    List<Transaction> findByQuantityGreaterThan(double value);

    // Obtener las transacciones con un valor entre dos valores dados
    List<Transaction> findByQuantityBetween(double min, double max);

    // Obtener los gastos entre dos fechas
    List<Transaction> findByIncomeFalseAndDateBetween(Date start, Date end);

    // Obtener los gastos de una cantidad menor a una dada
    List<Transaction> findByIncomeFalseAndQuantityLessThan(double value);

    // Obtener los gastos de una cantidad mayor a una dada
    List<Transaction> findByIncomeFalseAndQuantityGreaterThan(double value);
    
    // Buscar por descripción "Compra"
    List<Transaction> findByDescriptionContaining(String word);
}
