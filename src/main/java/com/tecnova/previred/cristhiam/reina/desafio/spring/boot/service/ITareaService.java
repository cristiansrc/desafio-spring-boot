package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Tarea;

import java.util.List;

/**
 * Interface que describe la funcionalidad de la logica de las tareas
 */
public interface ITareaService {

    /**
     * metodo encargado de traer todos las tareas
     * @return lista de objetos model
     */
    List<Tarea> obtenerTareas();

    /**
     * metodo encargado de traer una tarea por id
     * @param id id de la tarea a consultar
     * @return objeto model
     */
    Tarea obtenerTareaXId(Integer id);

    /**
     * metodo encargado de guardar el tarea
     * @param tarea objeto model que contiene la informacion del tarea
     * @return objeto model
     */
    Integer agregarTarea(Tarea tarea);

    /**
     * metodo encargado de actualizar la tarea
     * @param tarea objeto model que contiene la informacion del estado
     */
    void actualizarTarea(Tarea tarea);

    /**
     * metodo encargado de eliminar un estado
     * @param id id de estado a actualizar
     */
    void eliminarTarea(Integer id);
}
