package com.tarea4.tarea4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log")
public class Log {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    
    @Column(name = "mensaje", length = 300, nullable = false)
    private String mensaje;
    
    // Constructors
    public Log() {
        this.fecha = LocalDateTime.now();
    }
    
    public Log(String mensaje) {
        this.fecha = LocalDateTime.now();
        this.mensaje = mensaje;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    
    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
