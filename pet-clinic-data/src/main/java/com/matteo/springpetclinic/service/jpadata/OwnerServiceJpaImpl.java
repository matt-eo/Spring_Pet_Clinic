package com.matteo.springpetclinic.service.jpadata;

import com.matteo.springpetclinic.model.Owner;
import com.matteo.springpetclinic.repository.OwnerRepository;
import com.matteo.springpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class OwnerServiceJpaImpl implements OwnerService {

  private final OwnerRepository ownerRepository;

  public OwnerServiceJpaImpl(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);
    return owners;
  }

  @Override
  public Owner findById(Long id) {
    // TODO return exception if owner can't be found
    return ownerRepository.findById(id).orElse(null);
  }

  @Override
  public Owner save(Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public void delete(Owner owner) {
    // TODO check if Owner exists before delete
    ownerRepository.delete(owner);
  }

  @Override
  public void deleteById(Long id) {
    // TODO check if Owner exists before delete
    ownerRepository.deleteById(id);
  }

  @Override
  public Owner findByLastName(String lastName) {
    // TODO return exception if owner can't be found
    return ownerRepository.findByLastName(lastName).orElse(null);
  }
}
