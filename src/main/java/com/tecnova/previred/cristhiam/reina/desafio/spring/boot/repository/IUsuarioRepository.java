package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Usuario;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface que describe la gestion de la tabla en base de datos
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    /**
     * Metodo que busca un usuario por su correo y contraseña
     * @param correo registrado del usuario
     * @param contrasena registrado del usuario
     * @return informacion del usuario en base de datos
     */
    @Query("SELECT u FROM UsuarioEntity u WHERE u.correo = :correo and u.contrasena = :contrasena")
    Optional<UsuarioEntity> login(@Param("correo") String correo, @Param("contrasena") String contrasena);

    /**
     * Metodo que devuelve la informacion de un usuario para comprobar el token de session
     * @param correo registrado del usuario
     * @return informacion del usuario en base de datos
     */
    Optional<UsuarioEntity> findUsuarioByCorreo(String correo);
}