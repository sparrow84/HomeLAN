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
        <script src="js/jscript.js"></script>
    </head>
    <body>
        <script src="js/jscript.js"></script>
        <h1>Table viewer.</h1>
        
        <div class="first_table">
            ${DevTable}
        </div>
        
        <div class='buttons'>
            <button>Кнопка 1</button></br>
            <button>Кнопка 2</button></br>
            <button>Кнопка 3</button></br>
            <button>Кнопка 4</button></br>
            <button>Кнопка 5</button>
        </div>
        
        <div class="gafica1">
            
            <input type="text" value="Введи значение" onFocus="window.status='Введи чёнить'">
			
            <fieldset>
		<legend>Что вам болше нравится?</legend>
		<input type="radio" checked=1 name=1 value="Мороженное" onFocus="window.status='Вы выбрали мороженное'">Мороженное
                <input type="radio" name=1 value="Шоколад" onFocus="window.status='Вы выбрали шоколад'">Шоколад</input>
            </fieldset>
            
            <form>
		<input type="submit" value="Submit data" onClick="alert('Super JavaScript')">
                <input TYPE="button" VALUE="Чё то надо написать тут" onClick="window.name='My name chaged! =)'">
            </form>
            
            
        </div>
        
        <div id="columns" class="columns">
            <div class="column" draggable="true"><header>A</header></div>
            <div class="column" draggable="true"><header>B</header></div>
            <div class="column" draggable="true"><header>C</header></div>
        </div>
        
    </body>
</html>
