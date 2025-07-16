package com.tarea4.tarea4.repository;

import com.tarea4.tarea4.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {
    
    // Obtener todas las fotos con información de la actividad
    @Query("SELECT f FROM Foto f JOIN FETCH f.actividad ORDER BY f.id ASC")
    List<Foto> findAllWithActividad();
    
    // Obtener fotos por actividad ID
    List<Foto> findByActividadId(Integer actividadId);
}
