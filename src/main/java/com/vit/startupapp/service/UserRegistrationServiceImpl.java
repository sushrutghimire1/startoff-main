package com.vit.startupapp.service;

import com.vit.startupapp.controller.objects.UserRegistrationInfo;
import com.vit.startupapp.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    public UserRegistrationServiceImpl(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    @Override
    public UserRegistrationInfo findUserById(String id) {
        return null;
    }

    @Override
    public List<UserRegistrationInfo> findAllUsers() {
        var users=this.userRegistrationRepository.findAll();
        users.forEach(user->{

        });
        return null;
    }

    @Override
    public String deleteUserById(String id) {
        return null;
    }

    @Override
    public UserRegistrationInfo updateUserInfo(UserRegistrationInfo info, String userId) {
        return null;
    }

    @Override
    public UserRegistrationInfo createNewUser(UserRegistrationInfo info) {
        return null;
    }
}
