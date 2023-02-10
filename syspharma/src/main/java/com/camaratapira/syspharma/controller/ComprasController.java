package com.camaratapira.syspharma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camaratapira.syspharma.entity.Compras;
import com.camaratapira.syspharma.repositories.ComprasRepository;
import com.camaratapira.syspharma.repositories.FarmaciaRepository;
import com.camaratapira.syspharma.repositories.ServidorRepository;

@RestController
@RequestMapping("/api")
public class ComprasController {

    @Autowired
    ComprasRepository comprasRepository;
    @Autowired
    ServidorRepository servidorRepository;
    @Autowired
    FarmaciaRepository farmaciaRepository;

    //TO-DO query para listar as compras e stored procedure para poder inserir uma compra
    
}
