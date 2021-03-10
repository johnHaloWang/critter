package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString(includeFieldNames = true)
@Entity
@NoArgsConstructor
@Table(name="pet")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id;

    @JsonView(Views.Public.class)
    private String type;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @ManyToOne(targetEntity = Customer.class, optional = false)
    private Customer customer;

    @JsonView(Views.Public.class)
    private LocalDate birthDate;

    @JsonView(Views.Public.class)
    private String notes;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
//    public Long getPet_id() {
//        return pet_id;
//    }
//
//    public void setPet_id(Long pet_id) {
//        this.pet_id = pet_id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    @JsonView(Views.Public.class)
//    @ManyToOne(fetch = FetchType.LAZY) //targetEntity = Customer.class, optional = false)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = true, updatable = true)
//    private Long ownerId;
//    public Long getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(long ownerId) {
//        this.ownerId = ownerId;
//    }

//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
//
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
//
//    public Pet(Long pet_id, String type, String name, long ownerId, LocalDate birthDate, String notes) {
//        this.pet_id = pet_id;
//        this.type = type;
//        this.name = name;
//        this.ownerId = ownerId;
//        this.birthDate = birthDate;
//        this.notes = notes;
//    }
//
//    public Pet(){
//
//    }
}
