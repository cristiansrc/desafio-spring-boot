package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.ITareaMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Tarea;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.EstadoEntity;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.TareaEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que mapea la informacion de tareas
 */
@Service
public class TareaMapping implements ITareaMapping {

    /**
     * mapea la informacion la clase entity a la clase model
     * @param tareaEntity objeto de base de datos
     * @return objeto model
     */
    @Override
    public Tarea tareaEntityToModel(TareaEntity tareaEntity) {
        Tarea tarea = new Tarea();
        tarea.setId(tareaEntity.getId());
        tarea.setNombre(tareaEntity.getNombre());
        tarea.setIdEstado(tareaEntity.getEstado().getId());
        tarea.setNombreEstado(tareaEntity.getEstado().getNombre());
        return tarea;
    }

    /**
     * mapea la informacion de una lista de estado entity a lista de model
     * @param entities lista de objetos de entity
     * @return lista de objetos model
     */
    @Override
    public List<Tarea> listTareaEntityToModel(List<TareaEntity> entities) {
        List<Tarea> tareas = new ArrayList<>();
        entities.forEach(entity -> tareas.add(tareaEntityToModel(entity)));
        return tareas;
    }

    /**
     * Mapea la informacion de model a entity
     * @param tarea objeto model
     * @return objeto entity
     */
    @Override
    public TareaEntity modelToTareaEntity(Tarea tarea) {
        TareaEntity tareaEntity = new TareaEntity();
        EstadoEntity estadoEntity = new EstadoEntity();
        estadoEntity.setId(tarea.getIdEstado());

        tareaEntity.setId(tarea.getId());
        tareaEntity.setNombre(tarea.getNombre());
        tareaEntity.setEstado(estadoEntity);

        return tareaEntity;
    }
}
