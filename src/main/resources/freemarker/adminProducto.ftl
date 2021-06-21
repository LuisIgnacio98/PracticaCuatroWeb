<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
    <title>Administrar Productos</title>
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

<div class="container mt-5" >
    <h1 style="text-align: center">CRUD Productos</h1>
    </br>
    <form action="/registrarProducto">
        <button type="submit" class="btn btn-dark mb-3">Crear Producto</button>
    </form>
    <div class="row justify-content-md-center">
        <div class="col-12">
            <table class="table">
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
                <#list productos as producto>
                    <tr>
                        <td>${producto.nombre}</td>
                        <td>${producto.precio}</td>
                        <td>
                            <a class="btn btn-warning"  href="/actualizar/${producto?index}/">Editar</a>
                            <a class="btn btn-danger" href="/eliminar/${producto?index}/">Eliminar</a>
                        </td>
                    </tr>
                </#list>
            </table>
            <br/><br/>

        </div>
    </div>
</div>

</div>


</body>
</html>