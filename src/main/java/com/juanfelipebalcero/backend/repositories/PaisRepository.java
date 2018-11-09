package com.juanfelipebalcero.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.juanfelipebalcero.backend.models.Pais;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PaisRepository extends CrudRepository<Pais, Integer> {

}