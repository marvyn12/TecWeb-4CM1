// Cuando el documento cargue, pedimos la lista de mascotas
$(document).ready(function() {
    cargarMascotas();
});

// 1. LEER (GET) - Llena la tabla
function cargarMascotas() {
    $.ajax({
        url: '/api/mascotas',
        type: 'GET',
        success: function(mascotas) {
            let tbody = $('#tablaMascotas');
            tbody.empty(); // Limpiamos la tabla antes de llenarla

            mascotas.forEach(mascota => {
                let fila = `
                    <tr>
                        <td>${mascota.nombre}</td>
                        <td>${mascota.edad}</td>
                        <td>
                            <button class="btn btn-primary btn-sm" onclick="editarMascota(${mascota.id})">
                                <i class="fas fa-pencil-alt"></i>
                            </button>
                            <button class="btn btn-danger btn-sm" onclick="prepararEliminar(${mascota.id}, '${mascota.nombre}')">
                                <i class="fas fa-trash"></i>
                            </button>
                        </td>
                    </tr>
                `;
                tbody.append(fila);
            });
        },
        error: function(err) {
            console.error("Error al cargar mascotas", err);
        }
    });
}

// 2. ABRIR MODAL NUEVA (Limpia el formulario)
function abrirModalNueva() {
    $('#mascotaId').val(''); // Limpiamos ID oculto
    $('#formMascota')[0].reset(); // Limpiamos inputs
    $('#modalTitulo').text('Agregar Mascota');
    $('#btnGuardar').text('Agregar').removeClass('btn-primary').addClass('btn-success');

    $('#modalMascota').modal('show');
}

// 3. GUARDAR (POST O PUT) - Dependiendo si tiene ID o no
function guardarMascota() {
    let id = $('#mascotaId').val();

    // Armamos el JSON con los datos del form
    let mascotaData = {
        nombre: $('#nombre').val(),
        edad: $('#edad').val(),
        raza: $('#raza').val(),
        observaciones: $('#observaciones').val()
    };

    let tipoMetodo = id ? 'PUT' : 'POST';
    let urlEndpoint = id ? `/api/mascotas/${id}` : '/api/mascotas';

    $.ajax({
        url: urlEndpoint,
        type: tipoMetodo,
        contentType: 'application/json',
        data: JSON.stringify(mascotaData),
        success: function(response) {
            $('#modalMascota').modal('hide'); // Escondemos modal
            cargarMascotas(); // Recargamos tabla
        },
        error: function(err) {
            alert("Error al guardar la mascota");
            console.error(err);
        }
    });
}

// 4. PREPARAR EDICIÓN (GET por ID) - Carga los datos en el modal
function editarMascota(id) {
    $.ajax({
        url: `/api/mascotas/${id}`,
        type: 'GET',
        success: function(mascota) {
            // Llenamos el formulario con los datos que llegaron
            $('#mascotaId').val(mascota.id);
            $('#nombre').val(mascota.nombre);
            $('#edad').val(mascota.edad);
            $('#raza').val(mascota.raza);
            $('#observaciones').val(mascota.observaciones);

            // Cambiamos textos y colores
            $('#modalTitulo').text('Actualizar Mascota');
            $('#btnGuardar').text('Actualizar').removeClass('btn-success').addClass('btn-primary');

            $('#modalMascota').modal('show');
        },
        error: function(err) {
            console.error("Error al obtener mascota", err);
        }
    });
}

// 5. PREPARAR ELIMINACIÓN - Muestra el modal rojo
function prepararEliminar(id, nombre) {
    $('#deleteId').val(id);
    $('#textoEliminar').text(`¿Está seguro de eliminar la mascota ${nombre}?`);
    $('#modalEliminar').modal('show');
}

// 6. BORRAR (DELETE)
function borrarMascota() {
    let id = $('#deleteId').val();

    $.ajax({
        url: `/api/mascotas/${id}`,
        type: 'DELETE',
        success: function() {
            $('#modalEliminar').modal('hide');
            cargarMascotas(); // Recargamos la tabla
        },
        error: function(err) {
            console.error("Error al borrar mascota", err);
        }
    });
}