package com.example.serviciodocentes.services;

import com.example.serviciodocentes.entitys.LineaInv;

import java.util.List;

public interface LineaInvService {
    List<LineaInv> getAllLineas();
    LineaInv createLineas(LineaInv lineaInv, String requesterRol)throws Exception;
    LineaInv getLineasById(Long id)throws Exception;
    LineaInv updateLineas(Long id, LineaInv updateLineas, Long userId)throws Exception;
    void deleteLineas(Long id) throws Exception;
}
