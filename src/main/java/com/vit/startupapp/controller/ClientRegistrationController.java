package com.vit.startupapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vit.startupapp.controller.objects.AuthenticationRequest;
import com.vit.startupapp.controller.objects.ClientRegistrationInfo;
import com.vit.startupapp.service.ClientRegistrationServiceImpl;
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
@RequestMapping("client/registrations")
public class ClientRegistrationController {

    private final ClientRegistrationServiceImpl userRegistrationServiceImpl;

    @Autowired
    public ClientRegistrationController(ClientRegistrationServiceImpl userRegistrationServiceImpl) {
        this.userRegistrationServiceImpl = userRegistrationServiceImpl;
    }

    @GetMapping("/get-all-registrations")
    public List<ClientRegistrationInfo> getAllUsers() {
        return userRegistrationServiceImpl.findAllClients();
    }

    @GetMapping("/get-user/{id}")
    public ClientRegistrationInfo getUserByUserName(@PathVariable(value = "id") String id) {
        return userRegistrationServiceImpl.findClientById(id);
    }

    @PostMapping("/create-client")
    public ClientRegistrationInfo createUser(@RequestBody AuthenticationRequest request) {
        return userRegistrationServiceImpl.createNewClient(request);
    }

    @PutMapping("/update-client/{id}")
    public ResponseEntity<ClientRegistrationInfo> updateUser(@PathVariable(value = "id") String id, @RequestBody ClientRegistrationInfo info) {
        return ResponseEntity.ok(userRegistrationServiceImpl.updateClientInfo(info,id));
    }

    @DeleteMapping("/delete-client/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String id) {
        userRegistrationServiceImpl.deleteClientById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}