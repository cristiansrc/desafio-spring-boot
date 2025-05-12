package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.exception.ServiceException;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.ITareaMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Tarea;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.IEstadoRepository;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.ITareaRepository;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.ITareaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase encargada de tener la logica de usuarios
 */
@Service
@AllArgsConstructor
public class TareaService implements ITareaService {

    private ITareaRepository tareaRepository;
    private IEstadoRepository estadoRepository;
    private ITareaMapping tareaMapping;

    /**
     * metodo encargado de traer todos los tareas
     * @return lista de objetos model
     */
    @Override
    public List<Tarea> obtenerTareas() {
        return tareaMapping.listTareaEntityToModel(tareaRepository.findAll());
    }

    /**
     * metodo encargado de traer el tarea por su id
     * @param id id de la tarea a consultar
     * @return objeto model
     */
    @Override
    public Tarea obtenerTareaXId(Integer id) {
        return tareaMapping.tareaEntityToModel(tareaRepository.getReferenceById(id));
    }

    /**
     * metodo encargado de actualizar el usuario
     * @param tarea objeto model que contiene la informacion de la tarea
     * @return objeto model
     */
    @Override
    public Integer agregarTarea(Tarea tarea) {
        return tareaRepository.save(tareaMapping.modelToTareaEntity(tarea)).getId();
    }

    /**
     * metodo encargado de actualizar el estado
     * @param tarea objeto model que contiene la informacion de la tarea
     */
    @Override
    public void actualizarTarea(Tarea tarea) {
        if(tarea.getId() == null){ throw new ServiceException(
                "No esta presente el id de la tarea",
                HttpStatus.NOT_FOUND);}

        tareaRepository.findById(tarea.getId()).ifPresentOrElse(
                tareaEntity -> estadoRepository.findById(tareaEntity.getId()).ifPresentOrElse(
                    estadoEntity -> {
                        tareaEntity.setNombre(tarea.getNombre());
                        tareaEntity.setEstado(estadoEntity);
                        tareaRepository.save(tareaEntity);
                    },
                    () -> {
                        throw new ServiceException(
                                "id del estado no encontrado",
                                HttpStatus.NOT_FOUND);
                    }
                ),
                () -> {
                    throw new ServiceException(
                            "id de la tarea no encontrada",
                            HttpStatus.NOT_FOUND);
                }
        );
    }

    /**
     * metodo encargado de eliminar una tarea
     * @param id id de la tarea a eliminar
     */
    @Override
    public void eliminarTarea(Integer id) {
        tareaRepository.findById(id).ifPresentOrElse(
                tareaEntity -> tareaRepository.deleteById(tareaEntity.getId()),
                () -> {
                    throw new ServiceException(
                            "id de la tarea no encontrada",
                            HttpStatus.NOT_FOUND);
                }
        );

    }
}
