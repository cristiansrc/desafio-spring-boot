package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IUsuarioMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Usuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que mapea la informacion de usuarios
 */
@Service
public class UsuarioMapping implements IUsuarioMapping {

    /**
     * mapea la informacion la clase entity a la clase model
     * @param usuarioEntity objeto de base de datos
     * @return objeto model
     */
    @Override
    public Usuario usuarioEntityToModel(UsuarioEntity usuarioEntity) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioEntity.getId());
        usuario.setNombre(usuarioEntity.getNombre());
        usuario.setCorreo(usuarioEntity.getCorreo());
        usuario.setContrasena(usuarioEntity.getContrasena());
        return usuario;
    }

    /**
     * mapea la informacion de una lista de estado entity a lista de model
     * @param usuarioEntities lista de objetos de entity
     * @return lista de objetos model
     */
    @Override
    public List<Usuario> listUsuarioEntityToModel(List<UsuarioEntity> usuarioEntities) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioEntities.forEach(usuarioEntity -> usuarios.add(usuarioEntityToModel(usuarioEntity)));
        return usuarios;
    }

    /**
     * Mapea la informacion de model a entity
     * @param usuario objeto model
     * @return objeto entity
     */
    @Override
    public UsuarioEntity modelToUsuarioEntity(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setCorreo(usuario.getCorreo());
        usuarioEntity.setContrasena(usuario.getContrasena());
        return usuarioEntity;
    }
}
