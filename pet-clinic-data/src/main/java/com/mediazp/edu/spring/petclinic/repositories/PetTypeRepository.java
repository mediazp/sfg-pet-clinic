/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.repositories;

import com.mediazp.edu.spring.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Vlad
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long>{
    
}
