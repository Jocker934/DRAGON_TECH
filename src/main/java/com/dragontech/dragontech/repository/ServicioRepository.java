package com.dragontech.dragontech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dragontech.dragontech.model.Servicio;
import java.util.List;
import java.util.Optional;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    Optional<Servicio> findBySlug(String slug);
    List<Servicio> findAllByActivoTrueOrderByOrdenAsc();
}
