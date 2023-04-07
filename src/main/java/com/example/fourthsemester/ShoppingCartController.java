package com.example.fourthsemester;
import com.example.fourthsemester.SessionManager;
import com.example.fourthsemester.UserSession;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ShoppingCartController implements Initializable {

    @FXML
    private TableView<ItemSearchModel> cartTable;

    @FXML
    private Button addToCartButton;
    @FXML
    private TableColumn<ItemSearchModel,Integer> itemIdColumn;
    @FXML
    private TableColumn<ItemSearchModel,String> productNameColumn;

    @FXML
    private TableColumn<ItemSearchModel,Integer> idColumn;
    @FXML
    private TableColumn<ItemSearchModel,BigDecimal>quantityColumn;

    @FXML
    private TableColumn<ItemSearchModel,BigDecimal>priceColumn;



    ObservableList<ItemSearchModel>itemSearchModelObservableList= FXCollections.observableArrayList();


   @FXML
    private Button handleButton;

   //sa commence ici si sa ne va pas j'enleve

    @FXML
    private TableView<ItemSearchModel> cartTabl;

    @FXML
    private Button addToCartButto;
    @FXML
    private TableColumn<ItemSearchModel,String> productNameColum;
    @FXML
    private TableColumn<ItemSearchModel, BigDecimal>quantityColum;

    @FXML
    private TableColumn<ItemSearchModel,BigDecimal>priceColum;

   // ObservableList<ItemSeacrhModel2cart>itemSeacrhModel2cartObservableList= FXCollections.observableArrayList();
    //ObservableList<ItemSearchModel>itemSearchModelObservableList= FXCollections.observableArrayList();

   // private TableView<ItemSearchModel> cartTable;


    //private TableView<Item> itemTableView;

    @FXML
    private void handleAddToNewItem(ActionEvent event) {
        // Get the selected item in the TableView
        ItemSearchModel selectedItem = cartTable.getSelectionModel().getSelectedItem();
        int userId = 1;
        int itemId=1;

        // Get the item ID from the selected item
        //int itemId = selectedItems.getId();

        // Set the quantity (you will need to replace this with the actual quantity)
        int quantity = 1;
        if (selectedItem != null) {
            // Get the values of the selected row
            Integer item_iditems=selectedItem.getIditems();
            String name = selectedItem.getName();
            BigDecimal weight = selectedItem.getWeight();
            BigDecimal price = selectedItem.getPrice();
            //Integer ID = selectedItem. getIditems();
            DatabaseConnection connectItem=new DatabaseConnection();
            Connection connectData=connectItem.getConnection();


            try {
                // Insert the selected row into the new MySQL table
             String insertSQL = "INSERT INTO cart (name, weight, price,user_accounts_idUserAccount, item_iditems,item_categories_idcategories) VALUES (?, ?, ?,1,?,1)";

                PreparedStatement preparedStatement = connectData.prepareStatement(insertSQL);
              preparedStatement.setString(1, name);
                preparedStatement.setBigDecimal(2, weight);
               preparedStatement.setBigDecimal(3, price);
                preparedStatement.setInt(4, item_iditems);


                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


   /* public void InsertWithUserIdOrder(){

        SessionManager sessionManager = new SessionManager();
        UserSession session = sessionManager.getCurrentSession();
        int userId = session.getUserId();


        ItemSearchModel selectedItemUser = cartTable.getSelectionModel().getSelectedItem();

        if (selectedItemUser != null) {
            // Get the values of the selected row
            String name = selectedItemUser.getName();
            String  weight = selectedItemUser.getWeight();
            String price = selectedItemUser.getPrice();
            DatabaseConnection connectItem=new DatabaseConnection();
            Connection connectData=connectItem.getConnection();


            try {
                // Insert the selected row into the new MySQL table
                String insertSQL = "INSERT INTO myorders ( user_accounts_idUserAccount, items_iditems, items_categories_idcategories) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connectData.prepareStatement(insertSQL);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, weight);
                preparedStatement.setString(3, price);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }*/




































    public void displayOrder(){


    try{

        FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("cart.fxml"));
        // FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("items.fxml"));
        Stage registerStat=new Stage();
        registerStat.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(fxmlLoad.load(), 600, 400);

        registerStat.setScene(scene);
        registerStat.show();

    }catch(Exception e){
        e.printStackTrace();
    }





}


   /* public void insertData(String name, String price) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vbazarproject", "root", "Snnoura9160");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO essai (name, price) VALUES (?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, price);
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*

   private TableView<Item> itemTable;
    private TableView<ItemSearchModel> cartTable;

    // ...*/






    @FXML
  /* private void handleAddButtonAction(ActionEvent event) {


        System.out.println("Bouton is cliked");
        handleButton.setText("Clicked");
        // Get the selected item from the table viewItemSearchModel selectedItem = cartTable.getSelectionModel().getSelectedItem();
        ItemSearchModel selectedItem = cartTable.getSelectionModel().getSelectedItem();
       // MyData myData = tableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // Extract the name and price data from the selected row
            String name = selectedItem.getName();
            String price = selectedItem.getPrice();

            // Insert the data into the new table in your MySQL database
            //insertData(name, price);
        }

TableView.TableViewSelectionModel<ItemSearchModel> selectionModel = cartTabl.getSelectionModel();
      //  ItemSearchModel selectedItem = selectionModel.getSelectedItem();

       // Extract the properties of the selected item
       // int itemId = selectedItem.getItemId();
        String itemName = selectedItem.getName();
        String itemPrice = selectedItem.getPrice();
       // String itemQuantity = selectedItem.getQuantity();

      // Load the FXML file for the cart view
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
       // Parent cartRoot = loader.load();








         try{





         FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("cart.fxml"));
        // FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
         //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("items.fxml"));
         Stage registerStat=new Stage();
         registerStat.initStyle(StageStyle.UNDECORATED);
         Scene scene = new Scene(fxmlLoad.load(), 600, 400);

         registerStat.setScene(scene);
         registerStat.show();

     }catch(Exception e){
         e.printStackTrace();
     }






        // Display a confirmation message
       String message = "Added " + selectedItem.getName() + " to the cart.";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.showAndWait();


        // Print a message to the console
        System.out.println("Add button clicked!");







    }




*/


  @Override
    public void initialize(URL urlI, ResourceBundle resourceBundles) {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        // String productViewQuery="SELECT item.iditems,item.name,item.weight,item.price FROM item JOIN categories ON categories.idcategories = item.categories_idcategories WHERE categories.categoriescol = 'Vegetables'";
       String productViewQuery=  "SELECT iditems, name,weight,price FROM item ";



        try{

            Statement statement=connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(productViewQuery);


            while(queryResult.next()){
                Integer queryNameItemID=queryResult.getInt("iditems");
                String queryNameItems=queryResult.getString("name");
                BigDecimal queryNameWeight=queryResult.getBigDecimal("weight");
                BigDecimal queryNamePrice=queryResult.getBigDecimal("price");


                itemSearchModelObservableList.add(new ItemSearchModel(queryNameItemID,queryNameItems,queryNameWeight,queryNamePrice));
                itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("iditems"));
                productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                quantityColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
                priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));






            }
            cartTable.setItems(itemSearchModelObservableList);

        }catch (Exception e){

            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();

        }
    }





    public void addToOrder() {
        // Get the selected row in the TableView
        ItemSearchModel selectedItems= cartTable.getSelectionModel().getSelectedItem();

        // Get the user ID (you will need to replace this with the actual user ID)
        int userId = 1;

        // Get the item ID from the selected item
        int itemId = selectedItems. getIditems();

        // Set the quantity (you will need to replace this with the actual quantity)
        int quantity = 1;

        // Calculate the total price
     // BigDecimal totalPrice = selectedItem.getPrice() *quantity;
        double totalPrice = quantity;

        // Insert the data into the order table
        DatabaseConnection connectMeNow=new DatabaseConnection();
        Connection con=connectMeNow.getConnection();

        try {
            String query = "INSERT INTO `order` (user_id, item_id, quantity, total_price) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
          pstmt.setInt(1, userId);
          pstmt.setInt(2, itemId);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, totalPrice);
           pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void justeUnssai(ActionEvent event) {
        // Get the selected item in the TableView
        ItemSearchModel selectedItems = cartTable.getSelectionModel().getSelectedItem();
        int userId = 1;
        int itemId=1;

        // Get the item ID from the selected item
        //int itemId = selectedItems.getId();

        // Set the quantity (you will need to replace this with the actual quantity)
        int quantity = 1;
        if (selectedItems != null) {
            // Get the values of the selected row
            String name = selectedItems.getName();
            BigDecimal weight = selectedItems.getWeight();
            BigDecimal price = selectedItems.getPrice();
            Integer ID = selectedItems. getIditems();
            DatabaseConnection connectItem=new DatabaseConnection();
            Connection connectData=connectItem.getConnection();


            try {
                // Insert the selected row into the new MySQL table
                String insertSQL = "INSERT INTO item (name, weight, price,categories_idcategories) VALUES (?, ?, ?,1)";
                PreparedStatement preparedStatement = connectData.prepareStatement(insertSQL);
                preparedStatement.setString(1, name);
                preparedStatement.setBigDecimal(3, weight);
                preparedStatement.setBigDecimal(3, price);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }




}
