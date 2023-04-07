package com.example.fourthsemester;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){

        String databaseName="vbazarproject";
        String databaseUser="root";
        String databasePassword="Snnoura9160";
        String url="jdbc:mysql://localhost/"+ databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch (Exception e){

            e.printStackTrace();
        }

            return databaseLink;
    }


}
