package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IResponseMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.ResponseGeneric;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.ResponseId;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que mapea la informcion de respuiesta
 */
@Service
public class ResponseMapping implements IResponseMapping {

    /**
     * Crea y mapea el objeto ResponseGeneric
     * @param statusResponse codigo de respuesta
     * @param message mensaje de respuesta
     * @return informacion de respuesta
     */
    @Override
    public ResponseGeneric responseGenericMapping(Integer statusResponse, String message) {
        ResponseGeneric responseGeneric = new ResponseGeneric();
        responseGeneric.setStatusResponse(statusResponse);
        responseGeneric.setMessage(message);
        return responseGeneric;
    }

    /**
     * Crea y mapea el objeto ResponseId
     * @param statusResponse codigo de respuesta
     * @param message mensaje de respuesta
     * @param id id generado en el guardado del registro
     * @return informacion de respuesta
     */
    @Override
    public ResponseId responseIdMapping(Integer statusResponse, String message, Integer id) {
        ResponseId responseId = new ResponseId();
        responseId.setStatusResponse(statusResponse);
        responseId.setMessage(message);
        responseId.setId(id);
        return responseId;
    }
}
