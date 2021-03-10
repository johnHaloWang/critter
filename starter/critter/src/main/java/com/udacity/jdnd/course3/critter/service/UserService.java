package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.UserRepository;
import com.udacity.jdnd.course3.critter.utility.DTO_Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository customersRepository;
    @Autowired
    PetRepository petsRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    private final static String TAG_ = "UserService";

    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
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




//    public Customer saveCustomer(Customer customer, List<Long> petIds) {
//        List<Pet> pets = new ArrayList<>();
//        if (petIds != null && !petIds.isEmpty()) {
//
//            pets = petIds.stream().map((petId) -> petsRepository.getOne(petId)).collect(Collectors.toList());
//        }
//        customer.setPets(pets);
//        return userRepository.save(customer);
//        return null;
//    }

//    public CustomerDTO getCusomterById(Long id){
//        Customer temp = userRepository.getCusomterById(id);
//        return DTO_Utility.convertCustomerToCustomerDto(temp);
//    }
//
//    public CustomerDTO updateCustomer(CustomerDTO customerDTO){
//        Customer customer = DTO_Utility.convertCustomerDTO_to_Customer(customerDTO);
//        Customer temp = userRepository.updateCustomer(customer);
//        return DTO_Utility.convertCustomerToCustomerDto(customer);
//    }
//
//    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
//        Customer customer = DTO_Utility.convertCustomerDTO_to_Customer(customerDTO);
//        Customer temp = userRepository.saveCustomer(customer);
//        return DTO_Utility.convertCustomerToCustomerDto(customer);
//    }
//
//    public List<CustomerDTO> getAllCustomers(){
//        List<Customer> list = userRepository.getAllCustomer();
//        return DTO_Utility.convertToCustomerDtoList(list);
//    }
//
//    public CustomerDTO getOwnerByPet(@PathVariable long petId){
//        Customer customer = userRepository.getOwnerByPet(petId);
//        return DTO_Utility.convertCustomerToCustomerDto(customer);
//    }


//    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        Employee employee = DTO_Utility.convertEmployeeDTO_to_Employee(employeeDTO);
//        Employee temp = userRepository.saveEmployee(employee);
//        return DTO_Utility.convertEmployeeToEmployeeDto(temp);
//    }
//
//    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
//        Employee employee = userRepository.getEmployee(employeeId);
//        return DTO_Utility.convertEmployeeToEmployeeDto(employee);
//    }

//    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
//        userRepository.setAvailability(daysAvailable, employeeId);
//    }
//
//    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
//        return null;
//    }
}
