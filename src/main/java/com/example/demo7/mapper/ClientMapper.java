package com.example.demo7.mapper;

import com.example.demo7.dto.ClientDto;
import com.example.demo7.modles.Client;

public class ClientMapper {

    public static ClientDto mapToClientDto(Client client){
        ClientDto clientDto=ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .photoUrl(client.getPhotoUrl())
                .comment(client.getComment())
                .joined(client.getJoined())
                .build();
        return clientDto;
    }

    public static Client mapToClient(ClientDto clientDto) {
        Client client = Client.builder()
                .Id(clientDto.getId())
                .comment(clientDto.getComment())
                .joined(clientDto.getJoined())
                .name(clientDto.getName())
                .photoUrl(clientDto.getPhotoUrl())
                .build();
        return client;
    }
}
