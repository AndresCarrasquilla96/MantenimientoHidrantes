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
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="libs/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="scripts/authentication.js" type="text/javascript"></script>
    </head>

    <body>
        <div id="wrapper" class="contenedor">
            <form action="LoginServlet">
                <table class="login-table">
                    <tr>
                        <td> <label for="username-input">Usuario: </label> </td>
                        <td> <input type="text" id="username-input" autocomplete="off" class="username-input" name="username"/> </td>
                    </tr>
                    <tr>
                        <td> <label for="password-input">Contraseña: </label> </td>
                        <td> <input type="password" id="password-input" autocomplete="off" class="password-input" name="password"/> </td>
                    </tr>
                    <tr> <td colspan="2"> <input type="submit" class="submit-btn" value="Ingresar" /> </td> </tr>
                </table>
            </form>

        </div>
    </body>

</html>
