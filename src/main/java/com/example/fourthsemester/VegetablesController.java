package com.example.fourthsemester;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VegetablesController implements Initializable {

    @FXML
    private TableView<ItemSearchModel> productTableView;
    @FXML
    private TableColumn<ItemSearchModel,String>nameColumn;
    @FXML
    private TableColumn<ItemSearchModel,String>weightColumn;

    @FXML
    private TableColumn<ItemSearchModel,Float>priceColumn;

    @FXML
    private TableColumn<ItemSearchModel,Integer>itemId;

    ObservableList<ItemSearchModel>itemSearchModelObservableList= FXCollections.observableArrayList();


    @Override
    public void initialize(URL urlI, ResourceBundle resourceBundles) {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String productViewQuery="SELECT item.iditems,item.name,item.weight,item.price FROM item JOIN categories ON categories.idcategories = item.categories_idcategories WHERE categories.categoriescol = 'Vegetables'";
       // String productViewQuery=  "SELECT name,weight,price FROM items ";



        try{

            Statement statement=connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(productViewQuery);


            while(queryResult.next()){
                Integer queryNameItemID=queryResult.getInt("iditems");
            String queryNameItems=queryResult.getString("name");
            BigDecimal queryNameWeight=queryResult.getBigDecimal("weight");
            BigDecimal queryNamePrice=queryResult.getBigDecimal("price");


            itemSearchModelObservableList.add(new ItemSearchModel(queryNameItemID,queryNameItems,queryNameWeight,queryNamePrice));
                itemId.setCellValueFactory(new PropertyValueFactory<>("iditems"));
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
                priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));






            }
                productTableView.setItems(itemSearchModelObservableList);

        }catch (Exception e){

            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();

        }
    }



}
