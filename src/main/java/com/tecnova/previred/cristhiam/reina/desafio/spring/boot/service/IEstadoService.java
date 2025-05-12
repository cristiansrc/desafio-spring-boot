package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Estado;

import java.util.List;

/**
 * Interface que describe la funcionalidad de la logica de los estados
 */
public interface IEstadoService {

    /**
     * metodo encargado de traer todos los estados
     * @return lista de objetos model
     */
    List<Estado> obtenerEstado();

    /**
     * metodo encargado de traer el estado por su id
     * @param id id del estado a consultar
     * @return objeto model
     */
    Estado obtenerEstadoXId(Integer id);

    /**
     * metodo encargado de guardar el estado
     * @param estado objeto model que contiene la informacion del estado
     * @return objeto model
     */
    Integer crearEstado(Estado estado);

    /**
     * metodo encargado de actualizar el estado
     * @param estado objeto model que contiene la informacion del estado
     */
    void actualizarEstado(Estado estado);

    /**
     * metodo encargado de eliminar un estado
     * @param id id de estado a eliminar
     */
    void eliminarEstado(Integer id);

}
