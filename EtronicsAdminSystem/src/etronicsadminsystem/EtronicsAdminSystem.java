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
public class EtronicsAdminSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        UIAdminModel model = new UIAdminModel();
        UIAdminView view = new UIAdminView(model);
        AdminDAOImpl adminDAO = new AdminDAOImpl();
        List<Product> prods = adminDAO.getAllProducts();
        
        int size = prods.size();
        int x = 0;
        while( x < size){
            Product p = prods.get(x);
            System.out.println(p.getID());
            System.out.println(p.getName());
            System.out.println(p.getType());
            System.out.println(p.getDescription());
            System.out.println(p.getPrice());
            System.out.println(p.getPromoID());
            x++;
        }
        
        view.setVisible(true);
    }
    
}
