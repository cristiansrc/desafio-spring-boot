package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.AuthUsuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.LoginUsuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Tarea;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Usuario;

import java.util.List;

/**
 * Interface que describe la funcionalidad de la logica de los usuario
 */
public interface IUsuarioService {

    /**
     * metodo encargado de traer todos los usuario
     * @return lista de objetos model
     */
    List<Usuario> obtenerUsuarios();

    /**
     * metodo encargado de traer el usuario por su id
     * @param id id del estado a consultar
     * @return objeto model
     */
    Usuario obtenerUsuario(Integer id);

    /**
     * metodo encargado de traer el usuario por correo y usuario
     * @param loginUsuario objeto que contiene los datos de inicio de session
     * @return objeto model
     */
    AuthUsuario loginUsuario(LoginUsuario loginUsuario);

    /**
     * metodo encargado de actualizar el usuario
     * @param usuario objeto model que contiene la informacion del usuario
     * @return objeto model
     */
    Integer agregarUsuario(Usuario usuario);

    /**
     * metodo encargado de actualizar el estado
     * @param usuario objeto model que contiene la informacion del usuario
     */
    void actualizarUsuario(Usuario usuario);

    /**
     * metodo encargado de eliminar un usuario
     * @param id id de usuario a eliminar
     */
    void eliminarUsuario(Integer id);

}
