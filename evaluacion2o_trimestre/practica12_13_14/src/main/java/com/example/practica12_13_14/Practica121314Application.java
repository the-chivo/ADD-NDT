package com.example.practica12_13_14;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practica121314Application implements CommandLineRunner {
	
	@Autowired
	private PokemonRepository pokemonRepository;

	public static void main(String[] args) {
		SpringApplication.run(Practica121314Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		pokemonRepository.deleteAll();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Pokemon pikachu = new Pokemon("Pikachu", "Electric", 2, "Ash",formato.parse("2026-02-15"));
		Pokemon raichu = new Pokemon("Raichu", "Electric", 15, "Ash",formato.parse("2026-03-20"));
		Pokemon bulbasur = new Pokemon("bulbasur", "Fire", 100, "teamNDT",formato.parse("2026-03-20"));
		Pokemon bata = new Pokemon("bata", "Grass", 5, "teamNDT",formato.parse("2026-02-15"));
		Pokemon machoque = new Pokemon("Machoque", "Stone", 33, "teamNDT",formato.parse("2026-02-15"));
		Pokemon ditto = new Pokemon("Ditto", "Electric", 67, "Ash",formato.parse("2026-02-15"));

		pokemonRepository.save(pikachu);
		pokemonRepository.save(raichu);
		pokemonRepository.save(bulbasur);
		pokemonRepository.save(bata);
		pokemonRepository.save(machoque);
		pokemonRepository.save(ditto);
		/*
		System.out.println("====POKEMONS DEL TEAMDNT====");
		pokemonRepository.findByTrainer("teamNDT").forEach(System.out::println);
                
		System.out.println("==POKEMONS TIPO FUEGO===");
		pokemonRepository.findByType("Fire").forEach(System.out::println);
		
		
		System.out.println("===POKEMONS DE NIVEL MAYOR A 70====");
		pokemonRepository.findByLevelGreaterThan(70).forEach(System.out::println);
		
		System.out.println("===POKEMONS DE NIVEL ENTRE 10 Y 40");
		pokemonRepository.findByLevelBetween(10,40).forEach(System.out::println);
		
		Date antesDe = formato.parse("2026-02-27");
		
		System.out.println("===CAPTURADOS ANTES DEL 27 DE FEBRERO DE 2026");
		pokemonRepository.findByDateBefore(antesDe).forEach(System.out::println);
		
		pokemonRepository.findByWordContainingIgnoreCase("zap").forEach(System.out::println);
		System.out.println("===POKEMONS QUE CONTIENEN zap===="); */
	}
	

}