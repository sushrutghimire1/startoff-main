package com.vit.startupapp.repository;

import com.vit.startupapp.repository.entity.ClientEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class UserRegistrationRepositoryImpl implements UserRegistrationRepository{
    @Override
    public List<ClientEntity> findAll() {
        return null;
    }

    @Override
    public List<ClientEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ClientEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ClientEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(ClientEntity entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ClientEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ClientEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ClientEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ClientEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ClientEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ClientEntity> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ClientEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends ClientEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ClientEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ClientEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ClientEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ClientEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ClientEntity> boolean exists(Example<S> example) {
        return false;
    }
}
