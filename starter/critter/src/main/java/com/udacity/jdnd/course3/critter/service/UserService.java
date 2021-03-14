package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.*;

@Slf4j
@Service
public class UserService {

    @Autowired
    CustomerRepository customersRepository;
    @Autowired
    PetRepository petsRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;

    private final static String TAG_ = "UserService";

    public List<Customer> getAllCustomers() {
        //return customersRepository.findAll();
        return userRepository.getAllCustomers();
    }

    public Customer getCustomerByPetId(long petId) {
        return petsRepository.getOne(petId).getCustomer();
    }

    public Customer saveCustomer(Customer customer, List<Long> petIds) {
        List<Pet> pets = new ArrayList<>();
        if(!CollectionUtils.isEmpty(petIds)){
            for(Long i:petIds){
                Pet temp = petsRepository.getOne(i);
                customer.insertPet(temp);
            }
        }else{
            customer.setPets(pets);
        }
        return customersRepository.save(customer);
    }

    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee getEmployee(@PathVariable long employeeId) {
        return employeeRepository.getOne(employeeId);
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }

    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeDTO) {
        DayOfWeek target = employeeDTO.getDate().getDayOfWeek();
        Set<EmployeeSkill> skillSet = employeeDTO.getSkills();
        List<Employee> list = employeeRepository.getAllByDaysAvailableContains(target);
        List<Employee> newList = new ArrayList<>();
        for(Employee e: list){
            if(e.getSkills().containsAll(skillSet)){
                newList.add(e);
            }
        }
        return newList;
    }

    public List<Employee> findEmployeesByIds(List<Long> employeeIds){
        return employeeRepository.findByIdIn(employeeIds);
    }

    public Employee findEmployeeById(Long employeeId){
        return employeeRepository.getOne(employeeId);
    }
}
