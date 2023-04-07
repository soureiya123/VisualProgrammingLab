package com.example.fourthsemester;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartController implements Initializable {

 @FXML
 private TableView<cartModel> myCart;

 @FXML
 private TableColumn<cartModel,String> nameColumn;
 @FXML
 private TableColumn<cartModel, BigDecimal>weightColumn;

 @FXML
 private TableColumn<cartModel,BigDecimal>priceColumn;
@FXML
// private TableColumn<cartModel,String>userUsername;

ObservableList<cartModel>cartModelObservableList=FXCollections.observableArrayList();

 @Override
 public void initialize(URL urlii, ResourceBundle resourceBundless) {


  DatabaseConnection myConnexion=new DatabaseConnection();
  Connection conectMeToDatabae=myConnexion.getConnection();

  // String productViewQuery="SELECT item.iditems,item.name,item.weight,item.price FROM item JOIN categories ON categories.idcategories = item.categories_idcategories WHERE categories.categoriescol = 'Vegetables'";
  String productQuery=  "SELECT  p.name name,p.weight weight,p.price price FROM cart c JOIN user_accounts u ON c.user_accounts_idUserAccount = u.idUserAccount JOIN item p ON c.item_iditems = p.iditems";



  try{

   Statement statement=conectMeToDatabae.createStatement();
   ResultSet queryResult= statement.executeQuery(productQuery);


   while(queryResult.next()){
    //Integer queryNameItemID=queryResult.getInt("iditems");
    String queryName=queryResult.getString("name");
    BigDecimal queryWeight=queryResult.getBigDecimal("weight");
    BigDecimal queryPrice=queryResult.getBigDecimal("price");

cartModelObservableList.add(new cartModel(queryName,queryWeight,queryPrice));
    //cartModelObservableList.add(new ItemSearchModel(queryName,queryWeight,queryPrice));
   // itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("iditems"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));






   }
   myCart.setItems(cartModelObservableList);

  }catch (Exception e){

   Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null,e);
   e.printStackTrace();

  }
 }





}


 //private Cart cart;a mettre labas

// private TableView<Order> orderTable;

 /* a revoir saaaa public void viewOrder() {
  cartModel selectedOrder = itemTableView.getSelectionModel().getSelectedItem();
  if (selectedOrder != null) {
   int orderId = selectedOrder.getId();
   try {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
    PreparedStatement stmt = conn.prepareStatement("SELECT u.name, i.item_name FROM order o JOIN user u ON o.user_id = u.id JOIN order_item oi ON o.id = oi.order_id JOIN item i ON oi.item_id = i.id WHERE o.id = ?");
    stmt.setInt(1, orderId);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
     String userName = rs.getString("name");
     String itemName = rs.getString("item_name");
     System.out.println(userName + " ordered " + itemName);
    }
    conn.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  }
et sa oxiiii



*/



    // Other FXML-defined elements and properties...

    //private DatabaseUtils dbUtils;






   /* @Override
    public void initialize(URL urlI, ResourceBundle resourceBundles) {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

       // String productViewQuery="SELECT items.name,items.weight,items.price FROM items JOIN categories ON categories.idcategories = items.categories_idcategories WHERE categories.categoriescol = 'Vegetables'";
         String productViewQuery=  "SELECT name,weight,price FROM items ";



        try{

            Statement statement=connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(productViewQuery);


            while(queryResult.next()){

                String queryNameItems=queryResult.getString("name");
                String queryNameWeight=queryResult.getString("weight");
                String queryNamePrice=queryResult.getString("price");

             // cartModelObservableList.add(new ItemSearchModel(queryNameItems,queryNameWeight,queryNamePrice));

                nameCart.setCellValueFactory(new PropertyValueFactory<>("name"));
                priceCart.setCellValueFactory(new PropertyValueFactory<>("weight"));
                quantityCart.setCellValueFactory(new PropertyValueFactory<>("price"));





            }
            productTableView.setItems(cartModelObservableList);

        }catch (Exception e){

            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();

        }
    }


     public void addToCart(int itemId, String itemName, double itemPrice, int itemQuantity) {
        // Create a new CartItem object with the passed parameters
        CartItem cartItem = new CartItem(itemId, itemName, itemPrice, itemQuantity);

        // Add the new CartItem to the user's cart
        cart.getItems().add(cartItem);
    }

*/







