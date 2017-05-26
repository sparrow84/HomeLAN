/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.homelan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vva
 */
@WebServlet(name = "TS001", urlPatterns = {"/TS001"})
public class TS001 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
//        response.setContentType("text/html;charset=UTF-8");
        
        
        Class.forName("com.mysql.jdbc.Driver");
//        Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:mysql://localhost:3306/home_lan_base?autoReconnect=true&useSSL=false";
//        String url = "jdbc:postgresql://localhost:5432/postgres";

        Connection con = DriverManager.getConnection(url, "root", "183461");
//        Connection con = DriverManager.getConnection(url, "root", "183461");
//        Connection con = DriverManager.getConnection(url, "postgres", "qwerty");
        
        Statement stmt = con.createStatement();
        
        // Нужно экранировать сзапрос. Пока не знаю как
        ResultSet rs = stmt.executeQuery("SELECT name,(SELECT name FROM Places WHERE id=placeId) AS place FROM Devices");
        
        
        // Создаём изменяймые строки для заиси результата запроса
        StringBuilder sb = new StringBuilder();
        
        sb.append("<table> <tr> <th><h2>Comp name</h2></th>   <th><h2>Place</h2></th> </tr>");
        
        while (rs.next()){
            String name = rs.getString("name");
            String place = rs.getString("place");
            
            sb.append("<tr align=left> <th>").append(name).append("</th> <th>").append(place).append("</th> </tr>");
            
        }
        
        /*
        
        <table>
        <tr> <th>Month</th>   <th>Savings</th> </tr>
        <tr> <td>January</td> <td>$100</td>    </tr>
        </table>
        
        */
        
        sb.append("</table>");
        
        String DevTable;
        DevTable = sb.toString();
        
        request.setAttribute("DevTable", DevTable);
        
        getServletContext().getRequestDispatcher("/jsp001.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TS001.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TS001.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TS001.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TS001.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
