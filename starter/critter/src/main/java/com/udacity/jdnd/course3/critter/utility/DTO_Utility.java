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


public class DTO_Utility{
//    public static PetDTO convertPetToPetDto(Pet pet) {
//        return new PetDTO(pet.getPet_id(), PetType.valueOf(pet.getType()), pet.getName(), pet.getOwnerId(), pet.getBirthDate(), pet.getNotes());
//    }
//
//    public static Pet convertPetDTO_to_Pet(PetDTO dto){
//        return new Pet(dto.getId(),dto.getType().toString(), dto.getName(), dto.getOwnerId(), dto.getBirthDate(), dto.getNotes() );
//    }
//
//    public static List<PetDTO> convertToPetDtoList(List<Pet> petList) {
//        List<PetDTO> list = new ArrayList<>();
//        for(Pet pet: petList){
//            PetDTO temp = convertPetToPetDto(pet);
//            list.add(temp);
//        }
//        return list;
//    }
//
//    public static List<Pet> convertPetDTO_to_petList(List<PetDTO> petDTOList) {
//        List<Pet> list = new ArrayList<>();
//        for(PetDTO dto: petDTOList){
//            Pet temp = convertPetDTO_to_Pet(dto);
//            list.add(temp);
//        }
//        return list;
//    }
//
//    public static CustomerDTO convertCustomerToCustomerDto(Customer customer) {
//        //CustomerDTO(long id, String name, String phoneNumber, String notes, List<Long> petIds)
//        return new CustomerDTO(customer.getId(), customer.getName(), customer.getPhoneNumber(), customer.getNotes(), customer.getPetIds());
//    }
//
//    public static Customer convertCustomerDTO_to_Customer(CustomerDTO dto){
//        //Long id, String name, String phoneNumber, String notes, List<Long> petIds
//        return new Customer(dto.getId(), dto.getName(), dto.getPhoneNumber(), dto.getNotes(), dto.getPetIds() );
//    }

//    public static EmployeeDTO convertEmployeeToEmployeeDto(Employee employee) {
//        //long id, String name, Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable) {
//        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSkills(), employee.getDaysAvailable());
//    }
//
//    public static Employee convertEmployeeDTO_to_Employee(EmployeeDTO dto){
//        //Long id, String name, Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable)
//        return new Employee(dto.getId(), dto.getName(), dto.getSkills(), dto.getDaysAvailable());
//    }

//    public static ScheduleDTO convertScheduleToScheduleDto(Schedule schedule) {
//        return new ScheduleDTO(schedule.getId(), schedule.getEmployeeIds(), schedule.getPetIds(), schedule.getDate(), schedule.getActivities());
//    }
//
//    public static Schedule convertScheduleDTO_to_Schedule(Schedule dto){
//        return new Schedule(dto.getId(), dto.getEmployeeIds(), dto.getPetIds(), dto.getDate(), dto.getActivities());
//    }

//    public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> customerList) {
//        List<CustomerDTO> list = new ArrayList<>();
//        for(Customer customer: customerList){
//            CustomerDTO temp = convertCustomerToCustomerDto(customer);
//            list.add(temp);
//        }
//        return list;
//    }
//
//    public static List<Customer> convertCustomerDTO_to_customerList(List<CustomerDTO> customerDTOList) {
//        List<Customer> list = new ArrayList<>();
//        for(CustomerDTO dto: customerDTOList){
//            Customer temp = convertCustomerDTO_to_Customer(dto);
//            list.add(temp);
//        }
//        return list;
//    }

//    public static List<EmployeeDTO> convertToEmployeeDtoList(List<Employee> employeeList) {
//        List<EmployeeDTO> list = new ArrayList<>();
//        for(Employee employee: employeeList){
//            EmployeeDTO temp = convertEmployeeToEmployeeDto(employee);
//            list.add(temp);
//        }
//        return list;
//    }
//
//    public static List<Employee> convertEmployeeDTO_to_employeeList(List<EmployeeDTO> employeeDTOList) {
//        List<Employee> list = new ArrayList<>();
//        for(EmployeeDTO dto: employeeDTOList){
//            Employee temp = convertEmployeeDTO_to_Employee(dto);
//            list.add(temp);
//        }
//        return list;
//    }

}
