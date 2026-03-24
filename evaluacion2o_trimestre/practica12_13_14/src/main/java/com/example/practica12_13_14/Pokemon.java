/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica12_13_14;

import java.util.Date;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pokemon")
public class Pokemon {
	
	@Id
	private String id;
	
	private String name;
	private String type;
	private int level;
	private String trainer;
	private Date date;
	
	public Pokemon () {}
	
	public Pokemon(String name, String type, int level,String trainer, Date captureDate) {
		this.name = name;
		this.type = type;
		this.level = level;
		this.trainer = trainer;
		this.date = date;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	
	public String getTrainer() {return trainer;}
	public void setTrainer(String trainer) {this.trainer = trainer;}
	
	public Date getDate() {return date;}
	public void setDate() {this.date = date;}
}
