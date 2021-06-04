package com.matteo.springpetclinic.service.jpadata;

import com.matteo.springpetclinic.model.PetType;
import com.matteo.springpetclinic.repository.PetTypeRepository;
import com.matteo.springpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeServiceJpaImpl implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  public PetTypeServiceJpaImpl(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  /*
  TODO: Refactor delete and find methods to handle null values more elegantly
   */

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType findById(Long id) {
    return petTypeRepository.findById(id).orElse(null);
  }

  @Override
  public PetType save(PetType petType) {
    return petTypeRepository.save(petType);
  }

  @Override
  public void delete(PetType petType) {
    petTypeRepository.delete(petType);
  }

  @Override
  public void deleteById(Long id) {
    petTypeRepository.deleteById(id);
  }
}
