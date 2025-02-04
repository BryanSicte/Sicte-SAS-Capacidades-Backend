package com.sicte.capacidades.bodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.bodega.entity.kgprod;
import com.sicte.capacidades.bodega.entity.lconsum;
import com.sicte.capacidades.bodega.repository.kgprodRepository;
import com.sicte.capacidades.bodega.repository.lconsumRepository;

@Service
public class bodegaService{
    @Autowired
    kgprodRepository kgprodRepository;
    @Autowired
    lconsumRepository lconsumRepository;

    public List<kgprod> findAllKgprod() {
        return (List<kgprod>) kgprodRepository.findAll();
    }

    public List<lconsum> findAllLconsum() {
        return (List<lconsum>) lconsumRepository.findAll();
    }
}
