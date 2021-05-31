package com.matteo.springpetclinic.service;

import com.matteo.springpetclinic.model.Owner;
import com.matteo.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

  Pet findById(Long id);

  Pet save(Pet pet);

  Set<Pet> findAll();
}
