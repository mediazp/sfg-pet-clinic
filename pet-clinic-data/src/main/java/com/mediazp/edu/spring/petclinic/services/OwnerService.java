/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services;

import com.mediazp.edu.spring.petclinic.data.Owner;
import java.util.Set;

/**
 *
 * @author Vlad
 */
public interface OwnerService {
    
    Owner findByLastName(String lastName); 
    
    Owner findById(Long id);
    
    Owner save(Owner owner);
    
    Set<Owner> findAll();
}
