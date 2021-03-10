package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;

    //    @CollectionTable(name = "employee_employee_skill", joinColumns = @JoinColumn(name = "employee_employee_skill_id"))
    //    @Column(name = "EmployeeSkill")
    @ElementCollection(targetClass = EmployeeSkill.class)
    @Enumerated(EnumType.STRING)
    @JsonView(Views.Public.class)
    private Set<EmployeeSkill> skills;

//    @CollectionTable(name = "days", joinColumns = @JoinColumn(name = "days_id"))
//    @Column(name = "daysOfWeek", nullable = false)
    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    @JsonView(Views.Public.class)
    private Set<DayOfWeek> daysAvailable;

}
