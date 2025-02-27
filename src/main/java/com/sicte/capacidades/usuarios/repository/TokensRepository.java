package com.sicte.capacidades.usuarios.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.usuarios.entity.Tokens;

@Repository
public interface TokensRepository extends CrudRepository<Tokens, String> {

    public Optional<Tokens> findByToken(String token);

    public Optional<Tokens> findByEmail(String email);

    public Optional<Tokens> findByExpiryDate(Date expiryDate);
}
