package com.matteo.springpetclinic.service.map;

import com.matteo.springpetclinic.model.Owner;
import com.matteo.springpetclinic.model.Pet;
import com.matteo.springpetclinic.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

  private OwnerServiceMap ownerServiceMap;

  private Long ID = 1L;
  private String lastName = "Smith";

  @BeforeEach
  void setUp() {
    ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
    ownerServiceMap.save(Owner.builder().id(ID).lastName(lastName).build());
  }

  @Test
  void itShouldFindAll() {
    // Given
    Set<Owner> owners = ownerServiceMap.findAll();
    // When
    // Then
    assertEquals(1, owners.size());
  }

  @Test
  void itShouldFindById() {
    // Given
    Owner expected = Owner.builder().id(ID).lastName(lastName).build();
    // When
    Owner actual = ownerServiceMap.findById(ID);
    // Then
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void itShouldSaveWithGivenId() {
    // Given
    Owner expected = Owner.builder().id(2L).build();
    // When
    Owner actual = ownerServiceMap.save(expected);
    // Then
    assertEquals(2L, actual.getId());
  }

  @Test
  void itShouldSaveAndGenerateIdWhenNoneProvided() {
    // Given
    Owner expected = Owner.builder().build();
    // When
    Owner actual = ownerServiceMap.save(expected);
    // Then
    assertThat(actual.getId()).isGreaterThan(ID);
  }

  @Test
  void itShouldDelete() {
    // Given
    Owner actual = ownerServiceMap.findById(ID);
    // When
    ownerServiceMap.delete(actual);
    Set<Owner> ownerSet = ownerServiceMap.findAll();
    // Then
    assertEquals(0, ownerSet.size());
  }

  @Test
  void itShouldDeleteById() {
    // Given
    // When
    ownerServiceMap.deleteById(ID);
    Set<Owner> ownerSet = ownerServiceMap.findAll();
    // Then
    assertEquals(0, ownerSet.size());
  }

  @Test
  void itShouldFindByLastName() {
    // Given
    // When
    Owner actual = ownerServiceMap.findByLastName(lastName);
    // Then
    assertNotNull(actual);
    assertEquals(lastName, actual.getLastName());
  }

  @Test
  void itShouldReturnNullWhenLastNameNotFound() {
    // Given
    // When
    Owner actual = ownerServiceMap.findByLastName("foo");
    // Then
    assertNull(actual);
  }
}
