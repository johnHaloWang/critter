package com.udacity.jdnd.course3.critter.model.entity.helper;

import com.udacity.jdnd.course3.critter.model.dto.PetType;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Slf4j
public class PetRowMapper implements RowMapper<Pet> {

    @Override
    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pet pet = new Pet();
        Customer customer = new Customer();
        pet.setId(rs.getLong("pet.id"));
        pet.setName(rs.getString("pet.name"));
        pet.setType(rs.getString("pet.type"));
        pet.setNotes(rs.getString("pet.notes"));
        if(rs.getDate("pet.birth_date")!=null){
            pet.setBirthDate(rs.getDate("pet.birth_date").toLocalDate());
        }
        customer.setId(rs.getLong("pet.customer_id"));
        customer.setName(rs.getString("customer.name"));
        customer.setNotes(rs.getString("customer.notes"));
        customer.setPhoneNumber(rs.getString("customer.phone_number"));
        pet.setCustomer(customer);
        return pet;
    }
}
