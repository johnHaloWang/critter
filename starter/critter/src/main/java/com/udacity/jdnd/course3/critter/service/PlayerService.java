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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GunRepository gunRepository;

    private final static String TAG_ = "PlayerService";

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerByGunId(long petId) {
        Long id = gunRepository.getOne(petId).getOwnerId();
        return playerRepository.getOne(id);
    }

    public Player savePlayer(Player player, List<Long> gunIds) {
        log.info("call playerService");
        player.setGunIds(gunIds);
        return playerRepository.save(player);
    }
}
