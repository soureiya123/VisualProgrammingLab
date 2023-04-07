package com.example.fourthsemester;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderListController implements Initializable {


    @FXML
    private TableView<OrderListModel> orderList;


    @FXML
    private TableColumn<OrderListModel,String> ProductName;
    @FXML
    private TableColumn<OrderListModel,Double>productWeight;

    @FXML
    private TableColumn<OrderListModel,Double>ProductPrice;

    ObservableList<OrderListModel>orderListModelObservableList=FXCollections.observableArrayList();



    public void initialize(URL urlMine, ResourceBundle resourceBundlesMine) {

        DatabaseConnection connectMeNo=new DatabaseConnection();
        Connection connectMyDataBase=connectMeNo.getConnection();


        // String productViewQuery="SELECT items.name,items.weight,items.price FROM items JOIN categories ON categories.idcategories = items.categories_idcategories WHERE categories.categoriescol = 'Vegetables'";
        //A remettre String MyproductViewQuery=  "SELECT name,weight,price FROM items  ";
        String MyproductOrderQuery=  "SELECT name,weight,price FROM item ";
        //String MyproductViewQuery=  "SELECT name,weight,price FROM items WHERE id=1 ";





        try{





            Statement Mystatement=connectMyDataBase.createStatement();
            ResultSet MyqueryResult= Mystatement.executeQuery(MyproductOrderQuery);


            while(MyqueryResult.next()){

                String queryNameItems=MyqueryResult.getString("name");
                BigDecimal queryNameWeight=MyqueryResult.getBigDecimal("weight");
                BigDecimal queryNamePrice=MyqueryResult.getBigDecimal("price");

                orderListModelObservableList.add(new OrderListModel(queryNameItems,queryNameWeight,queryNamePrice));
                //itemSearchModelObservableList.add(new ItemSearchModel(queryNameItem,queryNameWeigh,queryNamePric));
                // itemSeacrhModel2cartObservableList.add(new ItemSeacrhModel2cart(queryNameItem,queryNameWeigh,queryNamePric));

                ProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
                productWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
                ProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));





            }
           orderList.setItems(orderListModelObservableList);





        }catch (Exception e){

            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();

        }
    }


}
