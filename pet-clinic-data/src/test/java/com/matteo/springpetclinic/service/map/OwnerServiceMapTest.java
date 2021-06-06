package com.matteo.springpetclinic.service.map;

import com.matteo.springpetclinic.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

    }

    @Test
    void itShouldFindAll() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldFindById() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldSave() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldDelete() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldDeleteById() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldFindByLastName() {
        // Given
        // When
        // Then
    }
}