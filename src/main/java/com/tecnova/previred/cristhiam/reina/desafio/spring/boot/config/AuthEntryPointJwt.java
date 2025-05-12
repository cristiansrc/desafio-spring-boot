package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * Clase encargada de la entrada de la peticion que no es autorizada
 */
@Component
public class AuthEntryPointJwt  implements AuthenticationEntryPoint {

    /**
     * El metodo comienza con la peticion
     * @param request request de la peticion
     * @param response response de la peticion
     * @param authException execpcion de la authenticacion
     * @throws IOException otras expeciones
     */
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }
}
