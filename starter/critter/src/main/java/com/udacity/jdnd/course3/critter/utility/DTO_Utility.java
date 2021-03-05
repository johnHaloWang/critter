package com.udacity.jdnd.course3.critter.utility;

import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import org.springframework.beans.BeanUtils;


public class DTO_Utility {
    public static PetDTO convertToPetDto(Pet pet) {
        //return new PetDTO(pet.getPet_id(), PetType.valueOf(pet.getType()), pet.getName(), pet.getOwnerId(), pet.getBirthDate(), pet.getNotes());
        PetDTO dto = new PetDTO();
        BeanUtils.copyProperties(pet, dto);
        return dto;
    }

    public static Pet convertToPet(PetDTO dto){
        //return new Pet(dto.getId(),dto.getType().toString(), dto.getName(), dto.getOwnerId(), dto.getBirthDate(), dto.getNotes() );
        Pet pet = new Pet();
        BeanUtils.copyProperties(dto, pet);
        return pet;
    }



}
