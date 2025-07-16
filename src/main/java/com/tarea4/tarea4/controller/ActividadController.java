package com.tarea4.tarea4.controller;

import com.tarea4.tarea4.dto.NotaResponse;
import com.tarea4.tarea4.entity.Actividad;
import com.tarea4.tarea4.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ActividadController {
    
    @Autowired
    private ActividadService actividadService;
    
    @GetMapping("/")
    public String index(Model model) {
        List<Actividad> actividades = actividadService.getActividadesRealizadas();
        model.addAttribute("actividades", actividades);
        return "index";
    }
    
    @PostMapping("/api/actividad/{id}/nota")
    @ResponseBody
    public ResponseEntity<NotaResponse> agregarNota(@PathVariable Integer id, @RequestParam Integer nota) {
        try {
            actividadService.agregarNota(id, nota);
            Double promedio = actividadService.getPromedioNota(id);
            
            NotaResponse response = new NotaResponse(true, "Nota agregada exitosamente", promedio, id);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            NotaResponse response = new NotaResponse(false, e.getMessage(), null, id);
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            NotaResponse response = new NotaResponse(false, "Error interno del servidor", null, id);
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
