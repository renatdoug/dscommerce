package com.renatdoug.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatdoug.dscommerce.enitites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
