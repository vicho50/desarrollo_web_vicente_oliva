package com.tarea4.tarea4.repository;

import com.tarea4.tarea4.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
    
    @Query("SELECT a FROM Actividad a WHERE a.diaHoraTermino < :fechaActual")
    List<Actividad> findActividadesRealizadas(LocalDateTime fechaActual);
    
    @Query("SELECT a FROM Actividad a LEFT JOIN FETCH a.notas WHERE a.diaHoraTermino < :fechaActual")
    List<Actividad> findActividadesRealizadasWithNotas(LocalDateTime fechaActual);
}
