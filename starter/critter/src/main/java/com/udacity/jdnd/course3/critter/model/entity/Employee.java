package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name="employee")
public class Employee extends User{

    @ElementCollection(targetClass = EmployeeSkill.class)
    @CollectionTable(name = "employee_employee_skill",
            joinColumns = @JoinColumn(name = "id"))
    @Column(name = "EmployeeSkill")
    @JsonView(Views.Public.class)
    private Set<EmployeeSkill> skills;

    @ElementCollection(targetClass = DayOfWeek.class)
    @CollectionTable(name = "days", joinColumns = @JoinColumn(name = "rule_id"))
    @Column(name = "daysOfWeek", nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonView(Views.Public.class)
    private Set<DayOfWeek> daysAvailabe;

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }


}
