/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.map;

import com.mediazp.edu.spring.petclinic.data.Owner;
import com.mediazp.edu.spring.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vlad
 */
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner value : map.values()) {
            if (value.getLastName().equalsIgnoreCase(lastName)) return value;
        }
        return null;
    }

    
}
