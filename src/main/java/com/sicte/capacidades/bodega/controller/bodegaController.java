package com.sicte.capacidades.bodega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.bodega.entity.Kgprod;
import com.sicte.capacidades.bodega.entity.Lconsum;
import com.sicte.capacidades.bodega.service.BodegaService;

import java.util.List;


@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000", "https://bryanutria.github.io/"})
@RestController
@RequestMapping("/bodega")
public class BodegaController {
    @Autowired
    private BodegaService bodegaService;

    @GetMapping("/kgprod")
    public ResponseEntity<List<Kgprod>> getAllKgprod() {
        List<Kgprod> kgprod = bodegaService.findAllKgprod();
        return new ResponseEntity<>(kgprod, HttpStatus.OK);
    }

    @GetMapping("/lconsum")
    public ResponseEntity<List<Lconsum>> getAllLconsum() {
        List<Lconsum> lconsum = bodegaService.findAllLconsum();
        return new ResponseEntity<>(lconsum, HttpStatus.OK);
    }
}
