/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services;

import com.mediazp.edu.spring.petclinic.data.Owner;

/**
 *
 * @author Vlad
 */
public interface OwnerService extends CrudService<Owner, Long>{
    
    Owner findByLastName(String lastName); 
    
}
