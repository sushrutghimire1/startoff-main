package com.vit.startupapp.service;

import com.vit.startupapp.controller.objects.Authority;
import com.vit.startupapp.repository.ClientRegistrationRepository;
import com.vit.startupapp.repository.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserDetailService implements UserDetailsService {

    private final ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    public UserDetailService(ClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("USERNAME"+username);
        ClientEntity clientEntity = this.clientRegistrationRepository.findClientByUsername(username);
        ArrayList<Authority> roles = new ArrayList<>();
        roles.add(new Authority("CLIENT"));
        return new User(clientEntity.getUsername(), clientEntity.getPassword(), roles);

    }
}
