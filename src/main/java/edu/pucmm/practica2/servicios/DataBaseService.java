package edu.pucmm.practica2.servicios;

import org.h2.tools.Server;
import java.sql.SQLException;

public class DataBaseService {
 private static DataBaseService instance;

 private DataBaseService() {

 }

 public static DataBaseService getInstance(){
     if(instance == null){
         instance = new DataBaseService();
     }
     return instance;
 }

 public void startDB() {
     try {
         Server.createTcpServer("-tcpPort",
                 "9092",
                 "-tcpAllowOthers",
                 "-tcpDaemon"
                 ).start();

         String status = Server.createWebServer("-trace", "-webPort", "0").start().getStatus();
         System.out.println("Status Web: " + status);

     }catch (SQLException ex){
         System.out.println("Error Base de Datos: " + ex.getMessage());
     }
 }

 public void init(){startDB();};
}
