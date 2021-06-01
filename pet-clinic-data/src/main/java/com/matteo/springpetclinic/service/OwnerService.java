package com.matteo.springpetclinic.service;

import com.matteo.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

}
