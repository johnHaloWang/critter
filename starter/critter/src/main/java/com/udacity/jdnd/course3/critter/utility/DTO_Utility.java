package com.udacity.jdnd.course3.critter.utility;

import com.udacity.jdnd.course3.critter.model.dto.PetType;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


public class DTO_Utility{
    public static PetDTO convertPetToPetDto(Pet pet) {
        return new PetDTO(pet.getPet_id(), PetType.valueOf(pet.getType()), pet.getName(), pet.getOwnerId(), pet.getBirthDate(), pet.getNotes());
    }
    public static Pet convertPetDTO_to_Pet(PetDTO dto){
        return new Pet(dto.getId(),dto.getType().toString(), dto.getName(), dto.getOwnerId(), dto.getBirthDate(), dto.getNotes() );
    }

    public static List<PetDTO> convertToPetDtoList(List<Pet> petList) {
        List<PetDTO> list = new ArrayList<>();
        for(Pet pet: petList){
            PetDTO temp = convertPetToPetDto(pet);
            list.add(temp);
        }
        return list;
    }

    public static List<Pet> convertPetDTO_to_petList(List<PetDTO> petDTOList) {
        List<Pet> list = new ArrayList<>();
        for(PetDTO dto: petDTOList){
            Pet temp = convertPetDTO_to_Pet(dto);
            list.add(temp);
        }
        return list;
    }
//    //D = dto
//    //E = entity
//    public static <E, D>  D converEntityToDto(E e) {
//        D d = new D();
//        BeanUtils.copyProperties(e, d);
//        return d;
//    }




}
