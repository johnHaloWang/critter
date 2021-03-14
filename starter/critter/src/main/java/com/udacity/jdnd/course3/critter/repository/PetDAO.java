package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.PetRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@Transactional
public class PetDAO {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserRepository userRepository;

    private static final String SELECT_ALL_PETS =
            "select p.id , " +
                    "p.birth_date, " +
                    "p.name, " +
                    "p.notes, " +
                    "p.customer_id, " +
                    "p.type, " +
                    "c.id, " +
                    "c.name, " +
                    "c.notes, " +
                    "c.phone_number " +
                    "from Pet p " +
                    "left outer join Customer c on c.id = p.customer_id";

    private static final String SELECT_ALL_PETS_BY_CUSTOMER_ID =
            "select p.id , " +
                    "p.birth_date, " +
                    "p.name, " +
                    "p.notes, " +
                    "p.customer_id, " +
                    "p.type, " +
                    "c.id, " +
                    "c.name, " +
                    "c.notes, " +
                    "c.phone_number " +
            "from Pet p " +
            "left outer join Customer c on c.id = p.customer_id " +
            "where p.customer_id = :customerId";

    private static final String SELECT_PET_BY_PET_ID =
            "select p.id , " +
                    "p.birth_date, " +
                    "p.name, " +
                    "p.notes, " +
                    "p.customer_id, " +
                    "p.type, " +
                    "c.id, " +
                    "c.name, " +
                    "c.notes, " +
                    "c.phone_number " +
                    "from Pet p " +
                    "left outer join Customer c on c.id = p.customer_id " +
                    "where p.id = :petId";

    private static final String SAVE_STRING_QUERY =
            "INSERT INTO pet" +
            "(birth_date, name, customer_id, type, notes) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_PET_BY_IDS =
            "select p.id , " +
                    "p.birth_date, " +
                    "p.name, " +
                    "p.notes, " +
                    "p.customer_id, " +
                    "p.type, " +
                    "c.id, " +
                    "c.name, " +
                    "c.notes, " +
                    "c.phone_number " +
            "from Pet p " +
            "left outer join Customer c on c.id = p.customer_id " +
            "where p.id in (%s)";

    private static final RowMapper<Pet> petDataRowMapper = new BeanPropertyRowMapper<>(Pet.class);

    public Pet savePet(Pet pet, long ownerId) {
        Customer customer= userRepository.findCustomerById(ownerId);
        pet.setCustomer(customer);
        int status = jdbcTemplate.update(SAVE_STRING_QUERY,new Object[] {pet.getBirthDate(),pet.getName(),ownerId,pet.getType(),pet.getNotes()});
        //id is an issue
        pet.setId(status);
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
        List<Pet> pets = jdbcTemplate.query(String.format(SELECT_PET_BY_IDS, inSql), new PetRowMapper());
        return pets;
    }
}
