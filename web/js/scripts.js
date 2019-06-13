
function ingresarHidrante() {
    hidrante = {
        calle: $("#calle").val(),
        avenida: $("#avenida").val(),
        numero_hidrante: $("#numero_hidrante").val(),
        caudal_esperado: $("#caudal_esperado").val(),
        tamanio_salidas: $("#tamanio_salidas").val()
    };
    
    $.ajax({
        type: "POST",
        url: "api/hidrantes/add",
        data: JSON.stringify(hidrante),
        contentType: "application/json",
        success: function(mensaje) {
            console.log(mensaje);
        }
    });
}