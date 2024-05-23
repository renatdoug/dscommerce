package com.renatdoug.crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renatdoug.crud.dto.ClientDTO;
import com.renatdoug.crud.entities.Client;
import com.renatdoug.crud.repositories.ClientRepository;
import com.renatdoug.crud.services.exceptions.ResourceNotFoundException;



@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

       @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Optional<Client> result = repository.findById(id);
        Client client = result.orElseThrow(
            ()-> new ResourceNotFoundException("Recursno não encontrado"));
        ClientDTO dto = new ClientDTO(client);
        return dto;
    }


}
