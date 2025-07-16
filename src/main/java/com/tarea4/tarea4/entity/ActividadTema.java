package com.tarea4.tarea4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "actividad_tema")
public class ActividadTema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tema", nullable = false)
    private TemaEnum tema;
    
    @Column(name = "glosa_otro", length = 15)
    private String glosaOtro;
    
    @Column(name = "actividad_id", nullable = false)
    private Integer actividadId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actividad_id", insertable = false, updatable = false)
    private Actividad actividad;
    
    // Enum for tema
    public enum TemaEnum {
        música, deporte, ciencias, religión, política, tecnología, juegos, baile, comida, otro
    }
    
    // Constructors
    public ActividadTema() {}
    
    public ActividadTema(TemaEnum tema, String glosaOtro, Integer actividadId) {
        this.tema = tema;
        this.glosaOtro = glosaOtro;
        this.actividadId = actividadId;
    }
    
    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public TemaEnum getTema() { return tema; }
    public void setTema(TemaEnum tema) { this.tema = tema; }
    
    public String getGlosaOtro() { return glosaOtro; }
    public void setGlosaOtro(String glosaOtro) { this.glosaOtro = glosaOtro; }
    
    public Integer getActividadId() { return actividadId; }
    public void setActividadId(Integer actividadId) { this.actividadId = actividadId; }
    
    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }
}
