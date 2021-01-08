package com.vit.startupapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/get-all-clients")
    public List<ClientEntity> getAllClients(){
        List<ClientEntity> allClientlist = clientRepository.findAll();
        return allClientlist;

    }

    @GetMapping("/get-client/{id}")
    public ClientEntity getClientbyId(@PathVariable(value = "id") Integer clientId)

    {
        ClientEntity clientEntity = clientRepository.findById(clientId).get();

        return clientEntity;
    }

    @PostMapping("/create-client")
    public ClientEntity createCLient(@RequestBody ClientEntity clientEntity) {

        ClientEntity savedClient = clientRepository.save(clientEntity);

        return savedClient;
    }

    @PutMapping("/update-client/{id}")
    public ResponseEntity<ClientEntity> updateClient(@PathVariable(value = "id") Integer clientId,
                                                         @RequestBody ClientEntity clientDetails) {
        ClientEntity clientEntity = clientRepository.findById(clientId).get();

        clientEntity.setEmailId(clientDetails.getEmailId());
        clientEntity.setName(clientDetails.getName());
        clientEntity.setLocation(clientDetails.getLocation());
        final ClientEntity updatedEmployee = clientRepository.save(clientEntity);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete-client/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
    {
        ClientEntity clientEntity = clientRepository.findById(employeeId).get();
        clientRepository.delete(clientEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}