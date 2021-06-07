package com.matteo.springpetclinic.controllers;

import com.matteo.springpetclinic.model.Owner;
import com.matteo.springpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OwnerControllerTest {

  @Mock
  private OwnerService ownerService;
  private OwnerController ownerController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    ownerController = new OwnerController(ownerService);
  }

  @Test
  @Disabled
  void itShouldListOwners() throws Exception {
    // Given
    Owner owner1 = Owner.builder().id(1L).build();
    Owner owner2 = Owner.builder().id(2L).build();
    Set<Owner> ownerSet = Set.of(owner1, owner2);
    // When
    when(ownerService.findAll()).thenReturn(ownerSet);
    // Then
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    mockMvc.perform(get("/owners"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(view().name("owners/index"))
            .andExpect(model().attribute("owners", hasSize(2)));
  }

  @Test
  @Disabled
  void itShouldFindOwners() throws Exception {
    // Given
    // When
    // Then
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk())
            .andExpect(view().name("notimplemented"));
  }
}
