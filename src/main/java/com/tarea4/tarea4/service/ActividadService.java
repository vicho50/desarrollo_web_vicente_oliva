package com.tarea4.tarea4.service;

import com.tarea4.tarea4.entity.Actividad;
import com.tarea4.tarea4.entity.Nota;
import com.tarea4.tarea4.repository.ActividadRepository;
import com.tarea4.tarea4.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActividadService {
    
    @Autowired
    private ActividadRepository actividadRepository;
    
    @Autowired
    private NotaRepository notaRepository;
    
    public List<Actividad> getActividadesRealizadas() {
        return actividadRepository.findActividadesRealizadasWithNotas(LocalDateTime.now());
    }
    
    public Optional<Actividad> getActividadById(Integer id) {
        return actividadRepository.findById(id);
    }
    
    public Nota agregarNota(Integer actividadId, Integer valorNota) {
        // Validar que la nota esté entre 1 y 7
        if (valorNota < 1 || valorNota > 7) {
            throw new IllegalArgumentException("La nota debe estar entre 1 y 7");
        }
        
        // Verificar que la actividad existe
        Optional<Actividad> actividad = actividadRepository.findById(actividadId);
        if (actividad.isEmpty()) {
            throw new IllegalArgumentException("La actividad no existe");
        }
        
        // Verificar que la actividad esté terminada
        if (actividad.get().getDiaHoraTermino() == null || 
            actividad.get().getDiaHoraTermino().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Solo se pueden evaluar actividades terminadas");
        }
        
        Nota nota = new Nota(actividadId, valorNota);
        return notaRepository.save(nota);
    }
    
    public Double getPromedioNota(Integer actividadId) {
        return notaRepository.getPromedioNotaByActividadId(actividadId);
    }
}
