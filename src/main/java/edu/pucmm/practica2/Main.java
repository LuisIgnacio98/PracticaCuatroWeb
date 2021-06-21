package edu.pucmm.practica2;

import edu.pucmm.practica2.Controladora.CrudControladora;
import edu.pucmm.practica2.servicios.DataBaseService;
import io.javalin.Javalin;



public class Main {

    private static String modoConexion = "";

    public static void main(String[] args) {
        String mensaje = "Carrito de compra ORM - JPA";
        System.out.println(mensaje);

        if(args.length >= 1){
            modoConexion = args[0];
            System.out.println("Modo de Operacion: "+modoConexion);
        }

        if(modoConexion.isEmpty()){
            DataBaseService.getInstance().init();
        }


        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/publico");
            config.enableCorsForAllOrigins();
        });

        app.start(8080);

        new CrudControladora(app).aplicarRutas();
    }
}
