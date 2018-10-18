/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.springdatajpa;

import com.mediazp.edu.spring.petclinic.model.Owner;
import com.mediazp.edu.spring.petclinic.repositories.OwnerRepository;
import com.mediazp.edu.spring.petclinic.repositories.PetRepository;
import com.mediazp.edu.spring.petclinic.repositories.PetTypeRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Vlad
 */
@ExtendWith(MockitoExtension.class)
public class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    private Owner owner;
    private final Long OWNER_ID = 1L;
    private final String LAST_NAME = "Smith";

    @BeforeEach
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        ownerSDJpaService = new OwnerSDJpaService(ownerRepository, null, null);
        owner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
    }

    @Test
    public void testFindByLastName() {
        Mockito.when(ownerRepository.findByLastName(ArgumentMatchers.any())).thenReturn(owner);
        Owner foundOwner = ownerSDJpaService.findByLastName(LAST_NAME);
        Assertions.assertEquals(LAST_NAME, foundOwner.getLastName());
        Mockito.verify(ownerRepository).findByLastName(ArgumentMatchers.any());
    }

    @Test
    public void testFindAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        Mockito.when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> result = ownerSDJpaService.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(owners.size(), result.size());
        Mockito.verify(ownerRepository).findAll();
    }

    @Test
    public void testFindById() {
        Mockito.when(ownerRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.of(owner));
        Owner foundOwner = ownerSDJpaService.findById(OWNER_ID);
        Assertions.assertNotNull(foundOwner);
        Assertions.assertEquals(OWNER_ID, foundOwner.getId());
        Mockito.verify(ownerRepository).findById(ArgumentMatchers.any());
    }

    @Test
    public void testFindByIdNotFound() {
        Mockito.when(ownerRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        Owner foundOwner = ownerSDJpaService.findById(OWNER_ID);
        Assertions.assertNull(foundOwner);
        Mockito.verify(ownerRepository).findById(ArgumentMatchers.any());
    }

    @Test
    public void testSave() {
        Mockito.when(ownerRepository.save(ArgumentMatchers.any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(owner);
        Assertions.assertNotNull(savedOwner);
        Assertions.assertEquals(owner, savedOwner);
        Mockito.verify(ownerRepository).save(ArgumentMatchers.any());
    }

    @Test
    public void testDelete() {
        ownerSDJpaService.delete(owner);
        Mockito.verify(ownerRepository).delete(ArgumentMatchers.any());
    }

    @Test
    public void testDeleteById() {
        ownerSDJpaService.deleteById(OWNER_ID);
        Mockito.verify(ownerRepository).deleteById(ArgumentMatchers.anyLong());        
    }

}
