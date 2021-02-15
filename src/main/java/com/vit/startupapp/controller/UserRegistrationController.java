package com.vit.startupapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vit.startupapp.controller.objects.UserRegistrationInfo;
import com.vit.startupapp.service.UserRegistrationServiceImpl;
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
@RequestMapping("registrations")
public class UserRegistrationController {

    private final UserRegistrationServiceImpl userRegistrationServiceImpl;

    @Autowired
    public UserRegistrationController(UserRegistrationServiceImpl userRegistrationServiceImpl) {
        this.userRegistrationServiceImpl = userRegistrationServiceImpl;
    }

    @GetMapping("/get-all-registrations")
    public List<UserRegistrationInfo> getAllUsers() {
        return userRegistrationServiceImpl.findAllUsers();
    }

    @GetMapping("/get-user/{id}")
    public UserRegistrationInfo getUserById(@PathVariable(value = "id") String clientId) {
        return userRegistrationServiceImpl.findUserById(clientId);
    }

    @PostMapping("/create-client")
    public UserRegistrationInfo createUser(@RequestBody UserRegistrationInfo clientEntity) {
        return userRegistrationServiceImpl.createNewUser(clientEntity);
    }

    @PutMapping("/update-client/{id}")
    public ResponseEntity<UserRegistrationInfo> updateUser(@PathVariable(value = "id") String userId, @RequestBody UserRegistrationInfo info) {
        return ResponseEntity.ok(userRegistrationServiceImpl.updateUserInfo(info,userId));
    }

    @DeleteMapping("/delete-client/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String employeeId) {
        userRegistrationServiceImpl.deleteUserById(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}