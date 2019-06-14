
var calleAncha = [10.016354, - 84.214249];

var map = L.map('map').setView(calleAncha, 16);

L.tileLayer('https://maps.heigit.org/openmapsurfer/tiles/roads/webmercator/{z}/{x}/{y}.png', {maxZoom: 20}).addTo(map);

var hidrante = L.icon({
    iconUrl: 'D:\Escritorio\MantenimientoHidrantes\src\java\resources\hidrante.png',
    iconSize:     [38, 95], // size of the icon
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
});

var marker = L.marker(calleAncha, {icon: hidrante}).addTo(map);

//marker.bindPopup(`
//<form action="../FormularioInstalacion">
//    <table class="formulario_instalacion">
//        <thead> <th> Formulario Instalacion </th> </thead>
//        <tr>
//            <td> <label for="latitud_input">Latitud: </label> </td>
//            <td> <input type="text" id="latitud_input" autocomplete="off" class="latitud-input" name="latitud_input" placeholder='punto en x'/> </td>
//        </tr>
//        <tr>
//            <td> <label for="longitud_input">Longitud: </label> </td>
//            <td> <input type="text" id="longitud_input" autocomplete="off" class="longitud_input" name="longitud_input" placeholder='punto en y'/> </td>
//        </tr>
//        <tr>
//            <td> <label for="caudal_esperado">Caudal: </label> </td>
//            <td> <input type="text" id="caudal_esperado" autocomplete="off" name="caudal_esperado" placeholder="Caudal esperado"> </td>
//        </tr>
//        <tr>
//            <td> <label for="tamanio_salidas">Tamaño Salida: </label> </td>
//            <td> <input type="text" id="tamanio_salidas" autocomplete="off" name="tamanio_salidas" placeholder="Tamaño salida"> </td>
//        </tr>
//        <tr> <td colspan="2"> <input type="submit" class="submit-btn" value="Ingresar" /> </td> </tr>
//    </table>
//</form>
//`);

function crearObjeto() {
    hidrante = {
        latitud: $("#latitud_input").val(),
        longitud: $("#longitud_input").val(),
        caudal_esperado: $("#caudal_esperado").val(),
        tamanio_salidas: $("#tamanio_salidas").val()
    };
    console.log(hidrante);
}

var popup = L.popup();

//function onMapClick(e) {
//    popup
//        .setLatLng(e.latlng)
//        .setContent("You clicked the map at " + e.latlng.lat.toString())
//        .openOn(map);
//}

function onMapClick(e) {
    let lat = e.latlng.lat;
    let lng = e.latlng.lng;
    popup
        .setLatLng(e.latlng)
        .setContent(`
            <form action="../FormularioInstalacion">
                <table class="formulario_instalacion">
                    <thead> <th> Formulario Instalacion </th> </thead>
                    <tr>
                        <td> <input type="hidden" id="latitud_input" class="latitud-input" name="latitud_input" value='${lat}'/> </td>
                    </tr> 
                    <tr>
                        <td> <input type="hidden" id="longitud_input" class="longitud_input" name="longitud_input" value='${lng}'/> </td>
                     </tr>
                    <tr>
                        <td> <label for="caudal_esperado">Caudal: </label> </td>
                        <td> <input type="text" id="caudal_esperado" autocomplete="off" name="caudal_esperado" placeholder="Caudal esperado"> </td>
                    </tr>
                    <tr>
                        <td> <label for="tamanio_salidas">Tamaño Salida: </label> </td>
                        <td> <input type="text" id="tamanio_salidas" autocomplete="off" name="tamanio_salidas" placeholder="Tamaño salida"> </td>
                    </tr>
                    <tr> <td colspan="2"> <input type="submit" class="submit-btn" value="Ingresar"/> </td> </tr>
                </table>
            </form>
        `)
        .openOn(map);
}

map.on('click', onMapClick);