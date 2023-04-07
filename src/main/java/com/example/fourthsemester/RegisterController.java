package com.example.fourthsemester;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import  java.util.ResourceBundle;
import java.io.File;


public class RegisterController {


@FXML
private Button registerButton2;
@FXML
    Label RegistrationLabel;

@FXML
private PasswordField passwordPasswordField;
@FXML
private PasswordField confirmPasswordField;
@FXML
Label notmatchLabel;
@FXML
private TextField firstnameTextField;
@FXML
private TextField usernameTextField;


public void registerButtonOnAction(ActionEvent event){

   // RegistrationLabel.setText("User has been registered successfully");
   // registerUser();
     if(passwordPasswordField.getText().equals(confirmPasswordField.getText())) {

         registerUser();
        notmatchLabel.setText("");
         //RegistrationLabel.setText("User has been register succesfully");

    }else{

        notmatchLabel.setText("Password doesn't match");
    }

}

public void registerUser(){


    DatabaseConnection connectMe=new DatabaseConnection();
    Connection connectDB=connectMe.getConnection();

    //String name=firstnameTextField.getText();
   // String lastname="";
    String username=usernameTextField.getText();
    String password=passwordPasswordField.getText();
    String name=firstnameTextField.getText();

  //  String insertFields="INSERT INTO vbazarproject.user_accounts (username,password,name) VALUES ( '";
   // String insertValues=firstnameTextField+"','"+usernameTextField+ "','"+passwordPasswordField+" ')";
    //String insertToRegister=insertFields+insertValues;
    String insertFields="INSERT INTO user_accounts (username,password,name) VALUES (?, ?, ?)";


    try{

        Statement statement=connectDB.createStatement();
      //  statement.executeUpdate(insertToRegister);
        PreparedStatement pstmt = connectDB.prepareStatement(insertFields);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, name);
        pstmt.executeUpdate();
        RegistrationLabel.setText("User has been register with succesfully");
        // Set up session for new user
        SessionManager sessionManager = new SessionManager();
        UserSession session = sessionManager.getCurrentSession();
        //session.setUserId(getUserIdByUsername(username, connectDB));

        // Redirect user to account page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        HelloController controller = loader.getController();
        controller.setSession(session);






    }catch (Exception e){

        e.printStackTrace();
        e.getCause();

    }

   /* if(passwordPasswordField.getText().equals(confirmPasswordField.getText())) {
        notmatchLabel.setText("You are set");

    }else{

        notmatchLabel.setText("Password doesn't match");
    }
*/

}
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage =(Stage) registerButton2.getScene().getWindow();
        stage.close();
    }
}
