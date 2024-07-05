package com.example.serviciodocentes.services.impl;

import com.example.serviciodocentes.entitys.LineaInv;
import com.example.serviciodocentes.repository.LineaInvRepository;
import com.example.serviciodocentes.services.LineaInvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class LineaInvServiceImpl implements LineaInvService {

    @Autowired
    private LineaInvRepository lineaInvRepository;


    @Override
    public List<LineaInv> getAllLineas() {

        return lineaInvRepository.findAll();
    }

    @Override
    public LineaInv createLineas(LineaInv lineaInv, String requesterRol) throws Exception {
        if(!requesterRol.equals(("ROLE ADMIN"))){
            throw new Exception("solo el admin y docente pueden crear lineas");
        }

        return lineaInvRepository.save(lineaInv);
    }

    @Override
    public LineaInv getLineasById(Long id) throws Exception {
        return lineaInvRepository.findById(id).orElseThrow(()->new Exception("linea no encontrada con id"+ id));
    }

    @Override
    public LineaInv updateLineas(Long id, LineaInv updatedLineas, Long userId) throws Exception {
        LineaInv existenlaslineas = getLineasById(id);

        if (updatedLineas.getId()!=null){
            existenlaslineas.setId(updatedLineas.getId());
        }
        if (updatedLineas.getNombre_linea()!=null){
            existenlaslineas.setNombre_linea(updatedLineas.getNombre_linea());
        }
        if (updatedLineas.getDescripcion()!=null){
            existenlaslineas.setDescripcion(updatedLineas.getDescripcion());
        }

        return lineaInvRepository.save(existenlaslineas);
    }

    @Override
    public void deleteLineas(Long id) throws Exception {
        getLineasById(id);
        lineaInvRepository.deleteById(id);


    }
}
