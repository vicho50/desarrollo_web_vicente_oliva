package com.tarea4.tarea4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "foto")
public class Foto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ruta_archivo", length = 300, nullable = false)
    private String rutaArchivo;
    
    @Column(name = "nombre_archivo", length = 300, nullable = false)
    private String nombreArchivo;
    
    @Column(name = "actividad_id", nullable = false)
    private Integer actividadId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actividad_id", insertable = false, updatable = false)
    private Actividad actividad;
    
    // Constructors
    public Foto() {}
    
    public Foto(String rutaArchivo, String nombreArchivo, Integer actividadId) {
        this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.actividadId = actividadId;
    }
    
    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getRutaArchivo() { return rutaArchivo; }
    public void setRutaArchivo(String rutaArchivo) { this.rutaArchivo = rutaArchivo; }
    
    public String getNombreArchivo() { return nombreArchivo; }
    public void setNombreArchivo(String nombreArchivo) { this.nombreArchivo = nombreArchivo; }
    
    public Integer getActividadId() { return actividadId; }
    public void setActividadId(Integer actividadId) { this.actividadId = actividadId; }
    
    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }
}
