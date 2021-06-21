package edu.pucmm.practica2.Controladora;

import edu.pucmm.practica2.encapsulaciones.Carrito;
import edu.pucmm.practica2.encapsulaciones.Producto;
import edu.pucmm.practica2.Controladora.ProductoControladora;
import edu.pucmm.practica2.encapsulaciones.Usuario;
import edu.pucmm.practica2.encapsulaciones.VentaProducto;
import edu.pucmm.practica2.servicios.VentaProductoService;
import edu.pucmm.practica2.util.BaseControlador;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
import edu.pucmm.practica2.servicios.ProductoService;
import edu.pucmm.practica2.servicios.CarritoService;
import io.javalin.http.NotFoundResponse;


import java.util.*;

public class CrudControladora  extends  BaseControlador{

    public CrudControladora(Javalin app){ super(app);}
    private ProductoService productoService = ProductoService.getInstance();
    private CarritoService carritoService = CarritoService.getInstance();
    private VentaProductoService ventaProductoService = VentaProductoService.getInstance();

    @Override
    public void aplicarRutas() {

        app.routes(() -> {
            path("/", () ->{

                get("/" , ctx -> {
                   ctx.redirect("/listar");
                });

                get("/listar", ctx -> {
                   List<Producto> productos = productoService.findAll();
                  // List<Producto> productosCarrito = carritoService.consultaProducto();
                    Map<String, Object> datos = new HashMap<>();
                    datos.put("productos", productos);
                    ctx.render("/freemarker/listaProducto.ftl", datos);
                });

                get("/adminProduct", ctx -> {
                    List<Producto> productos = productoService.findAll();
                    Map<String, Object> datos = new HashMap<>();
                    datos.put("productos", productos);
                    ctx.render("/freemarker/adminProducto.ftl", datos);
                });

                get("/registrarProducto" , ctx -> {
                    ctx.render("/freemarker/registrarProducto.ftl");
                });

                get("/eliminar/:index", ctx -> {
                    int index = ctx.pathParam("index", Integer.class).get();
                    productoService.eliminar(index);
                    ctx.redirect("/adminProduct");
                });

                get("/eliminar-carrito/:index", ctx -> {
                    int index = ctx.pathParam("index", Integer.class).get();
                    CarritoControladora.getInstance().getProductos().remove(index);
                    ctx.redirect("/carrito");
                });

                get("/actualizar/:index/" , ctx -> {
                    int index = ctx.pathParam("index", Integer.class).get();
                    Producto producto = productoService.findProduct(index);
                    Map<String,Object> attributes = new HashMap<>();
                    attributes.put("producto", producto);
                    attributes.put("index", index);
                    ctx.render("/freemarker/actualizarProducto.ftl", attributes);
                });

                get("/carrito", ctx -> {
                    Carrito cart = carritoService.find();
                    Set<Producto> productosCart = cart.getProductos();
                    List<Producto> productos = new ArrayList<>(productosCart);
                    Map<String, Object> datos = new HashMap<>();
                    datos.put("productos", productos);

                    ctx.render("/freemarker/Carrito.ftl", datos);
                });

                get("/agregar", ctx -> {
                    List<Producto> productos = productoService.findAll();
                    Set<Producto> productosCarrito = new HashSet<>(productos);
                    carritoService.crear(new Carrito(productosCarrito));
                    ctx.redirect("/listar");

                });

                post("/registrar", ctx -> {
                    String nombre = ctx.formParam("nombre");
                    Double precio = ctx.formParam("precio" , Double.class).get();

                    productoService.crear(new Producto(nombre, precio));
                   // Producto producto = new Producto(nombre, precio);
                  //  ProductoControladora.getInstance().getProductos().add(producto);
                    ctx.redirect("/adminProduct");
                });

                post("/actualizarProducto/:index/", ctx -> {
                    int index = ctx.pathParam("index", Integer.class).get();
                    String nombre = ctx.formParam("nombre");
                    Double precio = ctx.formParam("precio" , Double.class).get();

                    Producto producto = productoService.findProduct(index);

                    productoService.editar(new Producto(index,nombre,precio));
                    ctx.redirect("/adminProduct");
                });

                get("/compra", ctx -> {
                    Carrito cart = carritoService.find();
                    List<Producto> productos = productoService.findAll();
                    Set<Producto> productosVenta = new HashSet<>(productos);
                    Date fecha = new Date();
                   ventaProductoService.crear(new VentaProducto(fecha.toString(), productosVenta));
                    ctx.redirect("/ventas");

                });

                get("/ventas", ctx -> {
                    List<VentaProducto> ventas = ventaProductoService.findAll();
                    Carrito cart = carritoService.find();
                    Set<Producto> productosCart = cart.getProductos();
                    List<Producto> productos = new ArrayList<>(productosCart);
                    Map<String, Object> datos = new HashMap<>();
                    datos.put("ventas", ventas);
                    datos.put("cantidad", productos.size());
                    datos.put("productos", productos);
                    ctx.render("/freemarker/VentaRealizadas.ftl", datos);
                });


            });
        });
    }
}
