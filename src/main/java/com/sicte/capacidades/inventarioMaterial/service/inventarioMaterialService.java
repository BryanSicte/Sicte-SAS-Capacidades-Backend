package com.sicte.capacidades.inventarioMaterial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.inventarioMaterial.entity.inventarioMaterial;
import com.sicte.capacidades.inventarioMaterial.repository.inventarioMaterialRepository;

@Service
public class inventarioMaterialService{
    @Autowired
    inventarioMaterialRepository inventarioMaterialRepository;

    public inventarioMaterial guardarRegistro(inventarioMaterial registro) {
        return inventarioMaterialRepository.save(registro);
    }

    public List<inventarioMaterial> encontrarTodoRegistros() {
        return (List<inventarioMaterial>) inventarioMaterialRepository.findAll();
    }
}
