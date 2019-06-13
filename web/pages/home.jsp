<%-- 
    Document   : home
    Created on : Jun 11, 2019, 10:34:53 PM
    Author     : elmer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitudes</title>
    </head>
    <body>
        
        <div class="contenedor">
            <form>
                <table>
                    <tr>
                        <td>
                            <!--<input type="button" id='formularioInstalacion' value='Instalacion' onclick="solicitarInstalacion()">-->
                            <button> <a href="formularioInstalacion.jsp">Instalacion</a> </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" id='formularioMatenimiento' value='Mantenimiento' onclick="solicitarMantenimiento()">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        
    </body>
</html>
