package com.renatdoug.dscommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatdoug.dscommerce.dto.ProductDTO;
import com.renatdoug.dscommerce.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController // Controlado implementa um recurso na APITest
// Para configurar a classe pra que ela responda pela rota /Product usa essa anotação - COnfigura  o controlador para responder por esta URL
@RequestMapping(value = "/products") // Mapeia todas as requisições para o caminho /api // Configuraçaõ da rota
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}") // Anotação essencial para que este recurso rsponda pelo método HTTP GET 
    
    public ProductDTO findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return dto;
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
    	return service.findAll(pageable);
    }  



}

