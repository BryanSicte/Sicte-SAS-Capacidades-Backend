package com.sicte.capacidades.usuarios.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.usuarios.entity.tokens;

@Repository
public interface tokensRepository extends CrudRepository<tokens, String> {

    public Optional<tokens> findByToken(String token);

    public Optional<tokens> findByEmail(String email);

    public Optional<tokens> findByExpiryDate(Date expiryDate);
}
