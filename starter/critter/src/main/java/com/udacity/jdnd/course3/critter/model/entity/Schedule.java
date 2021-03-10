package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

//@Data
//@ToString(includeFieldNames = true)
//@Entity
//@Table(name="schedule")
public class Schedule {

//    @Id
//    @GeneratedValue
//    @JsonView(Views.Public.class)
//    private long id;
//
////    @JsonView(Views.Public.class)
////    @ManyToMany(targetEntity = Employee.class, mappedBy = "employee_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Long> employeeIds;
//
//    @JsonView(Views.Public.class)
////    @ManyToMany(targetEntity = Pet.class, mappedBy = "pet_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Long> petIds;
//
//    @ElementCollection(targetClass = EmployeeSkill.class)
//    @CollectionTable(name = "schedule_employee_skill", joinColumns = @JoinColumn(name = "schedule_employee_skill_id"))
//    @Column(name = "EmployeeSkill")
//    @Enumerated(EnumType.STRING)
//    @JsonView(Views.Public.class)
//    private Set<EmployeeSkill> activities;
//
//    @JsonView(Views.Public.class)
//    private LocalDate date;
//
//    public Schedule(){
//
//    }
//
//    public Schedule(long id, List<Long> employeeIds, List<Long> petIds, LocalDate date, Set<EmployeeSkill> activities) {
//        this.id = id;
//        this.employeeIds = employeeIds;
//        this.petIds = petIds;
//        this.date = date;
//        this.activities = activities;
//    }
}
