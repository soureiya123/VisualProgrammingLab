package com.example.fourthsemester;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController  implements Initializable {

    @FXML
    private ImageView myImage;


    @Override
    public void initialize(URL urli, ResourceBundle resourceBundles) {
        File myFile=new File("Images/grocbac1.jpg");
        Image myImageBrand=new Image(myFile.toURI().toString());
        myImage.setImage(myImageBrand);

    }
}
