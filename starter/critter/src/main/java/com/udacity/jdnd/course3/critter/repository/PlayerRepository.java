package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
