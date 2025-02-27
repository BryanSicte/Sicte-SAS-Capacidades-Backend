package com.sicte.capacidades.bodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.bodega.entity.Kgprod;
import com.sicte.capacidades.bodega.entity.Lconsum;
import com.sicte.capacidades.bodega.repository.KgprodRepository;
import com.sicte.capacidades.bodega.repository.LconsumRepository;

@Service
public class BodegaService{
    @Autowired
    KgprodRepository kgprodRepository;
    @Autowired
    LconsumRepository lconsumRepository;

    public List<Kgprod> findAllKgprod() {
        return (List<Kgprod>) kgprodRepository.findAll();
    }

    public List<Lconsum> findAllLconsum() {
        return (List<Lconsum>) lconsumRepository.findAll();
    }
}
