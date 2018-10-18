/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.map;

import com.mediazp.edu.spring.petclinic.model.Owner;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad
 */
public class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Owner owner;
    private final Long ownerId = 1L;
    private final String ownerLastName = "Smith";

    @BeforeEach
    public void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        owner = Owner.builder().id(ownerId).lastName(ownerLastName).build();
        ownerMapService.save(owner);
    }

    @Test
    public void testFindAll() {
        Set<Owner> owners = ownerMapService.findAll();
        Assertions.assertEquals(1, owners.size());
    }

    @Test
    public void testFindById() {
        Owner foundedOwner = ownerMapService.findById(ownerId);
        Assertions.assertEquals(ownerId, foundedOwner.getId());
    }

    @Test
    public void testSaveExistingId() {
        Long id = 2L;
        Owner savedOwner = ownerMapService.save(Owner.builder().id(id).build());
        Assertions.assertEquals(id, savedOwner.getId());
    }

    @Test
    public void testSaveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        Assertions.assertNotNull(savedOwner);
        Assertions.assertNotNull(savedOwner.getId());
    }

    @Test
    public void testDelete() {
        ownerMapService.delete(this.owner);
        Assertions.assertTrue(ownerMapService.findAll().isEmpty());
    }

    @Test
    public void testDeleteById() {
        ownerMapService.deleteById(ownerId);
        Assertions.assertTrue(ownerMapService.findAll().isEmpty());
    }

    @Test
    public void testFindByLastName() {
        Owner foundedOwner = ownerMapService.findByLastName(ownerLastName);
        Assertions.assertNotNull(foundedOwner);
        Assertions.assertEquals(ownerLastName, foundedOwner.getLastName());
    }

    @Test
    public void testFindByLastNameNotFound() {
        Owner foundedOwner = ownerMapService.findByLastName("foo");
        Assertions.assertNull(foundedOwner);
    }
}
