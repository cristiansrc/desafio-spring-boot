package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.config.JwtUtil;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.exception.ServiceException;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IUsuarioMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.AuthUsuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.LoginUsuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Usuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.IUsuarioRepository;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.UsuarioEntity;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;
    private IUsuarioMapping usuarioMapping;
    private JwtUtil jwtUtil;

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioMapping.listUsuarioEntityToModel(this.usuarioRepository.findAll());
    }

    @Override
    public Usuario obtenerUsuario(Integer id) {
        return usuarioMapping.usuarioEntityToModel(this.usuarioRepository.getReferenceById(id));
    }

    @Override
    public AuthUsuario loginUsuario(LoginUsuario loginUsuario) {
        AuthUsuario authUsuario = new AuthUsuario();
        String pass = loginUsuario.getContrasena();
        this.usuarioRepository.login(
                loginUsuario.getCorreo(),
                pass
                ).ifPresentOrElse(
                usuarioEntity -> {
                    authUsuario.setUsuario(this.usuarioMapping.usuarioEntityToModel(usuarioEntity));
                    authUsuario.setAuthorization(jwtUtil.generateToken(usuarioEntity.getCorreo()));
                },
                () -> {
                    throw new ServiceException(
                            "Usuario no encontrado",
                            HttpStatus.NOT_FOUND);
                }
        );

        return authUsuario;

    }

    @Override
    public Integer agregarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioMapping.modelToUsuarioEntity(usuario);
        usuarioEntity.setContrasena(usuario.getContrasena());
        return usuarioRepository.save(usuarioEntity).getId();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        if(usuario.getId() == null){ throw new ServiceException(
                "No esta presente el id del usuario",
                HttpStatus.NOT_FOUND);}

        usuarioRepository.findById(usuario.getId()).ifPresentOrElse(
                usuarioEntity -> {
                    usuarioEntity.setNombre(usuario.getNombre());
                    usuarioEntity.setCorreo(usuario.getCorreo());
                    usuarioEntity.setContrasena(usuario.getContrasena());
                    usuarioRepository.save(usuarioEntity);
                },
                () -> {
                    throw new ServiceException(
                            "id no encontrado en base de datos",
                            HttpStatus.NOT_FOUND);
                }
        );
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.findById(id).ifPresentOrElse(
                usuarioEntity -> usuarioRepository.deleteById(usuarioEntity.getId()),
                () -> {
                    throw new ServiceException(
                            "id no encontrado en base de datos",
                            HttpStatus.NOT_FOUND);
                }
        );
    }


}
