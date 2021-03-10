package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name="customer")
//public class Customer extends User implements Serializable {
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;

    @JsonView(Views.Public.class)
    private String phoneNumber;

    @JsonView(Views.Public.class)
    private String notes;

    @OneToMany(targetEntity = Pet.class)
    private List<Pet> pets;

    public void insertPet(Pet pet) {
        pets.add(pet);
    }


    //    @ElementCollection(targetClass = DayOfWeek.class)
//    @CollectionTable(name = "days", joinColumns = @JoinColumn(name = "days_id"))
//    @Column(name = "pet_id", nullable = false)
//    @JsonView(Views.Public.class)
//    @JoinColumn(name = "pet_id")
//    @OneToMany(targetEntity = Pet.class, mappedBy = "owner_id")//, fetch = FetchType.LAZY)//, cascade = CascadeType.ALL)
//    public List<Long> petIds;

//    public Customer(){
//
//    }
//
//    public Customer(String phoneNumber, String notes, List<Long> petIds) {
//        this.phoneNumber = phoneNumber;
//        this.notes = notes;
//        this.petIds = petIds;
//    }
//
//    public Customer(Long id, String name, String phoneNumber, String notes, List<Long> petIds) {
//        super(id, name);
//        this.phoneNumber = phoneNumber;
//        this.notes = notes;
//        this.petIds = petIds;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
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
//    public List<Long> getPetIds() {
//        return petIds;
//    }
//
//    public void setPetIds(List<Long> petIds) {
//        this.petIds = petIds;
//    }
}
