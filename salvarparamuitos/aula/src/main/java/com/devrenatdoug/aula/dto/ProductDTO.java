package com.devrenatdoug.aula.dto;

import java.util.ArrayList;
import java.util.List;

import com.devrenatdoug.aula.entities.Category;
import com.devrenatdoug.aula.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, Double price) { // nunca associar classe DTO com outra entidade que nao seja DTO
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        for(Category cat : entity.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    

    

}
