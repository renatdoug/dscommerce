package com.renatdoug.dscommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatdoug.dscommerce.enitites.Product;
import com.renatdoug.dscommerce.repositories.ProductRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController // Controlado implementa um recurso na APITest
// Para configurar a classe pra que ela responda pela rota /Product usa essa anotação - COnfigura  o controlador para responder por esta URL
@RequestMapping(value = "/products") // Mapeia todas as requisições para o caminho /api // Configuraçaõ da rota
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping // Anotação essencial para que este recurso rsponda pelo método HTTP GET   
    public String teste(){
        Optional<Product> result = repository.findById(1L);
        Product product = result.get();
        return product.getName();
    }

}
