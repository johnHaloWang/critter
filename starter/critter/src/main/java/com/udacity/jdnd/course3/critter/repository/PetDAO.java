package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.helper.PetRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

@Slf4j
@Repository
@Transactional
public class PetDAO {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserRepository userRepository;

    private static final String SELECT_STRING =
            "select pet.id, " +
            "pet.birth_date, " +
            "pet.name, " +
            "pet.notes, " +
            "pet.customer_id, " +
            "pet.type, " +
            "customer.id, " +
            "customer.name, " +
            "customer.notes, " +
            "customer.phone_number " +
            "from pet " +
            "inner join customer ";

    private static final String SELECT_ALL_PETS =
            SELECT_STRING +
            "where customer.id = pet.customer_id";

    private static final String SELECT_ALL_PETS_BY_CUSTOMER_ID =
            SELECT_STRING +
            "where pet.customer_id = :customerId";

    private static final String SELECT_PET_BY_PET_ID =
            SELECT_STRING +
            "where pet.id = :petId";

    private static final String SAVE_STRING_QUERY =
            "INSERT INTO pet" +
            "(birth_date, name, customer_id, type, notes) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_PET_BY_IDS =
            SELECT_STRING +
            "where pet.id in (%s)";

    private static final RowMapper<Pet> petDataRowMapper = new BeanPropertyRowMapper<>(Pet.class);

    public Pet savePet(Pet pet, long ownerId) {
//        Customer customer= userRepository.findCustomerById(ownerId);
//        pet.setCustomer(customer);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection
                            .prepareStatement(SAVE_STRING_QUERY, Statement.RETURN_GENERATED_KEYS);
                    ps.setObject(1, pet.getBirthDate());
                    ps.setObject(2, pet.getName());
                    ps.setObject(3, ownerId);
                    ps.setObject(4, pet.getType());
                    ps.setObject(5, pet.getNotes());
                    return ps;
                }, keyHolder);
        long number = keyHolder.getKey().longValue();
        pet.setId(number);
        return pet;
    }

    public List<Pet> getAllPets(){
        List<Pet> pets = jdbcTemplate.query(SELECT_ALL_PETS, new PetRowMapper());
        return pets;
    }

    public List<Pet> getPetsByCustomerId(long customerId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", customerId);
        List<Pet> pets = namedParameterJdbcTemplate.query(SELECT_ALL_PETS_BY_CUSTOMER_ID, params, new PetRowMapper());
        return pets;
    }

    public Pet getPetById(long petId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("petId", petId);
        Pet pet = namedParameterJdbcTemplate.queryForObject(SELECT_PET_BY_PET_ID, params, new PetRowMapper());
        return pet;
    }

    public List<Pet> findPetsByIds(List<Long> petIds){
        String inSql = String.join(",", Collections.nCopies(petIds.size(), "?"));
        List<Pet> pets = jdbcTemplate.query(String.format(SELECT_PET_BY_IDS, inSql), petIds.toArray(), new PetRowMapper());
        return pets;
    }
}
