/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.homelan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vva
 */
public class DBWork {
    
    public static void homeLANBase () throws ClassNotFoundException, SQLException {
    
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost:3306/home_lan_base?autoReconnect=true&useSSL=false";

        Connection con = DriverManager.getConnection(url, "root", "183461");
        
        Statement stmt = con.createStatement();
        
//        ResultSet rs = stmt.executeQuery("SELECT * FROM Devices");
        
        ResultSet rs = stmt.executeQuery("SELECT name,(SELECT name FROM Places WHERE id=placeId) AS place FROM Devices");
        
        while (rs.next()){
            String name = rs.getString("name");
            String place = rs.getString("place");
//            Long placeId = rs.getLong("placeId");
            
            
            System.out.print(name + "   ");
            System.out.println(place);
            
        }
    }
    
}
