package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getAllByDaysAvailableContains(DayOfWeek dayOfWeek);
    List<Employee> findEmployeeByIds(List<Long> employeeIds);
    List<Employee> findEmployeeIn(List<Long> employeeIds);
}
