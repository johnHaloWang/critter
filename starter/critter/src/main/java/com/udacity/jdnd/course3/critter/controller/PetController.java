package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.dto.PetType;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.service.UserService;
import com.udacity.jdnd.course3.critter.utility.DTO_Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@Slf4j
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/{ownerId}")
    public PetDTO savePetWithOnwerId(@RequestBody PetDTO petDTO, @PathVariable Long ownerId) {
        petDTO.setOwnerId(ownerId);
        petDTO = savePet(petDTO);
        return petDTO;
    }

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setType(petDTO.getType().toString());
        pet.setName(petDTO.getName());
        pet.setBirthDate(petDTO.getBirthDate());
        pet.setNotes(petDTO.getNotes());
        return getPetDTO(petService.savePet(pet, petDTO.getOwnerId()));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return getPetDTO(petService.getPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets() {
        List<Pet> pets = petService.getAllPets();
        return pets.stream().map(this::getPetDTO).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> pets = petService.getPetsByCustomerId(ownerId);
        return pets.stream().map(this::getPetDTO).collect(Collectors.toList());
    }

    private PetDTO getPetDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());
        petDTO.setType(PetType.valueOf(pet.getType()));
        petDTO.setOwnerId(pet.getCustomer().getId());
        petDTO.setBirthDate(pet.getBirthDate());
        petDTO.setNotes(pet.getNotes());
        return petDTO;
    }

//    @Autowired
//    PetService petService;
//    @Autowired
//    UserService userService;
//
//    private final static String TAG_ = "PetContoller";

//    @PostMapping("/{ownerId}")
//    public PetDTO savePetWithOnwerId(@RequestBody PetDTO petDTO, @PathVariable Long ownerId) {
//        log.info(TAG_ + "-> calling savePet functions");
//        petDTO.setOwnerId(ownerId);
//        log.info(TAG_ + "-> calling savePet functions2");
//        petDTO = savePet(petDTO);
//        log.info(TAG_ + "-> calling savePet functions3");
//        log.info(TAG_ + "-> calling savePet functions's petDTO: " + petDTO);
//        CustomerDTO customerDTO = userService.getCusomterById(ownerId);
//        log.info(TAG_ + "-> calling savePet functions4");
//        userService.updateCustomer(customerDTO);
//        log.info(TAG_ + "-> calling savePet functions5");
//        return petDTO;
//        return null;
//    }

//    @PostMapping
//    public PetDTO savePet(@RequestBody PetDTO petDTO) {
//        return petService.save(petDTO);


        //Pet input = DTO_Utility.convertPetDTO_to_Pet(petDTO);
        //CustomerDTO customerDTO = userService.getCusomterById(ownerId);


        //List<Long> petList = customerDTO.getPetIds();
        //petList.add(petDTO.getId());

        //Pet output = petService.save(input);
        //PetDTO outDTO = DTO_Utility.convertPetToPetDto(output);
        //return outDTO;
//    }

//    @GetMapping("/{petId}")
//    public PetDTO getPet(@PathVariable long petId) {
//        log.info(TAG_ + "-> calling getPet functions");
//        return petService.getPet(petId);
//    }
//
//    @GetMapping
//    public List<PetDTO> getPets(){
//        log.info(TAG_ + "-> calling getPets functions");
//        return petService.getPets();
//    }
//
//    @GetMapping("/owner/{ownerId}")
//    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
//        log.info(TAG_ + "-> calling getPetsByOwner functions " + ownerId);
//        return petService.getPetsByOwner(ownerId);
//    }
}
