/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etronicsadminsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Brian Heaphy - 14160846
 */

public class UIAdminView extends JFrame implements ActionListener {
    
    //Model
    private UIAdminModel model;
    // Components
    private JPanel mainContent;
    // Basic View
    private JLabel heading;
    private JButton productManButton;
    private JButton userManButton;
    private JButton storeManButton;
    private JButton promoManButton;
    private JButton adManButton;
    // Changing Components
    private JList shopList;
    private DefaultListModel shopListModel;
    // Add Products
    private JLabel addProdTitleLabel;
    private JLabel prodNameLabel;
    private JLabel prodPriceLabel;
    private JLabel categoryLabel;
    private JLabel shopListLabel;
    private JTextField prodNameField;
    private JTextField prodPriceField;
    private JComboBox categoryComboBox;
    private JScrollPane shopComboBox;
    private JButton prodAddButton;
    // Delete Products
    private JLabel delProdTitleLabel;
    private JLabel delProdIDLabel;
    private JLabel shopListLabel2;
    private JTextField prodIDField;
    private JScrollPane shopComboBox2;
    private JButton prodDelButton;
    // Change Product
    private JLabel changeProdTitleLabel;
    private JLabel changeProdIDLabel;
    private JLabel changeProdNameLabel;
    private JLabel changeProdPriceLabel;
    private JLabel changeCategoryLabel;
    private JLabel changeShopListLabel;
    private JTextField changeProdNameField;
    private JTextField changeProdPriceField;
    private JComboBox changeCategoryComboBox;
    private JScrollPane changeShopComboBox;
    private JButton changeProdAddButton;
    // Add Category
    private JLabel chProdTitleLabel;
    private JLabel chProdIDLabel;
    private JLabel idLabel;
    private JComboBox idComboBox;
    private JButton chProdDelButton;
    private JTextField chProdIDField;
    // Promotions
    // AddPromotion
    private JLabel discount;
    private JTextField discountNum;
    private JLabel prod;
    private JTextField productID;
    private JLabel date;
    private JTextField endDate;
    private JButton addPromButton;
    private JPanel addPromPanel;
    private boolean validInput;
    
    
    UIAdminView(UIAdminModel model){
        
        this.model = model;
        shopListModel = model.getShopList();
        // Basic View
        heading = new JLabel("Etronics Admin System", JLabel.CENTER);
        productManButton = new JButton("Product Management");
        userManButton = new JButton("User Management");
        storeManButton = new JButton("Store Management");
        promoManButton = new JButton("Promotional Management");
        adManButton = new JButton("Advertising Management");

        // Changing Components
        shopList = new JList();
        // Add Products
        addProdTitleLabel = new JLabel("Add Product");
        prodNameLabel = new JLabel("Name: ");
        prodPriceLabel = new JLabel("Price: ");
        categoryLabel = new JLabel("Category: ");
        shopListLabel = new JLabel("Shops: ");
        prodNameField = new JTextField();
        prodPriceField = new JTextField();
        categoryComboBox = new JComboBox();
        shopComboBox = new JScrollPane(shopList);
        prodAddButton = new JButton("Add Product");
        // Delete Products
        delProdTitleLabel = new JLabel("Delete Product");
        delProdIDLabel = new JLabel("Product ID: ");
        shopListLabel2 = new JLabel("Shops: ");
        prodIDField = new JTextField();
        shopComboBox2 = new JScrollPane(shopList);
        prodDelButton = new JButton("Delete Product");
        // Change Product
        changeProdTitleLabel = new JLabel("Change Product");
        changeProdIDLabel = new JLabel("ID: ");
        changeProdNameLabel = new JLabel("New Name: ");
        changeProdPriceLabel = new JLabel("New Price: ");
        changeCategoryLabel = new JLabel("New Category: ");
        changeShopListLabel = new JLabel("New Shops: ");
        changeProdNameField = new JTextField();
        changeProdPriceField = new JTextField();
        changeCategoryComboBox = new JComboBox();
        changeShopComboBox = new JScrollPane();
        changeProdAddButton = new JButton("Change Product");
        // Add Category
        chProdTitleLabel = new JLabel("Find Product ID");
        chProdIDLabel = new JLabel("Product Name: ");
        idLabel = new JLabel("ID List: ");
        idComboBox = new JComboBox();
        chProdDelButton = new JButton("Find ID");
        chProdIDField = new JTextField();
    
        mainContent = new JPanel();
        mainContent.setLayout(new BorderLayout());
        heading.setFont(new Font("",Font.PLAIN, 40));
        mainContent.add(heading, BorderLayout.NORTH);
        
        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new GridLayout(0,1));
        mainButtonPanel.setBorder(new EmptyBorder(10, 0, 0, 10));
        mainButtonPanel.add(productManButton);
        mainButtonPanel.add(userManButton);
        mainButtonPanel.add(storeManButton);
        mainButtonPanel.add(promoManButton);
        mainButtonPanel.add(adManButton);
        
