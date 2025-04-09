package com.sicte.capacidades.bodegaHistorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.bodegaHistorico.entity.KcnsmuHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KdevolHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KentinvHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KgprodHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KsalconHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.KsmprovHistorico;
import com.sicte.capacidades.bodegaHistorico.entity.LconsumHistorico;
import com.sicte.capacidades.bodegaHistorico.service.BodegaHistoricoService;

import java.util.List;

@CrossOrigin(origins = { "https://sictepowergmail.github.io/", "https://BryanSicte.github.io", "http://localhost:3000",
        "https://bryanutria.github.io/" })
@RestController
@RequestMapping("/bodegaHistorico")
public class BodegaHistoricoController {
    @Autowired
    private BodegaHistoricoService bodegaHistoricoService;

    @GetMapping("/kgprod")
    public ResponseEntity<List<KgprodHistorico>> getAllKgprod() {
        List<KgprodHistorico> kgprod = bodegaHistoricoService.findAllKgprod();
        return new ResponseEntity<>(kgprod, HttpStatus.OK);
    }

    @GetMapping("/lconsum")
    public ResponseEntity<List<LconsumHistorico>> getAllLconsum() {
        List<LconsumHistorico> lconsum = bodegaHistoricoService.findAllLconsum();
        return new ResponseEntity<>(lconsum, HttpStatus.OK);
    }

    @GetMapping("/ksalcon")
    public ResponseEntity<List<KsalconHistorico>> getAllKsalcon() {
        List<KsalconHistorico> ksalcon = bodegaHistoricoService.findAllKsalcon();
        return new ResponseEntity<>(ksalcon, HttpStatus.OK);
    }

    @GetMapping("/kdevol")
    public ResponseEntity<List<KdevolHistorico>> getAllKdevol() {
        List<KdevolHistorico> kdevol = bodegaHistoricoService.findAllKdevol();
        return new ResponseEntity<>(kdevol, HttpStatus.OK);
    }

    @GetMapping("/kcnsmu")
    public ResponseEntity<List<KcnsmuHistorico>> getAllKcnsmu() {
        List<KcnsmuHistorico> kcnsmu = bodegaHistoricoService.findAllKcnsmu();
        return new ResponseEntity<>(kcnsmu, HttpStatus.OK);
    }

    @GetMapping("/kentinv")
    public ResponseEntity<List<KentinvHistorico>> getAllKentinv() {
        List<KentinvHistorico> kentinv = bodegaHistoricoService.findAllKentinv();
        return new ResponseEntity<>(kentinv, HttpStatus.OK);
    }

    @GetMapping("/ksmprov")
    public ResponseEntity<List<KsmprovHistorico>> getAllKsmprov() {
        List<KsmprovHistorico> ksmprov = bodegaHistoricoService.findAllKsmprov();
        return new ResponseEntity<>(ksmprov, HttpStatus.OK);
    }
}
