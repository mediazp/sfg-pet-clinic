/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.map;

import com.mediazp.edu.spring.petclinic.model.PetType;
import com.mediazp.edu.spring.petclinic.services.PetTypeService;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vlad
 */

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    
}
