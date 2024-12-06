/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.*;

/**
 *
 * @author Vanessa
 */
public class conexion {
    
    public static final String URL="jdbc:mysql://localhost:3307/estacionamiento";
     public static final String USERNAME="root";
      public static final String PASSWORD="";
      
      PreparedStatement ps;
      ResultSet rs;
      
      public static Connection getConection(){
          Connection con = null;
          
          try{
              ///Class.forName("com.mysql.jdbc.Driver");
              Class.forName("com.mysql.cj.jdbc.Driver");
              con=(Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
              System.out.println("Conexion correcta");
              
          }catch(Exception e){
              System.out.print(e);
              
          }
          return con;
      }
    
      
      public static void main(String[] args) {
            Connection con = getConection();
            if (con != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Error al conectar");
            }
        }
      
      

     
    
}


