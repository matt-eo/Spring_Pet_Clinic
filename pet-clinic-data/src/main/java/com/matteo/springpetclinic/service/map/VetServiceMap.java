package com.matteo.springpetclinic.service.map;

import com.matteo.springpetclinic.model.Speciality;
import com.matteo.springpetclinic.model.Vet;
import com.matteo.springpetclinic.service.SpecialityService;
import com.matteo.springpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialityService specialityService;

  public VetServiceMap(SpecialityService specialityService) {
    this.specialityService = specialityService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(Vet vet) {
    if (vet.getSpecialities().size() > 0){
      vet.getSpecialities().forEach(speciality -> {
        if(speciality.getId() == null){
          Speciality savedSpecialty = specialityService.save(speciality);
          speciality.setId(savedSpecialty.getId());
        }
      });
    }

    return super.save(vet);
  }

  @Override
  public void delete(Vet vet) {
    super.delete(vet);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
