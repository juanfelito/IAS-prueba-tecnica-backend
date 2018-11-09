package com.juanfelipebalcero.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.juanfelipebalcero.backend.models.Zona;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ZonaRepository extends CrudRepository<Zona, Integer> {

}