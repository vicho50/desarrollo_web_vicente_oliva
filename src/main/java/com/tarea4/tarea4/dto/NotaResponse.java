package com.tarea4.tarea4.dto;

public class NotaResponse {
    private boolean success;
    private String message;
    private Double promedio;
    private Integer actividadId;
    
    public NotaResponse() {}
    
    public NotaResponse(boolean success, String message, Double promedio, Integer actividadId) {
        this.success = success;
        this.message = message;
        this.promedio = promedio;
        this.actividadId = actividadId;
    }
    
    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public Double getPromedio() { return promedio; }
    public void setPromedio(Double promedio) { this.promedio = promedio; }
    
    public Integer getActividadId() { return actividadId; }
    public void setActividadId(Integer actividadId) { this.actividadId = actividadId; }
}
