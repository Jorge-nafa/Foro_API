package com.Foro.challenge.infra.seguridad;

import com.Foro.challenge.usuarios.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class Token {

    @Value("${api.security.token.secret}")
    private String apiSecret;

    public  String generarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("Foros,challenge")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar el  token jwt", exception);
        }
    }



    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
    }

    public String getSubjet(String tokeRecibido) {
        DecodedJWT verificar = null;
        try {
            var algoritmo = Algorithm.HMAC256(apiSecret);
            return JWT.require(algoritmo)
                    .withIssuer("Foros,challenge")
                    .build()
                    .verify(tokeRecibido)
                    .getSubject();
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error en el subject");
        }

    }

}
