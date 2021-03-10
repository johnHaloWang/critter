package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.entity.Gun;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GunRepository extends JpaRepository<Gun, Long> {
    List<Gun> findGunsByOwnerId(Long ownerId);
}
