package com.example.fourthsemester;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemsController implements Initializable {

   // ImageView imageView = new ImageView(new Image("Images/Fruits-and-Vegetables-removebg-preview.png"));


@FXML
private ImageView snacksImageView;

   @FXML
    private ImageView vegetablesImageView;
    @FXML
   private ImageView meatImageView;
    @FXML
    private ImageView beverageImageView;




   @Override
    public void initialize(URL myUrl, ResourceBundle myResourceBundle) {
       File vegetableFile = new File("Images/Fruits-and-Vegetables-removebg-preview.png");
       Image vegetableImage = new Image(vegetableFile.toURI().toString());
       vegetablesImageView.setImage(vegetableImage);

       File beverageFile=new File("Images/Dairy-removebg-preview.png");
        Image beverageImage=new Image(beverageFile.toURI().toString());
        beverageImageView.setImage(beverageImage);

       File snacksFile=new File("Images/snacks-removebg-preview.png");
        Image snacksImage=new Image(snacksFile.toURI().toString());
        snacksImageView.setImage(snacksImage);

       File meatFile=new File("Images/meat-fish-removebg-preview.png");
       Image meatImage=new Image(meatFile.toURI().toString());
       meatImageView.setImage(meatImage);



   }

    public void displayVegetables(){

        try{





            FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("shoppingCart.fxml"));
            // FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("items.fxml"));
            // FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("vegetables.fxml"));
            Stage registerState=new Stage();
            registerState.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoad.load(), 600, 400);

            registerState.setScene(scene);
            registerState.show();

        }catch(Exception e){
            e.printStackTrace();
        }







    }



    public void logOut(){

        try{





            FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            // FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("items.fxml"));
            Stage registerStates=new Stage();
            registerStates.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoad.load(), 600, 400);

            registerStates.setScene(scene);
            registerStates.show();

        }catch(Exception e){
            e.printStackTrace();
        }







    }




}