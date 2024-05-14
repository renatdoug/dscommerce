package com.renatdoug.dscommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatdoug.dscommerce.dto.ProductDTO;
import com.renatdoug.dscommerce.services.ProductService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController // Controlado implementa um recurso na APITest
// Para configurar a classe pra que ela responda pela rota /Product usa essa anotação - COnfigura  o controlador para responder por esta URL
@RequestMapping(value = "/products") // Mapeia todas as requisições para o caminho /api // Configuraçaõ da rota
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}") // Anotação essencial para que este recurso rsponda pelo método HTTP GET 
    
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
        Page<ProductDTO> dto = service.findAll(pageable);
    	return ResponseEntity.ok(dto);
    }  

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
    	dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                  .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);        
    }  

    @PutMapping(value = "/{id}") // Anotação essencial para que este recurso rsponda pelo método HTTP GET 
    
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

}

