
var calleAncha = [10.016354, - 84.214249];

var map = L.map('map').setView(calleAncha, 16);

L.tileLayer('https://maps.heigit.org/openmapsurfer/tiles/roads/webmercator/{z}/{x}/{y}.png', {maxZoom: 20}).addTo(map);

var hidrante = L.icon({
    iconUrl: '../img/hidrante.png',
    iconSize:     [38, 40], // size of the icon
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
});

var popup = L.popup();

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
                    <tr> <td colspan="2"> <input type="submit" class="submit-btn" value="Solicitar Instalacion"/> </td> </tr>
                </table>
            </form>
        `)
        .openOn(map);
}

map.on('click', onMapClick);

(function actualizarMarcadores() {
    fetch('../Hidrantes')
            .then(response => response.json())
            .then(data => {
               for(let i = 0; i < data.length; ++i) {
                   let lat = data[i].latitud;
                   let lng = data[i].longitud;
                   L.marker({lat,lng}, {icon: hidrante}).addTo(map).bindPopup(`
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
                                    <td> <input type="text" id="caudal_esperado" name="caudal_esperado" value='${data[i].caudal_esperado}'> </td>
                                </tr>
                                <tr>
                                    <td> <label for="tamanio_salidas">Tamaño Salida: </label> </td>
                                    <td> <input type="text" id="tamanio_salidas" name="tamanio_salidas" value='${data[i].tamanio_salidas}'> </td>
                                </tr>
                                <tr> <td colspan="2"> <input type="submit" class="submit-btn" value="Solicitar Mantenimiento"/> </td> </tr>
                            </table>
                        </form>`);
        } 
    });
})();