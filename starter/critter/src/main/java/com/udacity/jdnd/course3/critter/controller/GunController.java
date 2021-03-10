package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.model.dto.GunDTO;
import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.dto.PetType;
import com.udacity.jdnd.course3.critter.model.entity.Gun;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.service.GunService;
import com.udacity.jdnd.course3.critter.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/gun")
public class GunController {

    @Autowired
    GunService gunService;

    @PostMapping("/{ownerId}")
    public GunDTO savePetWithOnwerId(@RequestBody GunDTO gunDTO, @PathVariable Long ownerId) {
        gunDTO.setOwnerId(ownerId);
        gunDTO = saveGun(gunDTO);
        //CustomerDTO customerDTO = userService.getCusomterById(ownerId);
        return gunDTO;
    }

    @PostMapping
    public GunDTO saveGun(@RequestBody GunDTO gunDTO) {

        Gun gun = new Gun();
        gun.setType(gunDTO.getType().toString());
        gun.setName(gunDTO.getName());
        gun.setBirthDate(gunDTO.getBirthDate());
        gun.setNotes(gunDTO.getNotes());
        return getGunDTO(gunService.saveGun(gun, gunDTO.getOwnerId()));
    }

    private GunDTO getGunDTO(Gun gun) {
        GunDTO gunDTO = new GunDTO();
        gunDTO.setId(gun.getGun_id());
        gunDTO.setName(gun.getName());
        gunDTO.setType(PetType.valueOf(gun.getType()));
        gunDTO.setOwnerId(gun.getOwnerId());
        gunDTO.setBirthDate(gun.getBirthDate());
        gunDTO.setNotes(gun.getNotes());
        return gunDTO;
    }
}
