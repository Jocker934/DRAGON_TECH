package com.dragontech.dragontech.service;

import org.springframework.stereotype.Service;
import com.dragontech.dragontech.repository.ServicioRepository;
import com.dragontech.dragontech.model.Servicio;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    private final ServicioRepository repo;

    public ServicioService(ServicioRepository repo) { this.repo = repo; }

    public List<Servicio> obtenerActivos() {
        return repo.findAllByActivoTrueOrderByOrdenAsc();
    }

    public Servicio guardar(Servicio s) {
        // aquí podrías generar slug seguro si viene vacío
        if (s.getSlug() == null || s.getSlug().isBlank()) {
            s.setSlug(generarSlug(s.getNombre()));
        }
        return repo.save(s);
    }

    public Optional<Servicio> buscarPorSlug(String slug) {
        return repo.findBySlug(slug);
    }

    public Optional<Servicio> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    private String generarSlug(String nombre) {
        return nombre.toLowerCase().trim().replaceAll("[^a-z0-9]+","-");
    }
}
