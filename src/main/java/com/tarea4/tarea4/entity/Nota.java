package com.tarea4.tarea4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nota")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "actividad_id", nullable = false)
    private Integer actividadId;
    
    @Column(name = "nota", nullable = false)
    private Integer nota;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actividad_id", insertable = false, updatable = false)
    private Actividad actividad;
    
    // Constructors
    public Nota() {}
    
    public Nota(Integer actividadId, Integer nota) {
        this.actividadId = actividadId;
        this.nota = nota;
    }
    
    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getActividadId() { return actividadId; }
    public void setActividadId(Integer actividadId) { this.actividadId = actividadId; }
    
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
    
    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }
}
