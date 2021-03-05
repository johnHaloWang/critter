package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.utility.DTO_Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@Slf4j
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;
    private final static String TAG_ = "PetContoller";

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        log.info(TAG_ + "-> calling savePet functions");
        Pet input = DTO_Utility.convertPetDTO_to_Pet(petDTO);
        Pet output = petService.save(input);
        PetDTO outDTO = DTO_Utility.convertPetToPetDto(output);
        return outDTO;
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        log.info(TAG_ + "-> calling getPet functions");
        return DTO_Utility.convertPetToPetDto(petService.getPet(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        log.info(TAG_ + "-> calling getPets functions");
        return DTO_Utility.convertToPetDtoList(petService.getPets());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        log.info(TAG_ + "-> calling getPetsByOwner functions " + ownerId);
        return DTO_Utility.convertToPetDtoList(petService.getPetsByOwner(ownerId));
    }
}
