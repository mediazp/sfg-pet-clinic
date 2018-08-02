/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.map;

import com.mediazp.edu.spring.petclinic.data.Pet;
import com.mediazp.edu.spring.petclinic.services.PetService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vlad
 */
@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
    
}
