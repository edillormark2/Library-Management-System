/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JFrame;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class DBConnection {
    Connection con = null;
    
    public static Connection ConnectionDB(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_ms.db");
            System.out.print("Connection Succeded");
            return con;
            
        } catch (Exception e){
            System.out.print("Connection Failed" + e);
            return null;
        }
       
    }
}
