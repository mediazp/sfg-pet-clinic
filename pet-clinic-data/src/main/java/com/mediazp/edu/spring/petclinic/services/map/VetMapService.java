/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.map;

import com.mediazp.edu.spring.petclinic.model.Vet;
import com.mediazp.edu.spring.petclinic.services.SpecialityService;
import com.mediazp.edu.spring.petclinic.services.VetService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vlad
 */
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    specialityService.save(speciality);
                }
            });
        }
        return super.save(object); //To change body of generated methods, choose Tools | Templates.
    }

}
