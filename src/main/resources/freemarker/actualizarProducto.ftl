<!DOCTYPE html>
<html>
<head>
    <title>Actualizar Porducto</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
</head>
<body style="background-color: white">
<div class="navbar navbar-dark bg-dark " style="color: white">
    <a class="navbar-brand" href="/" style="cursor: pointer">Luis Mateo</a>
    <div class="d-flex">
        <a class="btn btn-dark" href="/ventas">Ventas Realizadas</a>
        <a class="btn btn-dark" href="/adminProduct">Administrar Productos</a>
        <a class="btn btn-dark" href="/carrito">Carrito</a>
    </div>
</div>
<h1 style="text-align: center;">Ingrese los datos del Producto: </h1>
</br>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-6">
            <div class="card" style="padding: 20px; background-color: lightgray">
                <form action="/actualizarProducto/${index}/" method="post"  enctype="application/x-www-form-urlencoded">

                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" class="form-control" id="id" name="id" value="${producto.id}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="${producto.nombre}">
                    </div>

                    <div class="form-group">
                        <label for="precio">Precio:</label>
                        <input type="text" class="form-control" id="precio" name="precio" value="${producto.precio}">
                    </div>

                    <button type="submit" class="btn btn-primary">Actualizar</button>
                    <button onclick="location.href = '/adminProduct';" type="button" class="btn btn-primary">Inicio</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>