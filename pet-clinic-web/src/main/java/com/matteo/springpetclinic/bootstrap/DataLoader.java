package com.matteo.springpetclinic.bootstrap;

import com.matteo.springpetclinic.model.Owner;
import com.matteo.springpetclinic.model.Vet;
import com.matteo.springpetclinic.service.OwnerService;
import com.matteo.springpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setFirstName("Matteo");
    owner1.setLastName("Di Gregorio");
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Simon");
    owner2.setLastName("Cort");
    ownerService.save(owner2);

    Vet vet1 = new Vet();
    vet1.setFirstName("Caroline");
    vet1.setLastName("Summer");
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Karen");
    vet2.setLastName("Marvel");
    vetService.save(vet2);
  }
}
