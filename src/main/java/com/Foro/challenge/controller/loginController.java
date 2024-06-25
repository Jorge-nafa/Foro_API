package com.Foro.challenge.controller;

import com.Foro.challenge.infra.Contraseña.UsuarioService;
import com.Foro.challenge.infra.seguridad.DTOJWtoken;
import com.Foro.challenge.infra.seguridad.Token;
import com.Foro.challenge.usuarios.DTOUsuario;
import com.Foro.challenge.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/login")
public class loginController {
    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Token tokenClase;

    public loginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity Autenticar(@RequestBody @Valid DTOUsuario dtOusuario, UriComponentsBuilder uriComponentsBuilder){
        Authentication token= new UsernamePasswordAuthenticationToken(dtOusuario.login(),dtOusuario.clave());
        var autentico=authenticationManager.authenticate(token);
        var JWtoken= tokenClase.generarToken((Usuario) autentico.getPrincipal());
        return ResponseEntity.ok(new DTOJWtoken(JWtoken));
    }

    @PostMapping("/registro")
    public ResponseEntity<DTOUsuario> registrarUsuario(@RequestBody @Valid DTOUsuario nuevoUsuario) {
        Usuario usuario = usuarioService.crearUsuario(nuevoUsuario.login(),nuevoUsuario.clave() );
        System.out.println(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }


}

