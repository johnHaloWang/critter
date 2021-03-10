package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Gun;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.Player;
import com.udacity.jdnd.course3.critter.repository.GunRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.PlayerRepository;
import com.udacity.jdnd.course3.critter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GunService {

    @Autowired
    GunRepository gunRepository;
    @Autowired
    private PlayerRepository playerRepository;

    private final static String TAG_ = "GunService";

    public List<Gun> getAllGuns() {
        return gunRepository.findAll();
    }

    public List<Gun> getPetsByCustomerId(long customerId) {
        //return petsRepository.getAllByCustomerId(customerId);
        return gunRepository.findGunsByOwnerId(customerId);
    }

    public Gun getGunById(long petId) {
        return gunRepository.getOne(petId);
    }

    public Gun saveGun(Gun gun, long ownerId) {
        Player player = playerRepository.getOne(ownerId);
        gun.setOwnerId(ownerId);
        gun = gunRepository.save(gun);
        player.insertGun(gun.getGun_id());
        playerRepository.save(player);
        return gun;
    }
}
