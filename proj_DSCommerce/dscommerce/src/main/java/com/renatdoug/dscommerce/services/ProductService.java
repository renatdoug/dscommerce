package com.renatdoug.dscommerce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductDTO> findAll() {
        List<Product> productList = repository.findAll();
        List<ProductDTO> dtoList = productList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
        return dtoList;
    } 

   

}
