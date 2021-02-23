package com.vit.startupapp.service;

import com.vit.startupapp.controller.objects.AuthenticationRequest;
import com.vit.startupapp.controller.objects.ClientRegistrationInfo;

import java.util.List;

public interface ClientRegistrationService {

    ClientRegistrationInfo findClientById(String id);

    List<ClientRegistrationInfo> findAllClients();

    void deleteClientById(String id);

    ClientRegistrationInfo updateClientInfo(ClientRegistrationInfo info, String id);

    ClientRegistrationInfo createNewClient(AuthenticationRequest request);
}
