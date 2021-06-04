package com.matteo.springpetclinic.service.jpadata;

import com.matteo.springpetclinic.model.Vet;
import com.matteo.springpetclinic.repository.VetRepository;
import com.matteo.springpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetServiceJpaImpl implements VetService {

  private final VetRepository vetRepository;

  public VetServiceJpaImpl(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  /*
  TODO: Refactor delete and find methods to handle null values more elegantly
   */

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet findById(Long id) {
    return vetRepository.findById(id).orElse(null);
  }

  @Override
  public Vet save(Vet vet) {
    return vetRepository.save(vet);
  }

  @Override
  public void delete(Vet vet) {
    vetRepository.delete(vet);
  }

  @Override
  public void deleteById(Long id) {
    vetRepository.deleteById(id);
  }
}
