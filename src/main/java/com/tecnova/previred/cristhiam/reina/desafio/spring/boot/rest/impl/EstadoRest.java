package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.rest.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IResponseMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.*;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.rest.EstadoApi;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.IEstadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que contiene la logica para manejar los contratos de la api de estados
 */
@RestController
@CrossOrigin(origins = "http://localhost")
@AllArgsConstructor
public class EstadoRest implements EstadoApi {

    private IEstadoService estadoService;
    private IResponseMapping responseMapping;

    /**
     * metodo encargado de manejar la entrada y salida del servicio de actualizacion de un estado
     * @param estado  (required) objeto model que contiene la informacion del estado
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseGeneric> actualizarEstado(Estado estado) {
        estadoService.actualizarEstado(estado);
        return ResponseEntity.ok(
                responseMapping.responseGenericMapping(
                        HttpStatus.OK.value(),
                        "Estado actualizado con exito!")
        );
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de guardar un estado
     * @param estado  (required) objeto model que contiene la informacion del estado
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseId> crearEstado(Estado estado) {
        return new ResponseEntity<>(
                responseMapping.responseIdMapping(
                        HttpStatus.CREATED.value(),
                        "El estado se ha guardado con exito!",
                        estadoService.crearEstado(estado)),HttpStatus.CREATED);
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de eliminar un estado
     * @param id  (required) id del registro a eliminar
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseGeneric> eliminarEstado(Integer id) {
        estadoService.eliminarEstado(id);
        return new ResponseEntity<>(
                responseMapping.responseGenericMapping(
                        HttpStatus.NO_CONTENT.value(),
                        "Estado eliminado con exito!"
                ),
                HttpStatus.NO_CONTENT);
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de consultar todos los estado
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseListEstado> obtenerEstado() {

        try {
            ResponseListEstado responseListEstado = new ResponseListEstado();
            responseListEstado.setEstados(estadoService.obtenerEstado());
            responseListEstado.setStatusResponse(HttpStatus.OK.value());
            responseListEstado.setMessage("Estados consultados con exito!");
            return ResponseEntity.ok(responseListEstado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de consultar un estado por su id
     * @param id  (required) id del estado a consultar
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseEstado> obtenerEstadoPorId(Integer id) {
        ResponseEstado responseEstado = new ResponseEstado();
        responseEstado.setEstado(estadoService.obtenerEstadoXId(id));
        responseEstado.setStatusResponse(HttpStatus.OK.value());
        responseEstado.setMessage("Estado consultado con exito!");
        return ResponseEntity.ok(responseEstado);
    }
}
