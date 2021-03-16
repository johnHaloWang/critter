package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetDAO;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetDAO petDAO;

    @Autowired
    private PetRepository petRepository;

    private final static String TAG_ = "PetService";

    public List<Pet> getAllPets() {
        //return petDAO.getAllPets();
        return petRepository.findAll();

    }

    public List<Pet> getPetsByCustomerId(long customerId) {
        //return petDAO.getPetsByCustomerId(customerId);
        return petRepository.findPetsByCustomerId(customerId);
    }

    public Pet getPetById(long petId) {
        //return petDAO.getPetById(petId);
        return petRepository.getOne(petId);

    }

    public Pet savePet(Pet pet, long ownerId) {
        Customer customer= userRepository.findCustomerById(ownerId);
        pet.setCustomer(customer);
        //pet = petDAO.savePet(pet, ownerId);
        pet = petRepository.save(pet);
        customer.insertPet(pet);
        userRepository.saveCustomer(customer);
        return pet;
    }

    public List<Pet> findPetsByIds(List<Long> petIds){
        //return petDAO.findPetsByIds(petIds);
        return petRepository.findPetsByIdIn(petIds);
    }


}
