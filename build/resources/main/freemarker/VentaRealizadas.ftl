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
    <h1 style="text-align: center">Ventas Realizadas</h1>
    </br>
    <#list ventas as venta>
    <div class="row justify-content-md-center">
        <div class="col-12">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Fecha Realizado</th>
                </tr>
                    <tr>
                        <td>${venta.id}</td>
                        <td>${venta.fechaCompra}</td>


                    </tr>

            </table>

            <table class="table">
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Total</th>
                </tr>
                <#list productos as productosVenta>
                <tr>
                    <td>${productosVenta.nombre}</td>
                    <td>${productosVenta.precio}</td>
                    <td>${productosVenta.precio}</td>
                </tr>
                </#list>
            </table>

            <br/><br/>
        </div>
    </div>
    </#list>
</div>

</div>


</body>
</html>