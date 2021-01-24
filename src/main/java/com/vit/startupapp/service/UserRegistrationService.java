package com.vit.startupapp.service;

import com.vit.startupapp.controller.objects.UserRegistrationInfo;

import java.util.List;

public interface UserRegistrationService {

    UserRegistrationInfo findUserById(String id);

    List<UserRegistrationInfo> findAllUsers();

    String deleteUserById(String id);

    UserRegistrationInfo updateUserInfo(UserRegistrationInfo info,String userId);

    UserRegistrationInfo createNewUser(UserRegistrationInfo info);
}
