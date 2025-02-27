package com.sicte.capacidades.bodega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.bodega.entity.kgprod;
import com.sicte.capacidades.bodega.entity.lconsum;
import com.sicte.capacidades.bodega.service.bodegaService;

import java.util.List;


@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000", "https://bryanutria.github.io/"})
@RestController
@RequestMapping("/bodega")
public class bodegaController {
    @Autowired
    private bodegaService bodegaService;

    @GetMapping("/kgprod")
    public ResponseEntity<List<kgprod>> getAllKgprod() {
        List<kgprod> kgprod = bodegaService.findAllKgprod();
        return new ResponseEntity<>(kgprod, HttpStatus.OK);
    }

    @GetMapping("/lconsum")
    public ResponseEntity<List<lconsum>> getAllLconsum() {
        List<lconsum> lconsum = bodegaService.findAllLconsum();
        return new ResponseEntity<>(lconsum, HttpStatus.OK);
    }
}
