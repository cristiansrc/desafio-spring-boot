package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.rest.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IResponseMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.*;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.rest.TareaApi;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.ITareaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que contiene la logica para manejar los contratos de la api de tareas
 */
@RestController
@CrossOrigin(origins = "http://localhost")
@AllArgsConstructor
public class TareaRest implements TareaApi {

    private ITareaService tareaService;
    private IResponseMapping responseMapping;

    /**
     * metodo encargado de manejar la entrada y salida del servicio de actualizacion de una tarea
     * @param tarea  (required) objeto model que contiene la informacion del tarea
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseGeneric> actualizarTarea(Tarea tarea) {
        tareaService.actualizarTarea(tarea);
        return ResponseEntity.ok(
                responseMapping.responseGenericMapping(
                        HttpStatus.CREATED.value(),
                        "La tarea se ha guardado con exito!"
                )
        );
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de guardar un tarea
     * @param tarea  (required) objeto model que contiene la informacion del tarea
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseId> crearTarea(Tarea tarea) {
        return new ResponseEntity<>(
                responseMapping.responseIdMapping(
                        HttpStatus.CREATED.value(),
                        "La tarea se actualizo con exito",
                        tareaService.agregarTarea(tarea)),HttpStatus.CREATED);
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de eliminar una tarea
     * @param id  (required) id del registro a eliminar
     * @return retorna la informacion de respuesta del servicio
     */
    @Override
    public ResponseEntity<ResponseGeneric> eliminarTarea(Integer id) {
        tareaService.eliminarTarea(id);
        return new ResponseEntity<>(
                responseMapping.responseGenericMapping(
                        HttpStatus.NO_CONTENT.value(),
                        "Estado eliminado con exito!"
                ),
                HttpStatus.NO_CONTENT);
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de consultar una tarea por su id
     * @param id  (required) id del registro a eliminar
     * @return
     */
    @Override
    public ResponseEntity<ResponseTarea> obtenerTareaPorId(Integer id) {
        ResponseTarea tarea = new ResponseTarea();
        tarea.setStatusResponse(HttpStatus.OK.value());
        tarea.setMessage("Se consulto la tarea correctamente");
        tarea.setTarea(tareaService.obtenerTareaXId(id));
        return ResponseEntity.ok(tarea);
    }

    /**
     * metodo encargado de manejar la entrada y salida del servicio de consultar todos los estado
     * @return id del registro a eliminar
     */
    @Override
    public ResponseEntity<ResponseListTarea> obtenerTareas() {
        ResponseListTarea tarea = new ResponseListTarea();
        tarea.setStatusResponse(HttpStatus.OK.value());
        tarea.setMessage("Se consulto las tareas correctamente");
        tarea.setTareas(tareaService.obtenerTareas());
        return ResponseEntity.ok(tarea);
    }
}
