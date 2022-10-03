/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.funciones;
import java.sql.*;

/**
 *
 * @author xavia
 */
public class Bbdd {

  Driver driver=null;
  static Connection conn=null;


public static void connexio(String[]args) {
  String url="jdbc:mysql://localhost:3306/pes";
  String usuari="root";
  String password="Admin123";

    try {
        conn= (Connection) DriverManager.getConnection(url, usuari, password);
    } catch (SQLException e) {
        System.out.println("Error "+e.getMessage());
    }
}   
    
     public int consulta() throws SQLException {
    connexio(null);
    int codi=0;
    Statement declaracio = conn.createStatement();
    String sentencia="Select * From planeta;";
    ResultSet rs= declaracio.executeQuery(sentencia);
    
      while (rs.next()){
          System.out.println(rs.getString(1));
      }

    return codi;  
  }
}
