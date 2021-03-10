package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@ToString(includeFieldNames = true)
@Entity
@NoArgsConstructor
@Table(name="gun")
public class Gun implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    @Column(name = "gun_id")
    private long gun_id;

    @JsonView(Views.Public.class)
    private String type;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    private LocalDate birthDate;

    @JsonView(Views.Public.class)
    private String notes;

    @JsonView(Views.Public.class)
    @ManyToOne(targetEntity = PlayerGuns.class, optional = false)
    private Long ownerId;

    //@ManyToOne
    //@JoinColumn(name = "player_id")//, insertable = false, updatable = true)
//    @JoinTable(name = "player_guns",
//            joinColumns = @JoinColumn(name = "owner_id"),
//            inverseJoinColumns = @JoinColumn(name = "gun_id"))


    public long getGun_id() {
        return gun_id;
    }

    public void setGun_id(long gun_id) {
        this.gun_id = gun_id;
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

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
