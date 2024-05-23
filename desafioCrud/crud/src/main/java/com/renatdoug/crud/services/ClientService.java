package com.renatdoug.crud.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.renatdoug.crud.dto.ClientDTO;
import com.renatdoug.crud.entities.Client;
import com.renatdoug.crud.repositories.ClientRepository;
import com.renatdoug.crud.services.exceptions.DatabaseException;
import com.renatdoug.crud.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;




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

    
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(ClientDTO::new);
    }  
    
    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoTOEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }  

    @Transactional
    public ClientDTO update (Long id, ClientDTO dto){
        try{

            Client entity = repository.getReferenceById(id);        
            copyDtoTOEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);

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

    private void copyDtoTOEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());        
    }  


}
