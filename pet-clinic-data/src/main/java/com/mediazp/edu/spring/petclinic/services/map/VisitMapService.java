/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.map;

import com.mediazp.edu.spring.petclinic.model.Visit;
import com.mediazp.edu.spring.petclinic.services.VisitService;

/**
 *
 * @author Vlad
 */
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getId() == null
                || object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(object);
    }

}
