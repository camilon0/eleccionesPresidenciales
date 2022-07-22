/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class ClsJdbc {
    
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "";
    String bd = "bd_elecciones";
    String url = "jdbc:mysql://localhost:3306/" + this.bd;
    
    public Connection conexion;
    
    public void CrearConexion(){
        
        try {
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url, user, password);
        
            if(this.conexion != null){
            System.out.println("Successful connection");
            }
        
        
        }   catch (Exception error) {
        
            System.out.println("Error:" + error.getMessage());
           }
    
    }
}
