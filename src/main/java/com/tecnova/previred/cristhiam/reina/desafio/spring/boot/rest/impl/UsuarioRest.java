package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.rest.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.exception.ServiceException;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IResponseMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.*;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.rest.UsuarioApi;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que contiene la logica para manejar los contratos de la api de usuario
 */
@RestController
@CrossOrigin(origins = "http://localhost")
@AllArgsConstructor
public class UsuarioRest implements UsuarioApi {

    private IUsuarioService usuarioService;
    private IResponseMapping responseMapping;

    /**
     * metodo encargado de manejar la entrada y salida del servicio de actualizacion de un usuario
     * @param usuario  (required) objeto model que contiene la informacion del usuario
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseGeneric> actualizarUsuario(Usuario usuario) {
        try {
            usuarioService.actualizarUsuario(usuario);
            return ResponseEntity.ok(
                    responseMapping.responseGenericMapping(
                            HttpStatus.CREATED.value(),
                            "La tarea se ha guardado con exito!"
                    )
            );
        } catch (ServiceException e) {
            return new ResponseEntity<>(
                    responseMapping.responseGenericMapping(
                            e.getHttpStatus().value(),
                            e.getMessage()
                    ),
                    e.getHttpStatus()
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    responseMapping.responseGenericMapping(
                            HttpStatus.CONFLICT.value(),
                            "El no se pudo almacenar el usuario"
                    ),
                    HttpStatus.CONFLICT
            );
        }

    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de guardar un usuario
     * @param usuario  (required) objeto model que contiene la informacion del usuario
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseId> crearUsuario(Usuario usuario) {
        try {
            return new ResponseEntity<>(
                    responseMapping.responseIdMapping(
                            HttpStatus.CREATED.value(),
                            "El usuario se creo con exito!",
                            usuarioService.agregarUsuario(usuario)),HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    responseMapping.responseIdMapping(
                            HttpStatus.CONFLICT.value(),
                            "El usuario no se pudo almacenar",
                            null
                    ),
                    HttpStatus.CONFLICT
            );
        }

    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de eliminar un usuario
     * @param id  (required) id del registro a eliminar
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseGeneric> eliminarUsuario(Integer id) {
        try {
            usuarioService.eliminarUsuario(id);
            return new ResponseEntity<>(
                    responseMapping.responseGenericMapping(
                            HttpStatus.NO_CONTENT.value(),
                            "Uusario eliminado con exito!"
                    ),
                    HttpStatus.NO_CONTENT);
        } catch (ServiceException e) {
            return new ResponseEntity<>(
                    responseMapping.responseGenericMapping(
                            e.getHttpStatus().value(),
                            e.getMessage()
                    ),
                    e.getHttpStatus());
        } catch (Exception e) {
            return new ResponseEntity<>(
                    responseMapping.responseGenericMapping(
                            HttpStatus.CONFLICT.value(),
                            "El usuario no se pudo almacenar"
                    ),
                    HttpStatus.CONFLICT
            );
        }

    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de login de usuario
     * @param loginUsuario  (required) objeto con el correo y la contraseña del usuario
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseAuthUsuario> loginUsuario(LoginUsuario loginUsuario) {
        try {
            ResponseAuthUsuario responseAuthUsuario = new ResponseAuthUsuario();
            responseAuthUsuario.setAuthUsuario(usuarioService.loginUsuario(loginUsuario));
            responseAuthUsuario.setStatusResponse(HttpStatus.OK.value());
            responseAuthUsuario.setMessage("El usuario inicio session con exito");
            return ResponseEntity.ok(responseAuthUsuario);
        } catch (ServiceException e) {
            ResponseAuthUsuario responseAuthUsuario = new ResponseAuthUsuario();
            responseAuthUsuario.setAuthUsuario(null);
            responseAuthUsuario.setStatusResponse(e.getHttpStatus().value());
            responseAuthUsuario.setMessage("Las credeciales del usuario son incorrectas");
            return new ResponseEntity<>(responseAuthUsuario, e.getHttpStatus());
        } catch (Exception e) {
            ResponseAuthUsuario responseAuthUsuario = new ResponseAuthUsuario();
            responseAuthUsuario.setAuthUsuario(null);
            responseAuthUsuario.setStatusResponse(HttpStatus.CONFLICT.value());
            responseAuthUsuario.setMessage("No se pudo inicar session por un error");
            return new ResponseEntity<>(responseAuthUsuario,HttpStatus.CONFLICT);
        }
    }

    /**
     * encargado de manejar la entrada y salida del servicio de consultar un usuario por su id
     * @param id  (required)
     * @return
     */
    @Override
    public ResponseEntity<ResponseUsuario> obtenerUsuarioPorId(Integer id) {
        try {
            ResponseUsuario responseUsuario = new ResponseUsuario();
            responseUsuario.setUsuario(usuarioService.obtenerUsuario(id));
            responseUsuario.setStatusResponse(HttpStatus.OK.value());
            responseUsuario.setMessage("El usuario se consulto con exito con exito");
            return ResponseEntity.ok(responseUsuario);
        } catch (Exception e) {
            ResponseUsuario responseUsuario = new ResponseUsuario();
            responseUsuario.setUsuario(null);
            responseUsuario.setStatusResponse(HttpStatus.CONFLICT.value());
            responseUsuario.setMessage("El usuario no se pudo consultar");
            return new ResponseEntity<>(
                    responseUsuario,
                    HttpStatus.CONFLICT
            );
        }
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de consultar todos los usuario
     * @return
     */
    @Override
    public ResponseEntity<ResponseListUsuarios> obtenerUsuarios() {
        try {
            ResponseListUsuarios responseListUsuarios = new ResponseListUsuarios();
            responseListUsuarios.setTareas(usuarioService.obtenerUsuarios());
            responseListUsuarios.setStatusResponse(HttpStatus.OK.value());
            responseListUsuarios.setMessage("Los usuarios se consulto con exito");
            return ResponseEntity.ok(responseListUsuarios);
        } catch (Exception e) {
            ResponseListUsuarios responseListUsuarios = new ResponseListUsuarios();
            responseListUsuarios.setTareas(null);
            responseListUsuarios.setStatusResponse(HttpStatus.CONFLICT.value());
            return new ResponseEntity<>(
                    responseListUsuarios,
                    HttpStatus.CONFLICT
            );
        }
    }
}
