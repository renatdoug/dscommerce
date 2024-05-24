package com.devrenatdoug.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devrenatdoug.aula.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    
} 