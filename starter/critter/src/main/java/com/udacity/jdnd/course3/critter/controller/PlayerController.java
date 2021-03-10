package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.dto.PlayerDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.Player;
import com.udacity.jdnd.course3.critter.service.PlayerService;
import com.udacity.jdnd.course3.critter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;
    private final static String TAG_ = "PlayerContoller";

    @PostMapping("/player2")
    public PlayerDTO savePlayer(@RequestBody PlayerDTO pleyerDTO){
        //return userService.saveCustomer(customerDTO);
        log.info("call player2");
        Player player = new Player();
        player.setName(pleyerDTO.getName());
        player.setPhoneNumber(pleyerDTO.getPhoneNumber());
        player.setNotes(pleyerDTO.getNotes());
        log.info("call player2 player=" + player);
        List<Long> petIds = pleyerDTO.getGunIds();//.getPetIds();
        //playerService.savePlayer(player, petIds);
        return getPlayerDTO(playerService.savePlayer(player, petIds));

    }

    @GetMapping("/player")
    public List<PlayerDTO> getAllCustomers(){
        //return playerService.getAllPlayers();
        return null;
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        //return userService.getOwnerByPet(petId);
        return null;
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        //return userService.saveEmployee(employeeDTO);
        return null;
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        //return userService.getEmployee(employeeId);
        return null;
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        //userService.setAvailability(daysAvailable, employeeId);

    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        //return userService.findEmployeesForService(employeeDTO);
        return null;
    }

    private PlayerDTO getPlayerDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setPhoneNumber(player.getPhoneNumber());
        playerDTO.setNotes(player.getNotes());
        List<Long> petIds = player.getGunIds();
        playerDTO.setGunIds(petIds);
        return playerDTO;
    }

    private static PlayerDTO convertEntityToCustomerDTO(Player customer) {
        PlayerDTO customerDTO = new PlayerDTO();
        BeanUtils.copyProperties(customer, customerDTO);

        if (customer.getGunIds() != null && customer.getGunIds().size() > 0) {
            customerDTO.setGunIds(customer.getGunIds());
        }
        return customerDTO;
    }

}
