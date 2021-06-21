<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
    <title>Listado de Productos</title>
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
    <h1 style="text-align: center">Listado de Productos</h1>
    </br>
    <div class="row justify-content-md-center">
        <div class="col-12">
            <table class="table">
                <tr>
                    <th>Producto</th>
                    <th>Precio(RD$)</th>
                    <th>Cantidad</th>


                </tr>
                <#list productos as producto>
                    <tr>
                        <td>${producto.nombre}</td>
                        <td>${producto.precio}</td>
                        <td><input type="number" readonly value="1"></td>
                    </tr>
                </#list>
            </table>
            <a class="btn btn-dark btn-block mt-2" href="/agregar">Agregar todo al Carrito</a>
            <br/><br/>

        </div>
    </div>
</div>

</div>


</body>
</html>