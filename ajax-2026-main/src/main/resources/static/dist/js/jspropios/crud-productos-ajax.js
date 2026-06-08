//CRUD DE UNA SOLA PAGINA USANDO AJAX CON JQUERY
//SIN OLVIDARNOS QUE CON FETCH PODEMOS USAR AJAX DE MANERA NATIVA

//Metodos para el CRUD
function listar() {
    $.ajax({
        method: "GET",
        url: "/productos/api/productos",
        data: {},
        success: function (productos) {
            // ✅ CORRECCIÓN: Usar DataTable() en lugar de new DataTable()
            let tabla = $('#example1').DataTable();

            // Limpiamos la tabla por si se llama varias veces
            tabla.clear().draw();

            productos.forEach(producto => {
                let botones = '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-update" onclick="identificaActualizar(' + producto.id + ')"> Editar </button>';
                botones = botones + ' <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-delete" onclick="identificaEliminar(' + producto.id + ')">Eliminar</button>';

                let rowNode = tabla.row
                    .add([producto.id, producto.nombre, '$ ' + producto.precio, producto.stock, botones])
                    .draw()
                    .node();
                rowNode.id = 'renglon_' + producto.id;
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Error al listar productos:", textStatus, errorThrown);
            alert("Error al cargar productos");
        }
    });
}

function guardar() {
    //Validación básica
    let nombreProducto = document.getElementById('nombre').value.trim();
    let precioProducto = document.getElementById("precio").value;
    let stockProducto = document.getElementById("stock").value;
    let categoriaProducto = document.getElementById("categoria").value;

    if (!nombreProducto || !precioProducto || !stockProducto || !categoriaProducto) {
        alert("Por favor completa todos los campos");
        return;
    }

    //Solicitud de guardar un producto usando AJAX
    $.ajax({
        method: 'POST',
        url: "/productos/api/productos",
        contentType: "application/json",
        //Body - RequestBody
        data: JSON.stringify({
            nombre: nombreProducto,
            precio: precioProducto,
            stock: stockProducto,
            categoria: categoriaProducto
        }),
        success: function (producto) {
            //Es la respuesta del servidor
            //Agregar el producto a la tabla
            let botones = '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-update" onclick="identificaActualizar(' + producto.id + ')"> Editar </button>';
            botones = botones + ' <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-delete" onclick="identificaEliminar(' + producto.id + ')">Eliminar</button>';

            let tabla = $('#example1').DataTable();
            var rowNode = tabla.row
                .add([producto.id, producto.nombre, '$ ' + producto.precio, producto.stock, botones])
                .draw()
                .node();
            rowNode.id = 'renglon_' + producto.id;

            alert("Producto Guardado Correctamente");
            limpiarFormulario();
            //Cerrar la ventana modal
            $('#modal-lg').modal('hide');
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Error al guardar:", textStatus, errorThrown);
            alert("Error al guardar el producto");
        }
    });
}

function limpiarFormulario() {
    document.getElementById('nombre').value = "";
    document.getElementById('precio').value = "";
    document.getElementById('stock').value = "";
    document.getElementById('categoria').value = "";
    document.getElementById('nombre').focus();
}

//Dos metodos para actualizar un productos
function identificaActualizar(id) {
    //Mostrar de manera asincrona el producto actualizar
    $.ajax({
        method: 'GET',
        url: "/productos/api/productos/" + id,
        data: {},
        success: function(producto) {
            //Mostralo en el modal de Actualizar
            document.getElementById('id-update').value = producto.id;
            document.getElementById('nombre-update').value = producto.nombre;
            document.getElementById('precio-update').value = producto.precio;
            document.getElementById('stock-update').value = producto.stock;
            document.getElementById('categoria-update').value = producto.categoria;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Error al obtener producto:", textStatus, errorThrown);
            alert("Error al cargar el producto");
        }
    });
}

function actualizar() {
    //Actualiza el producto identificado
    let idProducto = document.getElementById('id-update').value;
    let nombreProducto = document.getElementById('nombre-update').value.trim();
    let precioProducto = document.getElementById('precio-update').value;
    let stockProducto = document.getElementById('stock-update').value;
    let categoriaProducto = document.getElementById('categoria-update').value;

    if (!nombreProducto || !precioProducto || !stockProducto || !categoriaProducto) {
        alert("Por favor completa todos los campos");
        return;
    }

    $.ajax({
        method: 'PATCH',
        contentType: 'application/json',
        url: "/productos/api/productos/" + idProducto,
        data: JSON.stringify({
            nombre: nombreProducto,
            precio: precioProducto,
            stock: stockProducto,
            categoria: categoriaProducto
        }),
        success: function(producto) {
            //Editar el renglon de la tabla
            let tabla = $('#example1').DataTable();
            var datos = tabla.row("#renglon_" + idProducto).data();
            datos[1] = nombreProducto;
            datos[2] = '$ ' + precioProducto;
            datos[3] = stockProducto;
            tabla.row("#renglon_" + idProducto).data(datos);
            tabla.draw();
            alert('Producto actualizado');
            $('#modal-update').modal('hide');
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Error al actualizar:", textStatus, errorThrown);
            alert("Error al actualizar el producto");
        }
    });
}

//Dos metodos para eliminar
function identificaEliminar(id) {
    //Recuperar los datos del producto del servidor usando AJAX
    $.ajax({
        method: 'GET',
        url: "/productos/api/productos/" + id,
        data: {},
        success: function(producto) {
            //Mostrar en el modal los datos del producto
            document.getElementById('id-eliminar').value = producto.id;
            document.getElementById('nombre-delete').value = producto.nombre;
            document.getElementById('precio-delete').value = producto.precio;
            document.getElementById('stock-delete').value = producto.stock;
            document.getElementById('categoria-delete').value = producto.categoria;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Error al obtener producto:", textStatus, errorThrown);
            alert("Error al cargar el producto para eliminar");
        }
    });
}

function eliminar() {
    //Elimina de manera asincrona con ajax usando jQuery
    const idEliminar = document.getElementById('id-eliminar').value;

    if (!idEliminar || idEliminar === "0") {
        alert("Error: No hay producto seleccionado");
        return;
    }

    $.ajax({
        method: 'DELETE',
        url: "/productos/api/productos/" + idEliminar,
        data: {},
        success: function(producto) {
            alert('Producto Eliminado');
            //Eliminar de la tabla el producto
            let tabla = $('#example1').DataTable();

            tabla.row('#renglon_' + idEliminar)
                .remove()
                .draw();

            $('#modal-delete').modal('hide');
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Error al eliminar:", textStatus, errorThrown);
            alert("Error al eliminar el producto");
        }
    });
}

function cargarCategorias() {
    $.ajax({
        url: '/categorias/api/categorias',
        type: 'GET',
        success: function(categorias) {
            // Limpiamos los selects y les ponemos una opción por defecto
            let opciones = '<option value="">Seleccione una categoría...</option>';

            // Recorremos lo que nos regresó la base de datos
            categorias.forEach(function(cat) {
                opciones += `<option value="${cat.id}">${cat.nombre}</option>`;
            });

            // Inyectamos las opciones en los 3 selects de tus modales
            $('#categoria').html(opciones);
            $('#categoria-update').html(opciones);
            $('#categoria-delete').html(opciones);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Error al cargar categorías:", jqXHR.status, textStatus);
        }
    });
}
