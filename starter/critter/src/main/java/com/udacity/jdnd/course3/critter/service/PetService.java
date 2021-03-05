package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    private final static String TAG_ = "PetService";

    //save pet
    public Pet save(Pet pet){

        log.info(TAG_ + "-> calling save function with " + pet.toString() );
        return petRepository.save(pet);
    }

    //getPet
    public Pet getPet(Long id){
        log.info(TAG_ + "-> calling getPet function with " + id);
        return petRepository.getOne(id);
    }

    public List<Pet> getPets(){
        log.info(TAG_ + "-> calling getPets function");
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(Long id){
        log.info(TAG_ + "-> calling getPetsByOwner function with ");
        return petRepository.findPetsByOwnerId(id);
    }
}
