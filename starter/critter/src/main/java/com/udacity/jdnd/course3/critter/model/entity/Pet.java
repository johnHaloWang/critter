package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name="pet")
public class Pet {
    @Id
    @GeneratedValue
    @JsonView(Views.Public.class)
    @Column(name = "id")
    private long pet_id;

    @JsonView(Views.Public.class)
    private String type;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @ManyToOne(targetEntity = User.class)
    private long ownerId;


    @JsonView(Views.Public.class)
    private LocalDate birthDate;

    @JsonView(Views.Public.class)
    private String notes;

    public long getPet_id() {
        return pet_id;
    }

    public void setPet_id(long pet_id) {
        this.pet_id = pet_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Pet(long pet_id, String type, String name, long ownerId, LocalDate birthDate, String notes) {
        this.pet_id = pet_id;
        this.type = type;
        this.name = name;
        this.ownerId = ownerId;
        this.birthDate = birthDate;
        this.notes = notes;
    }

    public Pet(){

    }
}
