package com.mycompany.homelan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TS002 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cоздаём Map и записываем туда параметры из request
        Map<String, String[]> paramMap = request.getParameterMap();
        
        // Создаём изменяймые строки для заиси параметров в нужном формате
        StringBuilder sbNum = new StringBuilder();
        StringBuilder sbStr = new StringBuilder();

        // Строки для передачи результатов в jsp
        String resultNum;
        String resultStr;
        
        // Пробегаемся по Map с параметрами
        for (Map.Entry<String, String[]> p: paramMap.entrySet()) {
            // Получаем ключ и значение текущего элемента
            String key = p.getKey();
            String[] values = p.getValue();
            
            // Разделяем числовые и строковые парамтры
            for (String sbsStr: values) {
                
                    sbNum.append("\n" + "<parameter name=\"" + key + "\">" + sbsStr + "</parameter>");
                
            }
        }
        
        // Получаем строки из билдера
        resultNum = sbNum.toString();
        resultStr = sbStr.toString();
        
        // Строим страницу
        response.setContentType("text/xml;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE xml>");
            out.println("<request_detail>");
            out.println("<client_info>");
            out.println("<ip-address>" + request.getRemoteAddr() + "</ip-address>");
            out.println("<user-agent>" + request.getHeader("User-agent") + "</user-agent>");
            out.println("</client_info>");
            out.println("<parameters method=\"" + request.getMethod() + "\">");
            out.println("<numeric_parameters>");
            out.println(resultNum);
            out.println("</numeric_parameters>");
            out.println("<string_parameters>");
            out.println(resultStr);
            out.println("</string_parameters>");
            out.println("</parameters>");
            out.println("</request_detail>");
            
        }
    }
    
    private boolean isNum (String st){
        
        // Данное условие не пропускает в numeric точку и запятую
        return st.matches("^([0-9]){1,10}$|^([0-9]){1,10}([.,])([0-9]){1,10}$");
        
        // Данное условие соответствует заданию
//        return st.matches("^([0-9]){0,10}([.,])([0-9]){0,10}$");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
