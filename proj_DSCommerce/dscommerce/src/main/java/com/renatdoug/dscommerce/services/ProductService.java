package com.renatdoug.dscommerce.services;


import java.util.Optional;
//import java.util.stream.Collectors;

import org.slf4j.Logger;


import org.springframework.transaction.annotation.Propagation;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renatdoug.dscommerce.dto.ProductDTO;
import com.renatdoug.dscommerce.enitites.Product;
import com.renatdoug.dscommerce.repositories.ProductRepository;
import com.renatdoug.dscommerce.services.exceptions.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

   

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.orElseThrow(
            ()-> new ResourceNotFoundException("Recursno não encontrado"));
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
        try{

            Product entity = repository.getReferenceById(id);        
            copyDtoTOEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);

        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recursno não encontrado");

        }
        
    }
    
   @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        Logger logger = LoggerFactory.getLogger(getClass());
        
        if (!repository.existsById(id)) {
            logger.warn("Tentativa de deletar recurso não encontrado com ID: {}", id);
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        
        try {
            repository.deleteById(id);
            logger.info("Recurso com ID: {} deletado com sucesso", id);
        } catch (DataIntegrityViolationException e) {
            logger.error("Falha de integridade referencial ao deletar recurso com ID: {}", id, e);
            throw new DatabaseException("Falha de integridade referencial");
        }
}

    private void copyDtoTOEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        
    }  
   

}
