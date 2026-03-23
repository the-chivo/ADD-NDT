/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica14;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author adria
 */
@Document(collection = "AccesoADatosCollection") 
public class Transaction {

    @Id
    private String id;

    @Field("description") 
    private String description;

    @Field("quantity")
    private double quantity;

    @Field("income")
    private boolean income;

    @Field("date")
    private Date date;

    
    public Transaction() {
    }

    
    public Transaction(String description, double quantity, boolean income, Date date) {
        this.description = description;
        this.quantity = quantity;
        this.income = income;
        this.date = date;
    }

    
    public String getId() {return id;}
    

    public void setId(String id) {this.id = id;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public double getQuantity() {return quantity;}

    public void setQuantity(double quantity) {this.quantity = quantity;}

    public boolean isIncome() {return income;}

    public void setIncome(boolean income) {this.income = income;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}
}