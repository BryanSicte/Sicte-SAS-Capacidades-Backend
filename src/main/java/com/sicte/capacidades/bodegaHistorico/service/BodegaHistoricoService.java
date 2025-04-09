package com.sicte.capacidades.bodegaHistorico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.bodegaHistorico.entity.Kcnsmu;
import com.sicte.capacidades.bodegaHistorico.entity.Kdevol;
import com.sicte.capacidades.bodegaHistorico.entity.Kentinv;
import com.sicte.capacidades.bodegaHistorico.entity.Kgprod;
import com.sicte.capacidades.bodegaHistorico.entity.Ksalcon;
import com.sicte.capacidades.bodegaHistorico.entity.Ksmprov;
import com.sicte.capacidades.bodegaHistorico.entity.Lconsum;
import com.sicte.capacidades.bodegaHistorico.repository.KcnsmuRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KdevolRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KentinvRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KgprodRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KsalconRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KsmprovRepository;
import com.sicte.capacidades.bodegaHistorico.repository.LconsumRepository;

@Service
public class BodegaHistoricoService {
    @Autowired
    KgprodRepository kgprodRepository;
    @Autowired
    LconsumRepository lconsumRepository;
    @Autowired
    KsalconRepository ksalconRepository;
    @Autowired
    KdevolRepository kdevolRepository;
    @Autowired
    KcnsmuRepository kcnsmuRepository;
    @Autowired
    KentinvRepository kentinvRepository;
    @Autowired
    KsmprovRepository ksmprovRepository;

    public List<Kgprod> findAllKgprod() {
        return (List<Kgprod>) kgprodRepository.findAll();
    }

    public List<Lconsum> findAllLconsum() {
        return (List<Lconsum>) lconsumRepository.findAll();
    }

    public List<Ksalcon> findAllKsalcon() {
        return (List<Ksalcon>) ksalconRepository.findAll();
    }

    public List<Kdevol> findAllKdevol() {
        return (List<Kdevol>) kdevolRepository.findAll();
    }

    public List<Kcnsmu> findAllKcnsmu() {
        return (List<Kcnsmu>) kcnsmuRepository.findAll();
    }

    public List<Kentinv> findAllKentinv() {
        return (List<Kentinv>) kentinvRepository.findAll();
    }

    public List<Ksmprov> findAllKsmprov() {
        return (List<Ksmprov>) ksmprovRepository.findAll();
    }
}
