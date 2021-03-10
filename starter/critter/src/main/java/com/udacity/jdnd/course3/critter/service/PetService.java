package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.UserRepository;
import com.udacity.jdnd.course3.critter.utility.DTO_Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PetService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    private UserRepository customersRepository;

    private final static String TAG_ = "PetService";



    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getPetsByCustomerId(long customerId) {
        //return petsRepository.getAllByCustomerId(customerId);
        return petRepository.findPetsByCustomerId(customerId);
    }

    public Pet getPetById(long petId) {
        return petRepository.getOne(petId);
    }

    public Pet savePet(Pet pet, long ownerId) {
        Customer customer = customersRepository.getOne(ownerId);
        pet.setCustomer(customer);
        pet = petRepository.save(pet);
        customer.insertPet(pet);
        customersRepository.save(customer);
        return pet;
    }


//    //save pet
//    public PetDTO save(PetDTO petDTO){
//        //Pet pet = DTO_Utility.convertPetDTO_to_Pet(petDTO);
//        //log.info(TAG_ + "-> calling save function with " + pet.toString() );
//        //return DTO_Utility.convertPetToPetDto(petRepository.save(pet));
//        return null;
//    }
//
//    //getPet
//    public PetDTO getPet(Long id){
//        log.info(TAG_ + "-> calling getPet function with " + id);
//        //return DTO_Utility.convertPetToPetDto(petRepository.getOne(id));
//        return null;
//    }
//
//    public List<PetDTO> getPets(){
//        log.info(TAG_ + "-> calling getPets function");
//        //return DTO_Utility.convertToPetDtoList(petRepository.findAll());
//        return null;
//    }
//
//    public List<PetDTO> getPetsByOwner(Long id){
//        log.info(TAG_ + "-> calling getPetsByOwner function with ");
//        //return DTO_Utility.convertToPetDtoList(petRepository.findPetsByOwnerId(id));
//        return null;
//    }
}
