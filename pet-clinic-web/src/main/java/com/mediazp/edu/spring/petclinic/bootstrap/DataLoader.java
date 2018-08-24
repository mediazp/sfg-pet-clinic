/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.bootstrap;

import com.mediazp.edu.spring.petclinic.model.Owner;
import com.mediazp.edu.spring.petclinic.model.Pet;
import com.mediazp.edu.spring.petclinic.model.PetType;
import com.mediazp.edu.spring.petclinic.model.Speciality;
import com.mediazp.edu.spring.petclinic.model.Vet;
import com.mediazp.edu.spring.petclinic.services.OwnerService;
import com.mediazp.edu.spring.petclinic.services.PetTypeService;
import com.mediazp.edu.spring.petclinic.services.VetService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mediazp.edu.spring.petclinic.services.SpecialityService;

/**
 *
 * @author Vlad
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("343241234");

        Pet mikesDog = new Pet();
        mikesDog.setPetType(savedDogPetType);
        mikesDog.setOwner(owner1);
        mikesDog.setBirthDate(LocalDate.now());
        mikesDog.setName("Rosco");
        owner1.getPets().add(mikesDog);

        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("343241234");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setName("JustCat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);
        Owner owner3 = new Owner();
        owner3.setFirstName("Fiona");
        owner3.setLastName(null);
        ownerService.save(owner3);
        System.out.println("Loaded Owners....");
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }

}
