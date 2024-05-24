package com.devrenatdoug.aula.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devrenatdoug.aula.dto.ProductDTO;
import com.devrenatdoug.aula.services.ProductService;

@RestController // Controlado implementa um recurso na APITest
// Para configurar a classe pra que ela responda pela rota /Product usa essa anotação - COnfigura  o controlador para responder por esta URL
@RequestMapping(value = "/products") // Mapeia todas as requisições para o caminho /api // Configuraçaõ da rota
public class ProductController {

     @Autowired
    private ProductService service; // Injeção de dependencia - Injeção de dependencia de um objeto que é criado pelo Spring -   
    
    
    @PostMapping // Mapeia o método para a rota /api/people
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
    	dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                  .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);        
    } 

}
