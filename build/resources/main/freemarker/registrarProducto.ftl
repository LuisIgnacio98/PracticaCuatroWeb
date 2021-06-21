<!DOCTYPE html>
<html>
<head>
    <title>Registrar Producto</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
</head>
<body style="background-color: white">
<div class="navbar navbar-dark bg-dark " style="color: white">
    <a class="navbar-brand" href="/" style="cursor: pointer">Listado</a>
    <div class="d-flex">
        <a class="btn btn-dark" href="/ventas">Ventas Realizadas</a>
        <a class="btn btn-dark" href="/adminProduct">Administrar Productos</a>
        <a class="btn btn-dark" href="/carrito">Carrito</a>
    </div>
</div>
<h1 style="text-align: center;">Ingrese los datos del Producto: </h1>
</br>
<div class="container mt-2">
    <div class="row justify-content-md-center">
        <div class="col-6">
            <div class="card" style="padding: 20px; background-color: lightgray">
                <form action="/registrar" method="post"  enctype="application/x-www-form-urlencoded">

                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre">
                    </div>

                    <div class="form-group">
                        <label for="precio">Precio:</label>
                        <input type="text" class="form-control" id="precio" name="precio">
                    </div>

                    <button type="submit" class="btn btn-primary">Registrar</button>
                    <button onclick="location.href = '/adminProduct';" type="button" class="btn btn-primary">Inicio</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>