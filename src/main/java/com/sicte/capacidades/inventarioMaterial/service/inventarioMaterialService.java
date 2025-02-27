package com.sicte.capacidades.inventarioMaterial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.inventarioMaterial.entity.InventarioMaterial;
import com.sicte.capacidades.inventarioMaterial.repository.InventarioMaterialRepository;

@Service
public class InventarioMaterialService{
    @Autowired
    InventarioMaterialRepository inventarioMaterialRepository;

    public InventarioMaterial guardarRegistro(InventarioMaterial registro) {
        return inventarioMaterialRepository.save(registro);
    }

    public List<InventarioMaterial> encontrarTodoRegistros() {
        return (List<InventarioMaterial>) inventarioMaterialRepository.findAll();
    }
}
