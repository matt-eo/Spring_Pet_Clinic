package com.matteo.springpetclinic.service;

import com.matteo.springpetclinic.model.Pet;
import com.matteo.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
