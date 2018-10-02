/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.services.springdatajpa;

import com.mediazp.edu.spring.petclinic.model.Speciality;
import com.mediazp.edu.spring.petclinic.repositories.SpecialityRepository;
import com.mediazp.edu.spring.petclinic.services.SpecialityService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vlad
 */
@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {
    
    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
