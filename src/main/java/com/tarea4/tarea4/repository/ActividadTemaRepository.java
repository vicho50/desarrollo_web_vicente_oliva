package com.tarea4.tarea4.repository;

import com.tarea4.tarea4.entity.ActividadTema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadTemaRepository extends JpaRepository<ActividadTema, Integer> {
}
