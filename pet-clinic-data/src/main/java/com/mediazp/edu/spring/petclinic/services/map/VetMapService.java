/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.map;

import com.mediazp.edu.spring.petclinic.data.Vet;
import com.mediazp.edu.spring.petclinic.services.VetService;

/**
 *
 * @author Vlad
 */
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }
    
}
