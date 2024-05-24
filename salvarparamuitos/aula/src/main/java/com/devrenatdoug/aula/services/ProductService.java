package com.devrenatdoug.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrenatdoug.aula.dto.CategoryDTO;
import com.devrenatdoug.aula.dto.ProductDTO;
import com.devrenatdoug.aula.entities.Category;
import com.devrenatdoug.aula.entities.Product;
import com.devrenatdoug.aula.repositories.CategoryRepository;
import com.devrenatdoug.aula.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryrepository;

    public ProductDTO insert(ProductDTO dto){

        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for (CategoryDTO catDto : dto.getCategories()){

            Category cat = categoryrepository.getReferenceById(catDto.getId());

            //Category cat = new Category();
            //cat.setId(catDto.getId());
            entity.getCategories().add(cat);
        }

        entity = repository.save(entity);

        return new ProductDTO(entity);
    } 

}
