package com.Foro.challenge.controller;

import com.Foro.challenge.dominio.DTOActualizacion;
import com.Foro.challenge.dominio.DTOTopicos;
import com.Foro.challenge.dominio.DatosForo;
import com.Foro.challenge.dominio.Foro;
import com.Foro.challenge.repository.ForoRepositrory;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/foro")
public class foroController {

    @Autowired
    ForoRepositrory repositrory;

    @PostMapping
    public ResponseEntity<DTOTopicos> crearForo(@RequestBody @Valid DatosForo Datosforo, UriComponentsBuilder uriComponentsBuilder ){
       Foro foroNuevo= repositrory.save(new Foro(Datosforo));
       DTOTopicos nuevo=new DTOTopicos(foroNuevo);

        URI url= uriComponentsBuilder.path("/foro/{id}").buildAndExpand(foroNuevo.getId()).toUri();
       return ResponseEntity.created(url).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<Page<DTOTopicos>> mostratForos(@PageableDefault(size = 10,sort = "titulo") Pageable paginacion){
        return ResponseEntity.ok(repositrory.findByStatusTrue(paginacion).map(s->new DTOTopicos(s)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOTopicos> retornarForo(@PathVariable Long id){
        Foro foroBuscado=repositrory.getReferenceById(id);
        return ResponseEntity.ok(new DTOTopicos(foroBuscado));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DTOTopicos>  modificarForo(@PathVariable Long id, @RequestBody DTOActualizacion actualizacion){
        Foro foroActualizado=repositrory.getReferenceById(id);
        foroActualizado.actulizarDatos(actualizacion);
        return    ResponseEntity.ok(new DTOTopicos(foroActualizado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarForo(@PathVariable Long id){
        Foro foroAEliminar=repositrory.getReferenceById(id);
        foroAEliminar.eliminar();
        return ResponseEntity.ok("Eliminacion exitosa");
    }


}
