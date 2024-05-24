package com.devrenatdoug.aula.repositories;

import com.devrenatdoug.aula.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
} 