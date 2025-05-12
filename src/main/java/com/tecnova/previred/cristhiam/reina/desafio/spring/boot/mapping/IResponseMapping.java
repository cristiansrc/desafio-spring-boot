package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.ResponseGeneric;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.ResponseId;

/**
 * Interface que describe la funcionalidad de mappeo de los Responsive
 */
public interface IResponseMapping {

    /**
     * Crea y mapea el objeto ResponseGeneric
     * @param statusResponse codigo de respuesta
     * @param message mensaje de respuesta
     * @return informacion de respuesta
     */
    ResponseGeneric responseGenericMapping(Integer statusResponse, String message);

    /**
     * Crea y mapea el objeto ResponseId
     * @param statusResponse codigo de respuesta
     * @param message mensaje de respuesta
     * @param id id generado en el guardado del registro
     * @return informacion de respuesta
     */
    ResponseId responseIdMapping(Integer statusResponse, String message, Integer id);
}
