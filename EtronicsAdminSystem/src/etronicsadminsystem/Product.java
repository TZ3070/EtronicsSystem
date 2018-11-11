/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etronicsadminsystem;

/**
 *
 * @author Brian
 */
public class Product {
    
    private int id;
    private String name;
    private String type;
    private String description;
    private int price;
    private int promoID;
    
    public Product(){
        
    }
    
    public Product(int id, String name, 
                String type, String description, int price, int promoID){
        
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
        this.promoID = promoID;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int i){
        id = i;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String t){
        type = t;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String d){
        description = d;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int p){
        price = p;
    }
    
    public int getPromoID(){
        return promoID;
    }
    
    public void setPromoID(int p){
        promoID = p;
    }
}
