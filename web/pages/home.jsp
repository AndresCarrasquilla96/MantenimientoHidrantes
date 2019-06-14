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
        <title>Hidrantes Calle Ancha - Alajuela</title>

        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
              integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
              crossorigin="" />
        <link href="../css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <button onclick="actualizarMarcadores()">botonAlv</button>
        
        <div class="contenedor">

            <div id="map">

            </div>

        </div>

        <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
            integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
            crossorigin=""></script>
        <script src="../js/scripts.js" type="text/javascript"></script>
        <script src="../libs/jquery-3.4.1.min.js" type="text/javascript"></script>
    </body>


</html>