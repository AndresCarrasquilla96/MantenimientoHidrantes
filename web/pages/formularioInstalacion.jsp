
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Formulario Instalacion</title>
        <script src="../libs/jquery-3.4.1.min.js" type="text/javascript"></script>
    </head>

    <body>

        <div class="contenedor">

            <main>
                <form action="../FormularioInstalacion">
                    <table>

                        <thead> <th>Solicitud de Instalacion</th> </thead>

                        <tbody>
                            <tr>
                                <td>
                                    <label for="calle">Calle: </label>
                                </td>
                                <td>
                                    <input type="text" id="calle" placeholder="Calle" name="calle">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="avenida">Avenida: </label>
                                </td>
                                <td>
                                    <input type="text" id="avenida" placeholder="Av." name="avenida">
                                </td>
                            </tr>
                            <tr>
                                <td> <label for="numero_hidrante">No. Hidrante: </label> </td>
                                <td> <input type="text" id="numero_hidrante" placeholder="Numero hidrante" name="numero_hidrante"> </td>
                            </tr>
                            <tr>
                                <td> <label for="caudal_esperado">Caudal: </label> </td>
                                <td> <input type="text" id="caudal_esperado" placeholder="Caudal esperado" name="caudal_esperado"> </td>
                            </tr>
                            <tr>
                                <td> <label for="tamanio_salidas">Tamaño Salida: </label> </td>
                                <td> <input type="text" id="tamanio_salidas" placeholder="Tamaño salida" name="tamanio_salidas"> </td>
                            </tr>
                        </tbody>

                        <tfoot>
                            <tr> <td colspan="2"> <input type="submit" class="submit-btn" value="Enviar Solicitud"> </td> </tr>
                        </tfoot>

                    </table>
                </form>
            </main>

        </div>

        <script src="../js/scripts.js" type="text/javascript"></script>
    </body>
</html>