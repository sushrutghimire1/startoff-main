package com.vit.startupapp.repository;

import com.vit.startupapp.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<ClientEntity, Integer>{

}
