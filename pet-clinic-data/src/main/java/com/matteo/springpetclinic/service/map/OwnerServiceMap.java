package com.matteo.springpetclinic.service.map;

import com.matteo.springpetclinic.model.Owner;
import com.matteo.springpetclinic.service.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long>
    implements CrudService<Owner, Long> {
  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Owner save(Owner owner) {
    return super.save(owner.getId(), owner);
  }

  @Override
  public void delete(Owner owner) {
    super.delete(owner);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
