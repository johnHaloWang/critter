package com.udacity.jdnd.course3.critter.utility;

import com.udacity.jdnd.course3.critter.model.dto.*;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DTO_Utility{

    public static EmployeeDTO getEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSkills(employee.getSkills());
        employeeDTO.setDaysAvailable(employee.getDaysAvailable());
        return employeeDTO;
    }

    public static Employee getEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSkills(employeeDTO.getSkills());
        employee.setDaysAvailable(employeeDTO.getDaysAvailable());
        return employee;
    }

    public static PetDTO getPetDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());
        petDTO.setType(PetType.valueOf(pet.getType()));
        petDTO.setOwnerId(pet.getCustomer().getId());
        petDTO.setBirthDate(pet.getBirthDate());
        petDTO.setNotes(pet.getNotes());
        return petDTO;
    }

    public static Pet getPet(PetDTO petDTO){
        Pet pet = new Pet();
        pet.setType(petDTO.getType().toString());
        pet.setName(petDTO.getName());
        pet.setBirthDate(petDTO.getBirthDate());
        pet.setNotes(petDTO.getNotes());
        Customer customer = new Customer();
        customer.setId(petDTO.getOwnerId());
        pet.setCustomer(customer);
        return pet;
    }

    public static List<PetDTO> getPetDTOList(List<Pet> list){
        List<PetDTO> dtoList = new ArrayList<>();
        for(Pet pet: list){
            PetDTO dto = getPetDTO(pet);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public static List<Pet> getPetList(List<PetDTO> list){
        List<Pet> petList = new ArrayList<>();
        for(PetDTO petDTO: list){
            Pet pet = getPet(petDTO);
            petList.add(pet);
        }
        return petList;
    }

    public static Customer getCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setNotes(customerDTO.getNotes());
        return customer;
    }

    public static CustomerDTO getCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setNotes(customer.getNotes());
        List<Long> petIds = customer.getPets().stream().map(Pet::getId).collect(Collectors.toList());
        customerDTO.setPetIds(petIds);
        return customerDTO;
    }

    public static CustomerDTO convertEntityToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        if (customer.getPets() != null && customer.getPets().size() > 0) {
            List<Long> petIds = new ArrayList<>();
            customer.getPets().forEach(pet -> petIds.add(pet.getId()));
            customerDTO.setPetIds(petIds);
        }
        return customerDTO;
    }

    public static List<CustomerDTO> getCustomerDTOList(List<Customer> list){
        List<CustomerDTO> dtoList = new ArrayList<>();
        for(Customer customer: list){
            CustomerDTO dto = getCustomerDTO(customer);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public static List<EmployeeDTO> getEmployeeDTOList(List<Employee> employeeList){
        List<EmployeeDTO> list = new ArrayList<>();
        for(Employee e: employeeList){
            list.add(getEmployeeDTO(e));
        }
        return list;
    }

    public static ScheduleDTO getScheduleDTO(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setDate(schedule.getDate());
        scheduleDTO.setActivities(schedule.getActivities());
        List<Long> employeesIds = new ArrayList<>();
        List<Long> petsIds = new ArrayList<>();

        List<Employee> employees = schedule.getEmployees();
        List<Pet> pets = schedule.getPets();
        for(Employee e: employees){
            employeesIds.add(e.getId());
        }
        for(Pet p: pets){
            petsIds.add(p.getId());
        }
        scheduleDTO.setPetIds(petsIds);
        scheduleDTO.setEmployeeIds(employeesIds);
        return scheduleDTO;
    }

    public static List<ScheduleDTO> getScheduleDTOs(List<Schedule> schedules){
        List<ScheduleDTO> list = new ArrayList<>();
        for(Schedule schedule: schedules){
            list.add(getScheduleDTO(schedule));
        }
        return list;
    }


}
