package com.Foro.challenge.infra.seguridad;

import com.Foro.challenge.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FiltroDeSeguridad  extends OncePerRequestFilter {

    @Autowired
    private Token tokenClass;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var tokenRecibido=request.getHeader("Authorization");
        if(tokenRecibido!=null){
            tokenRecibido=tokenRecibido.replace("Bearer ","");

            var subject =tokenClass.getSubjet(tokenRecibido);

            System.out.println(tokenRecibido);
            System.out.println(tokenClass.getSubjet(tokenRecibido));

            if (subject!=null){
                //es valido
                var usuario= usuarioRepository.findByLogin(subject);
                var autentico= new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autentico);
            }
        }
        filterChain.doFilter(request,response);

    }
}
