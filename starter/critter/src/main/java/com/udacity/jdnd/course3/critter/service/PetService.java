package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    //save pet
    public Pet save(Pet pet){
        petRepository.save(pet);
        return pet;
    }

    //getPet
    public Pet getPet(Long id){
        return petRepository.getOne(id);
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(Long id){
        return petRepository.findPetsByOwnerId(id);
    }
}
