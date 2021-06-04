package com.matteo.springpetclinic.bootstrap;

import com.matteo.springpetclinic.model.*;
import com.matteo.springpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;
  private final VisitService visitService;

  public DataLoader(
      OwnerService ownerService,
      VetService vetService,
      PetTypeService petTypeService,
      SpecialityService specialityService,
      VisitService visitService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialityService = specialityService;
    this.visitService = visitService;
  }

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();

    if (count == 0) {
      loadData();
    }
  }

  private void loadData() {
    PetType petType1 = new PetType();
    petType1.setName("Dog");
    PetType savedPetType1 = petTypeService.save(petType1);

    PetType petType2 = new PetType();
    petType2.setName("Cat");
    PetType savedPetType2 = petTypeService.save(petType2);

    Owner owner1 = new Owner();
    owner1.setFirstName("Matteo");
    owner1.setLastName("Di Gregorio");
    owner1.setAddress("78 Carleton Road");
    owner1.setCity("London");
    owner1.setTelephone("123456789");

    Pet pet1 = new Pet();
    pet1.setName("Fido");
    pet1.setOwner(owner1);
    pet1.setPetType(savedPetType1);
    pet1.setBirthDate(LocalDate.now());
    owner1.getPets().add(pet1);

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Simon");
    owner2.setLastName("Cort");
    owner2.setAddress("130 Holloway Road");
    owner2.setCity("London");
    owner2.setTelephone("123456789");

    Pet pet2 = new Pet();
    pet2.setName("Romeo");
    pet2.setOwner(owner2);
    pet2.setPetType(savedPetType2);
    pet2.setBirthDate(LocalDate.now());
    owner2.getPets().add(pet2);

    ownerService.save(owner2);

    Speciality speciality1 = new Speciality();
    speciality1.setDescription("Radiology");
    Speciality savedSpeciality1 = specialityService.save(speciality1);

    Speciality speciality2 = new Speciality();
    speciality2.setDescription("Surgery");
    Speciality savedSpeciality2 = specialityService.save(speciality2);

    Speciality speciality3 = new Speciality();
    speciality3.setDescription("Dentistry");
    Speciality savedSpeciality3 = specialityService.save(speciality3);

    Vet vet1 = new Vet();
    vet1.setFirstName("Caroline");
    vet1.setLastName("Summer");
    vet1.getSpecialities().add(savedSpeciality1);
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Karen");
    vet2.setLastName("Marvel");
    vet2.getSpecialities().add(savedSpeciality2);
    vetService.save(vet2);

    Visit visit1 = new Visit();
    visit1.setPet(pet1);
    visit1.setDate(LocalDate.now());
    visit1.setDescription("just a checkup");
    visitService.save(visit1);
  }
}
