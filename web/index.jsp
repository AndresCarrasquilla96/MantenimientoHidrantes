<%-- 
    Document   : index
    Created on : Jun 11, 2019, 10:09:34 PM
    Author     : elmer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="libs/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="scripts/authentication.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <div class="contents">
                <form action="LoginServlet">
                    <div>
                        <label>Usuario: </label>
                        <input type="text" autocomplete="off" class="username-input" name="username"/>
                    </div>
                    <div>
                        <label>Contraseña: </label>
                        <input type="password" autocomplete="off" class="password-input" name="password"/>
                    </div>
                    <input type="submit" value="Ingresar" />
                </form>
            </div>
        </div>
    </body>
</html>
