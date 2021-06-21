package edu.pucmm.practica2.Controladora;

import edu.pucmm.practica2.encapsulaciones.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UsuarioControladora {
    private static UsuarioControladora instance;
    private List<Usuario> listaUsuarios = new ArrayList<>();

    private UsuarioControladora(){
        listaUsuarios.add(new Usuario("admin", "admin", "admin"));

    }

    public static UsuarioControladora getInstance(){
        if (instance == null){
            instance = new UsuarioControladora();
        }
        return instance;
    }

    public Usuario autheticarUsuario(String usuario, String password){
        //simulando la busqueda en la base de datos.
        return new Usuario(usuario, "Usuario "+usuario, password);
    }

    public List<Usuario> getListaUsuarios(){
        return listaUsuarios;
    }

}
