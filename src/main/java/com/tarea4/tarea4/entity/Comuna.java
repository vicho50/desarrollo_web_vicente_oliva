package com.tarea4.tarea4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comuna")
public class Comuna {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    
    @Column(name = "region_id", nullable = false)
    private Integer regionId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", insertable = false, updatable = false)
    private Region region;
    
    // Constructors
    public Comuna() {}
    
    public Comuna(String nombre, Integer regionId) {
        this.nombre = nombre;
        this.regionId = regionId;
    }
    
    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Integer getRegionId() { return regionId; }
    public void setRegionId(Integer regionId) { this.regionId = regionId; }
    
    public Region getRegion() { return region; }
    public void setRegion(Region region) { this.region = region; }
}
