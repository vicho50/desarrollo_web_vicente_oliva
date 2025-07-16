package com.tarea4.tarea4.service;

import com.tarea4.tarea4.entity.Foto;
import com.tarea4.tarea4.entity.Log;
import com.tarea4.tarea4.repository.FotoRepository;
import com.tarea4.tarea4.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {
    
    @Autowired
    private FotoRepository fotoRepository;
    
    @Autowired
    private LogRepository logRepository;
    
    // Métodos para manejo de fotos
    public List<Foto> getAllFotosWithActividad() {
        return fotoRepository.findAllWithActividad();
    }
    
    public Optional<Foto> getFotoById(Integer id) {
        return fotoRepository.findById(id);
    }
    
    public void eliminarFoto(Integer id) {
        // Solo eliminar la foto, el log ya se registró en el controlador
        fotoRepository.deleteById(id);
    }
    
    // Métodos para manejo de logs
    public List<Log> getAllLogsOrdenados() {
        return logRepository.findAllOrderByFechaDesc();
    }
    
    public void registrarLog(String mensaje) {
        Log log = new Log(mensaje);
        logRepository.save(log);
    }
}
