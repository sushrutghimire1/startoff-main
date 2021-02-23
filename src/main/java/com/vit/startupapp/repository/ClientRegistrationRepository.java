package com.vit.startupapp.repository;

import com.vit.startupapp.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRegistrationRepository extends CrudRepository<ClientEntity, String> {

    @Query(value="SELECT * FROM client_registrations u WHERE u.username = :username",nativeQuery = true)
    ClientEntity findClientByUsername(@Param("username") String username);
}
