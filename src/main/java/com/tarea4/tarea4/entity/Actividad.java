package com.tarea4.tarea4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actividad")
public class Actividad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "comuna_id", nullable = false)
    private Integer comunaId;
    
    @Column(name = "sector", length = 100)
    private String sector;
    
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    
    @Column(name = "celular", length = 15)
    private String celular;
    
    @Column(name = "dia_hora_inicio", nullable = false)
    private LocalDateTime diaHoraInicio;
    
    @Column(name = "dia_hora_termino")
    private LocalDateTime diaHoraTermino;
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nota> notas;
    
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActividadTema> temas;
    
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Foto> fotos;
    
    // Constructors
    public Actividad() {}
    
    public Actividad(Integer comunaId, String sector, String nombre, String email, 
                    String celular, LocalDateTime diaHoraInicio, LocalDateTime diaHoraTermino, 
                    String descripcion) {
        this.comunaId = comunaId;
        this.sector = sector;
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
        this.diaHoraInicio = diaHoraInicio;
        this.diaHoraTermino = diaHoraTermino;
        this.descripcion = descripcion;
    }
    
    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getComunaId() { return comunaId; }
    public void setComunaId(Integer comunaId) { this.comunaId = comunaId; }
    
    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    
    public LocalDateTime getDiaHoraInicio() { return diaHoraInicio; }
    public void setDiaHoraInicio(LocalDateTime diaHoraInicio) { this.diaHoraInicio = diaHoraInicio; }
    
    public LocalDateTime getDiaHoraTermino() { return diaHoraTermino; }
    public void setDiaHoraTermino(LocalDateTime diaHoraTermino) { this.diaHoraTermino = diaHoraTermino; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public List<Nota> getNotas() { return notas; }
    public void setNotas(List<Nota> notas) { this.notas = notas; }
    
    public List<ActividadTema> getTemas() { return temas; }
    public void setTemas(List<ActividadTema> temas) { this.temas = temas; }
    
    public List<Foto> getFotos() { return fotos; }
    public void setFotos(List<Foto> fotos) { this.fotos = fotos; }
    
    // Helper method to calculate average rating
    public Double getPromedio() {
        if (notas == null || notas.isEmpty()) {
            return null;
        }
        return notas.stream()
                   .mapToDouble(Nota::getNota)
                   .average()
                   .orElse(0.0);
    }
}
