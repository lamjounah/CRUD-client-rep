package com.example.demo7.service;

import com.example.demo7.dto.ClientDto;
import com.example.demo7.modles.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAllClients(PageRequest pageRequest);


     public  Client saveClient(Client client);

    ClientDto findClientById(Long clientId);

    void updateClient(ClientDto client);

    void deleteClient(Long  clientId);


    Page<Client> findAllClients(Pageable pageable);
}