        JPanel variablePanel = setupProductGUI();
        
        mainContent.add(mainButtonPanel, BorderLayout.WEST);
        mainContent.add(variablePanel, BorderLayout.CENTER);

        this.setContentPane(mainContent);
        this.setSize(900,600);
        this.setResizable(false);
        this.setTitle("Etronics Admin System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JPanel setupProductGUI(){
        
        JPanel variablePanel = new JPanel();
        //variablePanel.setLayout(new BoxLayout(variablePanel, BoxLayout.Y_AXIS));
        variablePanel.setLayout(new GridLayout(2,2));
        variablePanel.setBorder(new EmptyBorder(10, 0, 0, 10));
        
        // Add Product Panel
        JPanel addProdPanel = new JPanel();
        addProdPanel.setLayout(new BoxLayout(addProdPanel, BoxLayout.Y_AXIS));
        addProdPanel.setBorder(new EmptyBorder(20, 0, 0, 20));
        
        JPanel addProdTitlePanel = new JPanel(new GridLayout(0,1));
        addProdTitlePanel.add(addProdTitleLabel);
        
        JPanel addProdLabelPanel = new JPanel();
        addProdLabelPanel.setLayout(new GridLayout(4, 1));
        addProdLabelPanel.add(prodNameLabel);
        addProdLabelPanel.add(prodPriceLabel);
        addProdLabelPanel.add(categoryLabel);
        addProdLabelPanel.add(shopListLabel);
        
        JPanel addProdToolPanel = new JPanel();
        addProdToolPanel.setLayout(new GridLayout(4, 1));
        addProdToolPanel.add(prodNameField);
        addProdToolPanel.add(prodPriceField);
        addProdToolPanel.add(categoryComboBox);
        addProdToolPanel.add(shopComboBox);
        
        addProdPanel.add(addProdTitlePanel);
        
        JPanel yetAnotherPanel = new JPanel();
        yetAnotherPanel.setLayout(new BoxLayout(yetAnotherPanel, BoxLayout.X_AXIS));
        yetAnotherPanel.add(addProdLabelPanel);
        yetAnotherPanel.add(addProdToolPanel);
        
        addProdPanel.add(yetAnotherPanel);
        
        JPanel addProdButtonPanel = new JPanel(new FlowLayout());
        addProdButtonPanel.add(prodAddButton);
        addProdPanel.add(addProdButtonPanel);
        
        // Delete Product Panel
        JPanel delProdPanel = new JPanel();
        delProdPanel.setLayout(new BoxLayout(delProdPanel, BoxLayout.Y_AXIS));
        delProdPanel.setBorder(new EmptyBorder(20, 0, 0, 20));
        
        JPanel delProdTitlePanel = new JPanel(new GridLayout(0,1));
        delProdTitlePanel.add(delProdTitleLabel);
        
        JPanel delProdLabelPanel = new JPanel();
        delProdLabelPanel.setLayout(new GridLayout(4, 1));
        delProdLabelPanel.add(delProdIDLabel);
        delProdLabelPanel.add(shopListLabel2);
        
        JPanel delProdToolPanel = new JPanel();
        delProdToolPanel.setLayout(new GridLayout(4, 1));
        delProdToolPanel.add(prodIDField);
        delProdToolPanel.add(shopComboBox);
        
        delProdPanel.add(delProdTitlePanel);
        
        JPanel yetAnotherPanel2 = new JPanel();
        yetAnotherPanel2.setLayout(new BoxLayout(yetAnotherPanel2, BoxLayout.X_AXIS));
        yetAnotherPanel2.add(delProdLabelPanel);
        yetAnotherPanel2.add(delProdToolPanel);
        
        delProdPanel.add(yetAnotherPanel2);
        
        JPanel delProdButtonPanel = new JPanel(new FlowLayout());
        delProdButtonPanel.add(prodDelButton);
        delProdPanel.add(delProdButtonPanel);
        
        // Change Product Panel
        JPanel changeProdPanel = new JPanel();
        changeProdPanel.setLayout(new BoxLayout(changeProdPanel, BoxLayout.Y_AXIS));
        changeProdPanel.setBorder(new EmptyBorder(20, 0, 0, 20));
        
        JPanel changeProdTitlePanel = new JPanel(new GridLayout(0,1));
        changeProdTitlePanel.add(changeProdTitleLabel);
        
        JPanel changeProdLabelPanel = new JPanel();
        changeProdLabelPanel.setLayout(new GridLayout(4, 1));
        changeProdLabelPanel.add(changeProdNameLabel);
        changeProdLabelPanel.add(changeProdPriceLabel);
        changeProdLabelPanel.add(changeCategoryLabel);
        changeProdLabelPanel.add(changeShopListLabel);
        
        JPanel changeProdToolPanel = new JPanel();
        changeProdToolPanel.setLayout(new GridLayout(4, 1));
        changeProdToolPanel.add(changeProdNameField);
        changeProdToolPanel.add(changeProdPriceField);
        changeProdToolPanel.add(changeCategoryComboBox);
        changeProdToolPanel.add(changeShopComboBox);
        
        changeProdPanel.add(changeProdTitlePanel);
        
        JPanel yetAnotherPanel3 = new JPanel();
        yetAnotherPanel3.setLayout(new BoxLayout(yetAnotherPanel3, BoxLayout.X_AXIS));
        yetAnotherPanel3.add(changeProdLabelPanel);
        yetAnotherPanel3.add(changeProdToolPanel);
        
        changeProdPanel.add(yetAnotherPanel3);
        
        JPanel changeProdButtonPanel = new JPanel(new FlowLayout());
        changeProdButtonPanel.add(changeProdAddButton);
        changeProdPanel.add(changeProdButtonPanel);
        
        // New Category
        JPanel chProdPanel = new JPanel();
        chProdPanel.setLayout(new BoxLayout(chProdPanel, BoxLayout.Y_AXIS));
        chProdPanel.setBorder(new EmptyBorder(20, 0, 0, 20));
        
        JPanel chProdTitlePanel = new JPanel(new GridLayout(0,1));
        chProdTitlePanel.add(chProdTitleLabel);
        
        JPanel chProdLabelPanel = new JPanel();
        chProdLabelPanel.setLayout(new GridLayout(4, 1));
        chProdLabelPanel.add(chProdIDLabel);
        chProdLabelPanel.add(idLabel);
        
        JPanel chProdToolPanel = new JPanel();
        chProdToolPanel.setLayout(new GridLayout(4, 1));
        chProdToolPanel.add(chProdIDField);
        chProdToolPanel.add(idComboBox);
        
        chProdPanel.add(chProdTitlePanel);
        
        JPanel yetAnotherPanel4 = new JPanel();
        yetAnotherPanel4.setLayout(new BoxLayout(yetAnotherPanel4, BoxLayout.X_AXIS));
        yetAnotherPanel4.add(chProdLabelPanel);
        yetAnotherPanel4.add(chProdToolPanel);
        
        chProdPanel.add(yetAnotherPanel4);
        
        JPanel chProdButtonPanel = new JPanel(new FlowLayout());
        chProdButtonPanel.add(chProdDelButton);
        chProdPanel.add(chProdButtonPanel);
        
        variablePanel.add(addProdPanel);
        variablePanel.add(delProdPanel);
        variablePanel.add(changeProdPanel);
        variablePanel.add(chProdPanel);
        
        return variablePanel;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == addPromButton)
        {
            validInput = validateInput(discountNum.getText(),2);
            validInput = validateInput(productID.getText(), 0);
            if(validInput) {
                int pID = Integer.parseInt(productID.getText());
                int dis = Integer.parseInt(discountNum.getText());
                //have to validate date
                Date lastDate = new Date(endDate.getText());
                Promotion newPromotion = new Promotion(pID, dis, lastDate);
                // ADD TO DB
                //close panel here
            } else {
                discountNum.setText("");
                productID.setText("");
                endDate.setText("");
                JOptionPane.showMessageDialog(null,"Error: Input in incorrect format");
            }
        }
    }
    
    public boolean validateInput(String text, int length)
    {
        String pattern = "[0-9]";
        if(length != 0) pattern = pattern+"{"+length+"}";
        else pattern = pattern+"{0,}";
        if(!(text.matches(pattern)))
        {
            return false;
        }else
        {
            return true;
        }
    }
}
