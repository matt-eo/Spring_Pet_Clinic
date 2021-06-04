package com.matteo.springpetclinic.service.jpadata;

import com.matteo.springpetclinic.model.Pet;
import com.matteo.springpetclinic.repository.PetRepository;
import com.matteo.springpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class PetServiceJpaImpl implements PetService {

  private final PetRepository petRepository;

  public PetServiceJpaImpl(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  /*
  TODO: Refactor delete and find methods to handle null values more elegantly
   */

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public Pet findById(Long id) {
    return petRepository.findById(id).orElse(null);
  }

  @Override
  public Pet save(Pet pet) {
    return petRepository.save(pet);
  }

  @Override
  public void delete(Pet pet) {
    petRepository.delete(pet);
  }

  @Override
  public void deleteById(Long id) {
    petRepository.deleteById(id);
  }
}
