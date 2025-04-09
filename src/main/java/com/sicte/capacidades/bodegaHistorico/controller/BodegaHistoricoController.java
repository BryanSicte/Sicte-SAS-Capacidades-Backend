package com.sicte.capacidades.bodegaHistorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.bodegaHistorico.entity.Kcnsmu;
import com.sicte.capacidades.bodegaHistorico.entity.Kdevol;
import com.sicte.capacidades.bodegaHistorico.entity.Kentinv;
import com.sicte.capacidades.bodegaHistorico.entity.Kgprod;
import com.sicte.capacidades.bodegaHistorico.entity.Ksalcon;
import com.sicte.capacidades.bodegaHistorico.entity.Ksmprov;
import com.sicte.capacidades.bodegaHistorico.entity.Lconsum;
import com.sicte.capacidades.bodegaHistorico.service.BodegaHistoricoService;

import java.util.List;

@CrossOrigin(origins = { "https://sictepowergmail.github.io/", "https://BryanSicte.github.io", "http://localhost:3000",
        "https://bryanutria.github.io/" })
@RestController
@RequestMapping("/bodega")
public class BodegaHistoricoController {
    @Autowired
    private BodegaHistoricoService bodegaHistoricoService;

    @GetMapping("/kgprod")
    public ResponseEntity<List<Kgprod>> getAllKgprod() {
        List<Kgprod> kgprod = bodegaHistoricoService.findAllKgprod();
        return new ResponseEntity<>(kgprod, HttpStatus.OK);
    }

    @GetMapping("/lconsum")
    public ResponseEntity<List<Lconsum>> getAllLconsum() {
        List<Lconsum> lconsum = bodegaHistoricoService.findAllLconsum();
        return new ResponseEntity<>(lconsum, HttpStatus.OK);
    }

    @GetMapping("/ksalcon")
    public ResponseEntity<List<Ksalcon>> getAllKsalcon() {
        List<Ksalcon> ksalcon = bodegaHistoricoService.findAllKsalcon();
        return new ResponseEntity<>(ksalcon, HttpStatus.OK);
    }

    @GetMapping("/kdevol")
    public ResponseEntity<List<Kdevol>> getAllKdevol() {
        List<Kdevol> kdevol = bodegaHistoricoService.findAllKdevol();
        return new ResponseEntity<>(kdevol, HttpStatus.OK);
    }

    @GetMapping("/kcnsmu")
    public ResponseEntity<List<Kcnsmu>> getAllKcnsmu() {
        List<Kcnsmu> kcnsmu = bodegaHistoricoService.findAllKcnsmu();
        return new ResponseEntity<>(kcnsmu, HttpStatus.OK);
    }

    @GetMapping("/kentinv")
    public ResponseEntity<List<Kentinv>> getAllKentinv() {
        List<Kentinv> kentinv = bodegaHistoricoService.findAllKentinv();
        return new ResponseEntity<>(kentinv, HttpStatus.OK);
    }

    @GetMapping("/ksmprov")
    public ResponseEntity<List<Ksmprov>> getAllKsmprov() {
        List<Ksmprov> ksmprov = bodegaHistoricoService.findAllKsmprov();
        return new ResponseEntity<>(ksmprov, HttpStatus.OK);
    }
}
