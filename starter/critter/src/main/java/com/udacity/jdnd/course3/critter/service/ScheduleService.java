package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
public class ScheduleService {
    @Autowired
    PetDAO petDAO;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    UserRepository userRepository;

    private final static String TAG_ = "ScheduleService";

    public Schedule createSchedule(Schedule dto) {
        return scheduleRepository.save(dto);
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    //public List<Schedule> getScheduleForPet(Pet pet) {
//        return scheduleRepository.getAllByPetsContains(pet);
//    }

    public List<Schedule> getScheduleForPet(long petId) {
        Pet pet = petDAO.getPetById(petId);
        return scheduleRepository.getAllByPetsContains(pet);
        //return scheduleRepository.getAllByPets_id(petId);
    }

    public List<Schedule> getScheduleForEmployee(long employeeId) {
        Employee employee = userRepository.findEmployeeById(employeeId);
        return scheduleRepository.getAllByEmployeesContains(employee);
    }

    public List<Schedule> getScheduleForEmployee(Employee employee) {
        return scheduleRepository.getAllByEmployeesContains(employee);
    }

    public List<Schedule> getScheduleForCustomer(long customerId) {
        Customer customer = userRepository.findCustomerById(customerId);
        List<Pet> pets = customer.getPets();
        return scheduleRepository.getAllByPetsIn(pets);
    }

    public List<Schedule> getScheduleForCustomer(List<Pet> pets) {
        return scheduleRepository.getAllByPetsIn(pets);
    }


}
