package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import com.udacity.jdnd.course3.critter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@Slf4j
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;
    private final static String TAG_ = "ScheduleController";

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();

        List<Long> petIds = scheduleDTO.getPetIds();
//        List<Pet> pets = new ArrayList<>();
//        for(Long id: petIds){
//            Pet temp = petService.getPetById(id);
//            petsList.add(temp);
//        }
        List<Pet> pets = petService.findPetsByIds(petIds);
        List<Employee>  employees = userService.findEmployeesByIds(scheduleDTO.getEmployeeIds());

        schedule.setActivities(scheduleDTO.getActivities());
        schedule.setDate(scheduleDTO.getDate());
        schedule.setEmployees(employees);
        schedule.setPets(pets);
        schedule = scheduleService.createSchedule(schedule);

        scheduleDTO.setDate(schedule.getDate());
        scheduleDTO.setActivities(schedule.getActivities());
        List<Long> employeesIds = new ArrayList<>();
        List<Long> petsIds = new ArrayList<>();

        List<Employee> list1 = schedule.getEmployees();
        List<Pet> list2 = schedule.getPets();
        for(Employee e: list1){
            employeesIds.add(e.getId());
        }
        for(Pet p: list2){
            petsIds.add(p.getId());
        }
        scheduleDTO.setPetIds(petsIds);
        scheduleDTO.setEmployeeIds(employeesIds);
        return scheduleDTO;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return null;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        return null;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return null;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        return null;
    }
}
