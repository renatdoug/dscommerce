package com.renatdoug.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatdoug.crud.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{

}
