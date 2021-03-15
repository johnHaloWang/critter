package com.udacity.jdnd.course3.critter.model.entity.helper;

import com.udacity.jdnd.course3.critter.model.dto.PetType;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapper implements RowMapper<Pet> {

    @Override
    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pet pet = new Pet();
        Customer customer = new Customer();
        pet.setId(rs.getLong("p.id"));
        pet.setName(rs.getString("p.name"));
        pet.setType(rs.getString("p.type"));
        pet.setNotes(rs.getString("p.notes"));
        pet.setBirthDate(rs.getTimestamp("p.birth_date").toLocalDateTime().toLocalDate());
        customer.setId(rs.getLong("p.customer_id"));
        customer.setName(rs.getString("c.name"));
        customer.setNotes(rs.getString("c.notes"));
        customer.setPhoneNumber(rs.getString("c.phone_number"));
        pet.setCustomer(customer);
        return pet;
    }
}
