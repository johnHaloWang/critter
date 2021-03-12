package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.entity.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findPetsByCustomerId(Long ownerId);
    List<Pet> findPetsByIdIn(List<Long> petIds);
    //List<Pet> findPetsByCustomerIds(List<Long> employeeIds);
}
