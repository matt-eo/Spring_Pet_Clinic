package com.matteo.springpetclinic.service.jpadata;

import com.matteo.springpetclinic.model.Owner;
import com.matteo.springpetclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class OwnerServiceJpaImplTest {

  private OwnerServiceJpaImpl underTest;
  @Mock
  private OwnerRepository ownerRepository;

  private Long ID = 1L;
  private String lastName = "Smith";

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    underTest = new OwnerServiceJpaImpl(ownerRepository);
  }

  @Test
  void itShouldFindAll() {
    // Given
    Set<Owner> ownerSet = Set.of(Owner.builder().id(ID).lastName(lastName).build());
    // When
    when(ownerRepository.findAll()).thenReturn(ownerSet);
    Set<Owner> actual = underTest.findAll();
    // Then
    assertEquals(ownerSet.size(), actual.size());
  }

  @Test
  void itShouldFindById() {
    // Given
    Owner expected = Owner.builder().id(ID).lastName(lastName).build();
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(expected));
    // When
    Owner actual = underTest.findById(ID);
    // Then
    assertNotNull(actual);
    assertEquals(expected.getId(), actual.getId());
  }

  @Test
  void itShouldSave() {
    // Given
    Owner expected = Owner.builder().id(ID).lastName(lastName).build();
    when(ownerRepository.save(any())).thenReturn(expected);
    // When
    Owner actual = underTest.save(expected);
    // Then
    assertThat(expected).usingRecursiveComparison().isEqualTo(actual);
  }

  @Test
  void itShouldDelete() {
    // Given
    // When
    underTest.delete(any());
    // Then
    verify(ownerRepository, times(1)).delete(any());
  }

  @Test
  void itShouldDeleteById() {
    // Given
    // When
    underTest.deleteById(anyLong());
    // Then
    verify(ownerRepository, times(1)).deleteById(anyLong());
  }

  @Test
  void itShouldFindByLastName() {
    // Given
    Owner expected = Owner.builder().id(ID).lastName(lastName).build();
    // When
    when(ownerRepository.findByLastName(lastName)).thenReturn(Optional.of(expected));
    Owner actual = underTest.findByLastName(lastName);
    // Then
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }
}
