package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface UserRepository {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getOwnerByPet(long petId);


    Employee saveEmployee(Employee employee);


    Employee getEmployee(long employeeId);


    void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId);

    List<Employee> findEmployeesForService(EmployeeRequestDTO employee);

}
