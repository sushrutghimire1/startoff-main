package com.vit.startupapp.service;

import com.vit.startupapp.controller.converters.ClientInfoConverter;
import com.vit.startupapp.controller.objects.AuthenticationRequest;
import com.vit.startupapp.controller.objects.ClientRegistrationInfo;
import com.vit.startupapp.helperutils.HelperUtils;
import com.vit.startupapp.repository.ClientRegistrationRepository;
import com.vit.startupapp.repository.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientRegistrationServiceImpl implements ClientRegistrationService {

    private final ClientRegistrationRepository clientRegistrationRepository;


    @Autowired
    public ClientRegistrationServiceImpl(ClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @Override
    public ClientRegistrationInfo findClientById(String id) {
        Optional<ClientEntity> clientEntityOptional = this.clientRegistrationRepository.findById(id);
        return ClientInfoConverter.toClientInfo(clientEntityOptional.get());
    }

    @Override
    public List<ClientRegistrationInfo> findAllClients() {
        List<ClientEntity> clients = (List<ClientEntity>) this.clientRegistrationRepository.findAll();
        List<ClientRegistrationInfo> infos = new ArrayList<>();
        clients.forEach(client -> {
            infos.add(ClientInfoConverter.toClientInfo(client));
        });
        return infos;
    }

    @Override
    public void deleteClientById(String id) {
        clientRegistrationRepository.delete(this.clientRegistrationRepository.findById(id).get());
    }

    @Override
    public ClientRegistrationInfo updateClientInfo(ClientRegistrationInfo info, String id) {
        Optional<ClientEntity> oldEntity = this.clientRegistrationRepository.findById(id);
        if (oldEntity.isPresent()) {
            ClientEntity clientEntity = ClientInfoConverter.toClientEntity(info);
            clientEntity.setId(id);
            clientEntity.setRole("CLIENT");
            clientEntity.setPassword(oldEntity.get().getPassword());
            ClientEntity newClientEntity = this.clientRegistrationRepository.save(clientEntity);
            return ClientInfoConverter.toClientInfo(newClientEntity);
        }
        throw new RuntimeException("old data not found");
    }

    @Override
    public ClientRegistrationInfo createNewClient(AuthenticationRequest request) {
        ClientEntity clientEntity = new ClientEntity();
        if (request.getPassword() != null && request.getUsername() != null) {
            clientEntity.setId(HelperUtils.generateRandomId());
            clientEntity.setUsername(request.getUsername());
            clientEntity.setPassword(request.getPassword());
            clientEntity.setRole("CLIENT");
            clientEntity = this.clientRegistrationRepository.save(clientEntity);
            return ClientInfoConverter.toClientInfo(clientEntity);
        }
        System.out.println("CAME HERE 2");
        return null;
    }
}
