package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.exception.ServiceException;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IEstadoMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Estado;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.IEstadoRepository;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.IEstadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que maneja la logica de estados
 */
@Service
@AllArgsConstructor
public class EstadoService implements IEstadoService {

    private IEstadoRepository estadoRepository;
    private IEstadoMapping estadoMapping;

    /**
     * metodo encargado de traer todos los estados
     * @return lista de objetos model
     */
    @Override
    public List<Estado> obtenerEstado() {
        return estadoMapping.listEstadoEntityToModel(estadoRepository.findAll());
    }

    /**
     * metodo encargado de traer el estado por su id
     * @param id id del estado a consultar
     * @return objeto model
     */
    @Override
    public Estado obtenerEstadoXId(Integer id) {
        return estadoMapping.estadoEntityToModel(
                estadoRepository.findById(id).orElseThrow(()-> new ServiceException(
                        "Id no encontrado",
                        HttpStatus.NOT_FOUND
                ))
        );
    }

    /**
     * metodo encargado de guardar un estado
     * @param estado objeto model que contiene la informacion del estado
     * @return objeto model
     */
    @Override
    public Integer crearEstado(Estado estado) {
        return estadoRepository.save(estadoMapping.modelToEstadoEntity(estado)).getId();
    }

    /**
     * metodo encargado de actualizar el estado
     * @param estado objeto model que contiene la informacion del estado
     */
    @Override
    public void actualizarEstado(Estado estado) {
        if(estado.getId() == null){ throw new ServiceException(
                "No esta presente el id del estado",
                HttpStatus.NOT_FOUND);}

        estadoRepository.findById(estado.getId()).ifPresentOrElse(
                estadoEntity -> {
                    estadoEntity.setNombre(estado.getNombre());
                    estadoRepository.save(estadoEntity);
                },
                () -> {
                    throw new ServiceException(
                            "id no encontrado en base de datos",
                            HttpStatus.NOT_FOUND);
                }
        );

    }

    /**
     * metodo encargado de eliminar un estado
     * @param id id de estado a eliminar
     */
    @Override
    public void eliminarEstado(Integer id) {
        if(id == null){ throw new ServiceException(
                "No esta presente el id del estado",
                HttpStatus.NOT_FOUND);}

        estadoRepository.findById(id).ifPresentOrElse(
                estadoEntity -> {
                    estadoRepository.deleteById(id);
                },
                () -> {
                    throw new ServiceException(
                            "id no encontrado en base de datos",
                            HttpStatus.NOT_FOUND);
                }
        );
    }
}
