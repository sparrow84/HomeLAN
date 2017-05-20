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
        
        <div class='second_table'>
            ${DevTable}
        
        </div>
    </body>
</html>
