<%-- 
    Document   : jsp001
    Created on : May 20, 2017, 9:45:10 AM
    Author     : vva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            @import url("css/style.css");
            
        </style>
    </head>
    <body>
        <h1>Table viewer.</h1>
        
        <div class='first_table'>
            ${DevTable}
        </div>
        
        <div class='buttons'>
            <button>Кнопка 1</button></br>
            <button>Кнопка 2</button></br>
            <button>Кнопка 3</button></br>
            <button>Кнопка 4</button></br>
            <button>Кнопка 5</button>
        </div>
        
        <div class='gafica1'>
            
            <canvas height="100" width="100">
                
                
                
            </canvas>
            
        </div>
        
    </body>
</html>
