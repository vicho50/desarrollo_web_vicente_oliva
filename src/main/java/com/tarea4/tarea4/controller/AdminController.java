package com.tarea4.tarea4.controller;

import com.tarea4.tarea4.entity.Foto;
import com.tarea4.tarea4.entity.Log;
import com.tarea4.tarea4.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    // Administrador de fotos
    @GetMapping("/admin/fotos")
    public String adminFotos(Model model) {
        List<Foto> fotos = adminService.getAllFotosWithActividad();
        model.addAttribute("fotos", fotos);
        return "admin/fotos";
    }
    
    // Eliminar foto (API REST)
    @DeleteMapping("/api/foto/{id}")
    @ResponseBody
    public ResponseEntity<String> eliminarFoto(@PathVariable Integer id, @RequestParam String motivo) {
        try {
            Optional<Foto> foto = adminService.getFotoById(id);
            if (foto.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            
            // Registrar en log con motivo
            String mensaje = String.format("Foto eliminada: ID=%d, Archivo=%s, Motivo=%s", 
                                          id, foto.get().getNombreArchivo(), motivo);
            adminService.registrarLog(mensaje);
            
            // Eliminar la foto
            adminService.eliminarFoto(id);
            
            return ResponseEntity.ok("{\"success\": true, \"message\": \"Foto eliminada exitosamente\"}");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                               .body("{\"success\": false, \"message\": \"Error al eliminar la foto\"}");
        }
    }
    
    // Log de actividades
    @GetMapping("/log")
    public String log(Model model) {
        List<Log> logs = adminService.getAllLogsOrdenados();
        model.addAttribute("logs", logs);
        return "log";
    }
}
