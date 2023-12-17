package com.example.demo7.service;

import com.example.demo7.dto.ClientDto;
import com.example.demo7.mapper.ClientMapper;
import com.example.demo7.modles.Client;
import com.example.demo7.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    public ClientRepository clientRepository;


    @Override

    public List<ClientDto> findAllClients(PageRequest pageRequest) {
        List<Client> clients=clientRepository.findAll();
        return clients.stream().map(client ->
                ClientMapper.mapToClientDto(client)).collect(Collectors.toList());
    }

    public Client saveClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public ClientDto findClientById(Long clientId) {
        Client client= clientRepository.findById(clientId).get();
        return  ClientMapper.mapToClientDto(client);
    }

    @Override
    public void updateClient(ClientDto clientDto) {
        Client client = ClientMapper.mapToClient(clientDto);
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client= clientRepository.findById(clientId).get();
        clientRepository.deleteById(client.getId());
    }

    @Override
    public Page<Client> findAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }


}
