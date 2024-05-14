package com.renatdoug.dscommerce.services;


import java.util.Optional;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renatdoug.dscommerce.dto.ProductDTO;
import com.renatdoug.dscommerce.enitites.Product;
import com.renatdoug.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

   

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;

    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(ProductDTO::new);
    }  
    
    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        copyDtoTOEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }  

    @Transactional
    public ProductDTO update (Long id, ProductDTO dto){
        Product entity = repository.getReferenceById(id);        
        copyDtoTOEntity(dto, entity);
        return new ProductDTO(entity);
    }
    
    @Transactional()
    public void delete(Long id){
        repository.deleteById(id);
    }

    private void copyDtoTOEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setImgUrl(dto.getImgUrl());
    }  
   

}
