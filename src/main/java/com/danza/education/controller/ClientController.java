package com.danza.education.controller;

import com.danza.education.Repository.ClientRepository;
import com.danza.education.entity.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final ClientRepository clientRepo;

    public ClientController(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    @PostMapping("clients")
    public Client createClient(@RequestBody Client newClient){

        return clientRepo.save(newClient);
    }

    @GetMapping("clients")
    public List<Client> getAllClients() {
        return (List<Client>) clientRepo.findAll();
    }

    @GetMapping("clients/{id}")
    public Client one(@PathVariable Long id){
        return clientRepo.findById(id).orElse(null);
    }

    @PutMapping("clients/{id}")
    public Client replaceClient(@RequestBody Client newClient, @PathVariable Long id){
        return clientRepo.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setEmail(newClient.getEmail());
                    return clientRepo.save(client);
                })
                .orElseGet(() -> {
                    return clientRepo.save(newClient);
                });
    }

    @DeleteMapping("clients/{id}")
    void deleteClient(@PathVariable Long id){ clientRepo.deleteById(id);}

}
