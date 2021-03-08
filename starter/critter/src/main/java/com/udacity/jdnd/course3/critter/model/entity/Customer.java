package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name="customer")
public class Customer extends User{


    @JsonView(Views.Public.class)
    private String phoneNumber;
    @JsonView(Views.Public.class)
    private String notes;

    @OneToMany(mappedBy = "customer")
    @JsonView(Views.Public.class)
    private List<Long> petIds;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
