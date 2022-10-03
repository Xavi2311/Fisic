/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.sql.*;

/**
 *
 * @author xavia
 */
public class Fisic{

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
    
    public long getDistancia (String nom)throws SQLException{
        long distancia=0;
        connexio(null);
        String consulta=("Select distancia FROM planeta where (nom)=('"+nom+"');");
        Statement statement=conn.createStatement();
        ResultSet rs= statement.executeQuery(consulta);
          while (rs.next()){
            distancia=rs.getInt(1);
          }
        return distancia;
    }
    
    public double getTemps (String nom)throws SQLException{
        long distancia = this.getDistancia(nom);
        System.out.println(distancia);
        final double distanciaPerAny=77.5;
        double temps=distancia/distanciaPerAny;
        
        
        return temps;
    }
    
    
    
    
    public long getRadi (String nom) throws SQLException{
        long radi=0;
        connexio(null);
        String consulta=("Select radi FROM planeta where (nom)=('"+nom+"');");
        Statement statement=conn.createStatement();
        ResultSet rs= statement.executeQuery(consulta);
          while (rs.next()){
            radi=rs.getInt(1);
          }
        return radi;
    }


    public long calculararea(long radi){
        final double pi=3.14;
        long area=(long) (2*pi*radi);

        return area;
    }

    public long preucombustible(long area) {
       final long metresCubicsKM=80;
       final long factorConvLitres=1000;
       final long preuLitre=10000;
    
       long costosCombustible = ((area*metresCubicsKM)*factorConvLitres)*preuLitre;
       System.out.println(costosCombustible);

       return costosCombustible;
    }

    public long calcularCostos(String nom)throws SQLException{
        long radi= getRadi(nom);
        long preuPlaneta=preucombustible(calculararea(radi));
        return preuPlaneta;
    }
}