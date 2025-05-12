package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.data;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.IEstadoRepository;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.IUsuarioRepository;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.EstadoEntity;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Clase encargada de crear registros al subir el servicio
 */
@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private IUsuarioRepository usuarioRepository;
    private IEstadoRepository estadoRepository;

    @Override
    public void run(String... args) throws Exception {

        usuarioRepository.save(UsuarioEntity.builder()
                .nombre("Cristhiam Reina")
                .correo("cristiansrc@gmail.com")
                .contrasena("123456")
                .build());

        usuarioRepository.save(UsuarioEntity.builder()
                .nombre("Andrea Garcia")
                .correo("agarcia@gmail.com")
                .contrasena("123456")
                .build());

        usuarioRepository.save(UsuarioEntity.builder()
                .nombre("Camilo Gutierres")
                .correo("cgutierra@gmail.com")
                .contrasena("123456")
                .build());

        usuarioRepository.save(UsuarioEntity.builder()
                .nombre("Gabriela Gomez")
                .correo("ggoimez@gmail.com")
                .contrasena("123456")
                .build());

        estadoRepository.save(EstadoEntity.builder()
                .nombre("Creada")
                .build());

        estadoRepository.save(EstadoEntity.builder()
                .nombre("En ejecucion")
                .build());

        estadoRepository.save(EstadoEntity.builder()
                .nombre("Bloqueada")
                .build());

        estadoRepository.save(EstadoEntity.builder()
                .nombre("Terminada")
                .build());
    }
}
