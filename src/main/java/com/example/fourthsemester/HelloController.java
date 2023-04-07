package com.example.fourthsemester;
import  com.example.fourthsemester.SessionManager;
import  com.example.fourthsemester.UserSession;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView ;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private UserSession session;
    @FXML
    private Label login;


    public void setSession(UserSession session) {
        this.session = session;
    }
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
@FXML
private Label loginMessageLabel;
@FXML
private ImageView brandingImageView;





    public int getUserIdFromDatabase(String username) throws SQLException {
        // establish database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vbazarproject", "root", "Snnoura9160");

        // prepare the SQL statement
        String sql = "SELECT idUserAccount FROM user_accounts WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);

        // execute the query and retrieve the result set
        ResultSet resultSet = statement.executeQuery();

        // extract the user ID from the result set
        int userId = -1; // default value in case no user ID is found
        if (resultSet.next()) {
            userId = resultSet.getInt("idUserAccount");
        }

        // close the resources
        resultSet.close();
        statement.close();
        connection.close();

        return userId;
    }


    public void loginButtonOnAction(ActionEvent e){
    loginMessageLabel.setText("You try to login !");

     if(usernameTextField.getText().isBlank()==false && passwordPasswordField.getText().isBlank()==false){

         //loginMessageLabel.setText("You try to login !");
         validateLogin();
     }else{

         loginMessageLabel.setText("Please enter username and password !");
     }
 }
    @FXML
 private Button cancelButton;
 public void cancelButtonOnAction(ActionEvent e){
     Stage stage =(Stage) cancelButton.getScene().getWindow();
     stage.close();
 }


    public void validateLogin () {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_accounts WHERE username= '" + usernameTextField.getText() + "' AND password='" + passwordPasswordField.getText() + "'";


        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);


            while (queryResult.next()) {

                if (queryResult.getInt(1) == 1) {

                  int userId = getUserIdFromDatabase(usernameTextField.getText());
                   SessionManager sessionManager = new SessionManager();
                    UserSession session = new UserSession(userId);
                    sessionManager.setCurrentSession(session);
                   login.setText("Welcome, " + usernameTextField.getText() + "!"); // Display welcome message

                    loginMessageLabel.setText("Welcome !");
                    // createAccountForm();
                    displayMenu();
                    //login.setText("Welcome, " + usernameTextField.getText() + "!");
//Here
                } else {
                    loginMessageLabel.setText(("Invalid Login. Please try again."));


                }

            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
public void createAccountForm(){

     try{

         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
         //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("items.fxml"));
         Stage registerState=new Stage();
         registerState.initStyle(StageStyle.UNDECORATED);
         Scene scene = new Scene(fxmlLoader.load(), 600, 400);

         registerState.setScene(scene);
         registerState.show();

     }catch(Exception e){
         e.printStackTrace();
     }


}

public void displayMenu(){

     try{





         FXMLLoader fxmlLoad = new FXMLLoader(HelloApplication.class.getResource("items.fxml"));
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










    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile=new File("Images/Fruits-and-Vegetables-removebg-preview.png");
        Image brandingImage=new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }







}