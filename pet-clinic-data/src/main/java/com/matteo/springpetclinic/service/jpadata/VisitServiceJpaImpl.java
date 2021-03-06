package com.matteo.springpetclinic.service.jpadata;

import com.matteo.springpetclinic.model.Visit;
import com.matteo.springpetclinic.repository.VisitRepository;
import com.matteo.springpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class VisitServiceJpaImpl implements VisitService {

  private final VisitRepository visitRepository;

  public VisitServiceJpaImpl(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long id) {
    return visitRepository.findById(id).orElse(null);
  }

  @Override
  public Visit save(Visit visit) {
    return visitRepository.save(visit);
  }

  @Override
  public void delete(Visit visit) {
    visitRepository.delete(visit);
  }

  @Override
  public void deleteById(Long id) {
    visitRepository.deleteById(id);
  }
}
