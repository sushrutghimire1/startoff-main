package com.vit.startupapp.controller.converters;

import com.vit.startupapp.controller.objects.ClientRegistrationInfo;
import com.vit.startupapp.repository.entity.ClientEntity;

public class ClientInfoConverter {
    public static ClientRegistrationInfo toClientInfo(ClientEntity clientEntity){
        ClientRegistrationInfo info= new ClientRegistrationInfo();
        info.setAddress(clientEntity.getAddress());
        info.setUsername(clientEntity.getUsername());
        info.setFirstName(clientEntity.getFirstName());
        info.setLastName(clientEntity.getLastName());
        info.setEmailId(clientEntity.getEmailId());
        info.setPhoneNumber(clientEntity.getPhoneNumber());
        info.setDobAD(clientEntity.getDobAD());
        info.setCity(clientEntity.getCity());
        info.setCountry(clientEntity.getCountry());
        return info;
    }

    public static ClientEntity toClientEntity(ClientRegistrationInfo info){
        ClientEntity entity= new ClientEntity();
        entity.setAddress(info.getAddress());
        entity.setUsername(info.getUsername());
        entity.setFirstName(info.getFirstName());
        entity.setLastName(info.getLastName());
        entity.setEmailId(info.getEmailId());
        entity.setPhoneNumber(info.getPhoneNumber());
        entity.setDobAD(info.getDobAD());
        entity.setCity(info.getCity());
        entity.setCountry(info.getCountry());
        return entity;
    }
}
