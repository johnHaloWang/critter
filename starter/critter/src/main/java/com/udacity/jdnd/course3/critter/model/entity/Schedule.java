package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name="schedule")
public class Schedule implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @JsonView(Views.Public.class)
    @ManyToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    @JsonView(Views.Public.class)
    @ManyToMany(targetEntity = Pet.class)
    private List<Pet> pets;

    @ElementCollection(targetClass = EmployeeSkill.class)
    @Enumerated(EnumType.STRING)
    @JsonView(Views.Public.class)
    private Set<EmployeeSkill> activities;

    @JsonView(Views.Public.class)
    private LocalDate date;
}
