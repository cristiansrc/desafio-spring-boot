package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Usuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.UsuarioEntity;

import java.util.List;

/**
 * Inteface que describe el la funcionalidad del mappeo de usuarios
 */
public interface IUsuarioMapping {
    /**
     * mapea la informacion la clase entity a la clase model
     * @param usuarioEntity objeto de base de datos
     * @return objeto model
     */
    Usuario usuarioEntityToModel(UsuarioEntity usuarioEntity);

    /**
     * mapea la informacion de una lista de estado entity a lista de model
     * @param usuarioEntities lista de objetos de entity
     * @return lista de objetos model
     */
    List<Usuario> listUsuarioEntityToModel(List<UsuarioEntity> usuarioEntities);

    /**
     * Mapea la informacion de model a entity
     * @param usuario objeto model
     * @return objeto entity
     */
    UsuarioEntity modelToUsuarioEntity(Usuario usuario);
}
