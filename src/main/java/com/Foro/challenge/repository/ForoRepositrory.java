package com.Foro.challenge.repository;

import com.Foro.challenge.dominio.Foro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForoRepositrory extends JpaRepository<Foro,Long> {
    Page<Foro> findByStatusTrue(Pageable paginacion);
}
