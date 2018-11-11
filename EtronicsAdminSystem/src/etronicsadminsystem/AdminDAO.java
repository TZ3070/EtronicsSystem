/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etronicsadminsystem;

import java.util.List;

/**
 *
 * @author Brian
 */
public interface AdminDAO {
    //List<User> getAllUsers();
    List<Product> getAllProducts();
    List<Promotion> getAllPromotions();
    //void insertUser(User u);
    void insertProduct(Product p);
    void insertPromotion(Promotion p);
    //void updateUser(User u);
    void updateProduct(Product p);
    //void deleteUser();
    void deleteProduct();
}
