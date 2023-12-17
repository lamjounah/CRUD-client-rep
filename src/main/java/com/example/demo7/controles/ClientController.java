package com.example.demo7.controles;

import com.example.demo7.dto.ClientDto;
import com.example.demo7.modles.Client;
import com.example.demo7.repository.ClientRepository;
import com.example.demo7.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;
    private ClientRepository clientRepository;



    @GetMapping("/client")
    public String listClients(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "4") int size,
                              Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> pageClients = clientService.findAllClients(pageable);
        model.addAttribute("clients",pageClients.getContent());
        model.addAttribute("pages",new int [pageClients.getTotalPages()]);
        model.addAttribute("curentPage",page);

        return "client-list";
    }
    @GetMapping("client/create")
    public String createClientForm(Model model) {
        Client client  =  new Client();
        model.addAttribute("client", client);
        return "client-create";
    }
    @PostMapping("client/save")
    public String saveClient(@Valid @ModelAttribute("client") Client client
                             , BindingResult bindingResult
                             ) {
         if(bindingResult.hasErrors()) return "client-create";
         clientService.saveClient(client);
         return "redirect:/client";
    }

    @GetMapping("/client/{clientId}/edit")
    public String editClientForm(@PathVariable("clientId") Long clientId, Model model) {
        ClientDto client = clientService.findClientById(clientId);
        model.addAttribute("client", client);
        return "client-edit";
    }

    @PostMapping("/client/{clientId}/edit")
    public String updateClient(@PathVariable("clientId") Long clientId,
                                @Valid @ModelAttribute("client") ClientDto client,
                               BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "4") int size ) {
        if(bindingResult.hasErrors()) return "client-edit";
        client.setId(clientId);
        clientService.updateClient(client);
        return "redirect:/client?page="+page;
    }

    @GetMapping("client/delete")
    public  String deleteClient(Long id ,@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "4") int size
                                                                              ){
         clientService.deleteClient(id);
         return "redirect:/client?page="+page;

    }


}
