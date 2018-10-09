/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediazp.edu.spring.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Vlad
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="owners")
public class Owner extends Person {
    
    private String address;
    private String city;
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(String address, String city, String telephone, String firstName, String lastName, Long id) {
        super(firstName, lastName, id);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    
}
