package com.tarea4.tarea4.repository;

import com.tarea4.tarea4.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    
    // Obtener logs ordenados por fecha descendente (más reciente primero)
    @Query("SELECT l FROM Log l ORDER BY l.fecha DESC")
    List<Log> findAllOrderByFechaDesc();
    
    // Obtener logs ordenados por fecha ascendente (más antiguo primero)
    @Query("SELECT l FROM Log l ORDER BY l.fecha ASC")
    List<Log> findAllOrderByFechaAsc();
}
