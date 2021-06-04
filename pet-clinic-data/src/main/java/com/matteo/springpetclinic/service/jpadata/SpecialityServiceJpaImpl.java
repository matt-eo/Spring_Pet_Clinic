package com.matteo.springpetclinic.service.jpadata;

import com.matteo.springpetclinic.model.Speciality;
import com.matteo.springpetclinic.repository.SpecialityRepository;
import com.matteo.springpetclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class SpecialityServiceJpaImpl implements SpecialityService {

  private final SpecialityRepository specialityRepository;

  public SpecialityServiceJpaImpl(SpecialityRepository specialityRepository) {
    this.specialityRepository = specialityRepository;
  }

  /*
  TODO: Refactor delete and find methods to handle null values more elegantly
   */

  @Override
  public Set<Speciality> findAll() {
    Set<Speciality> specialities = new HashSet<>();
    specialityRepository.findAll().forEach(specialities::add);
    return specialities;
  }

  @Override
  public Speciality findById(Long id) {
    return specialityRepository.findById(id).orElse(null);
  }

  @Override
  public Speciality save(Speciality speciality) {
    return specialityRepository.save(speciality);
  }

  @Override
  public void delete(Speciality speciality) {
    specialityRepository.delete(speciality);
  }

  @Override
  public void deleteById(Long id) {
    specialityRepository.deleteById(id);
  }
}
