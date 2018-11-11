/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etronicsadminsystem;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class AdminDAOImpl implements AdminDAO{
    
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private CallableStatement cStmt = null;
    private ResultSet resultSet = null;
    //private List<User> users;
    private List<Product> products = null;
    private List<Promotion> promos = null;

    public AdminDAOImpl(){
        ConnectionHandler connHan = new ConnectionHandler();
        conn = connHan.makeConnection();
    }
    
    @Override
    public List<Product> getAllProducts(){
        products = new ArrayList<Product>();
        try{
            cStmt = conn.prepareCall("{call get_all_products()}");
            boolean result = cStmt.execute();
            
            if(result){    
                resultSet = cStmt.getResultSet();
            }
            else{
                products = null;
                return products;
            }
            
            Product prod = null;
            while(resultSet.next()){
                prod = new Product();
                prod.setID(Integer.parseInt(resultSet.getString("id")));
                prod.setName(resultSet.getString("name"));
                prod.setType(resultSet.getString("type"));
                prod.setDescription(resultSet.getString("description"));
                prod.setPrice(Integer.parseInt(resultSet.getString("price")));
                if(isInt(resultSet.getString("promoID"))){
                    prod.setPromoID(Integer.parseInt(
                            resultSet.getString("promoID")));
                }
                else
                    prod.setPromoID(0);
                
                products.add(prod);
            }
        }catch(SQLException se){
            throw new RuntimeException("Error communicating with server.", se);
        }
        
        return products;
    }
    
    public boolean isInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }

    @Override
    public List<Promotion> getAllPromotions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertProduct(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertPromotion(Promotion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProduct(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
