package com.sicte.capacidades.bodegaHistorico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.bodegaHistorico.entity.KcnsmuHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KdevolHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KentinvHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KgprodHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KsalconHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KsmprovHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.LconsumHistorico;
import com.sicte.capacidades.bodegaHistorico.repository.KcnsmuHistoricoRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KdevolHistoricoRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KentinvHistoricoRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KgprodHistoricoRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KsalconHistoricoRepository;
import com.sicte.capacidades.bodegaHistorico.repository.KsmprovHistoricoRepository;
import com.sicte.capacidades.bodegaHistorico.repository.LconsumHistoricoRepository;

@Service
public class BodegaHistoricoService {
    @Autowired
    KgprodHistoricoRepository kgprodHistoricoRepository;
    @Autowired
    LconsumHistoricoRepository lconsumHistoricoRepository;
    @Autowired
    KsalconHistoricoRepository ksalconHistoricoRepository;
    @Autowired
    KdevolHistoricoRepository kdevolHistoricoRepository;
    @Autowired
    KcnsmuHistoricoRepository kcnsmuHistoricoRepository;
    @Autowired
    KentinvHistoricoRepository kentinvHistoricoRepository;
    @Autowired
    KsmprovHistoricoRepository ksmprovHistoricoRepository;

    public List<KgprodHistorico> findAllKgprod() {
        return (List<KgprodHistorico>) kgprodHistoricoRepository.findAll();
    }

    public List<LconsumHistorico> findAllLconsum() {
        return (List<LconsumHistorico>) lconsumHistoricoRepository.findAll();
    }

    public List<KsalconHistorico> findAllKsalcon() {
        return (List<KsalconHistorico>) ksalconHistoricoRepository.findAll();
    }

    public List<KdevolHistorico> findAllKdevol() {
        return (List<KdevolHistorico>) kdevolHistoricoRepository.findAll();
    }

    public List<KcnsmuHistorico> findAllKcnsmu() {
        return (List<KcnsmuHistorico>) kcnsmuHistoricoRepository.findAll();
    }

    public List<KentinvHistorico> findAllKentinv() {
        return (List<KentinvHistorico>) kentinvHistoricoRepository.findAll();
    }

    public List<KsmprovHistorico> findAllKsmprov() {
        return (List<KsmprovHistorico>) ksmprovHistoricoRepository.findAll();
    }
}
