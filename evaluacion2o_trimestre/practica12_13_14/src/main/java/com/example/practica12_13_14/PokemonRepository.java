package com.example.practica12_13_14;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface PokemonRepository extends MongoRepository<Pokemon, String> {
	
    List<Pokemon> findByType(String type); 
    List<Pokemon> findByLevelGreaterThan (int level);
    List<Pokemon> findByLevelBetween(int min, int max);
    List<Pokemon> findByTrainer(String trainer); 
    List<Pokemon> findByDateBefore(Date date);
    List<Pokemon> findByWordContainingIgnoreCase(String word);

}
