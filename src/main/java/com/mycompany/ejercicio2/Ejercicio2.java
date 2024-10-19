/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Ejercicio2 {

    public static void main(String[] args) throws SQLException {
      
            String usuario="root";
            String password="";
            String url="jdbc:mysql://localhost/ejercicio2";
            
            Connection conexion;
            Statement statement;
            ResultSet rs;
            
            try {
                conexion=DriverManager.getConnection(url,usuario,password);
                statement=conexion.createStatement();
                rs=statement.executeQuery("SELECT * FROM `usuarios`");
                while (rs.next()){
                    System.out.println(rs.getString("nombres"));
                }
                statement.execute("INSERT INTO `usuarios` (`id`, `Documento`, `Nombres`) VALUES (NULL, '1234', 'andrew mendoza');");
                System.out.println();
                 rs=statement.executeQuery("SELECT * FROM `usuarios`");
                while (rs.next()){ 
                    System.out.println(rs.getString("nombres"));
                    
                }
                } catch (SQLException ex) {
                Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}