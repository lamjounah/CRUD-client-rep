package com.example.demo7.repository;

import com.example.demo7.dto.ClientDto;
import com.example.demo7.modles.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    //Page<ClientDto> findByNomContains(String key, Pageable pageable);

    Optional<Client> findByName(String url);

    //Page<Client> findByNomContains(String keyword, Pageable pageable);
   // Page<Patient>  findByNomContains(String key , Pageable pageable);

}
