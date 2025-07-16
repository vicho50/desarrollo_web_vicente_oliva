package com.tarea4.tarea4.repository;

import com.tarea4.tarea4.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
    
    List<Nota> findByActividadId(Integer actividadId);
    
    @Query("SELECT AVG(n.nota) FROM Nota n WHERE n.actividadId = :actividadId")
    Double getPromedioNotaByActividadId(@Param("actividadId") Integer actividadId);
}
