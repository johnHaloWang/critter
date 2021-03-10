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
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;

    @JsonView(Views.Public.class)
    private String phoneNumber;

    @JsonView(Views.Public.class)
    private String notes;


//    @JoinTable(name = "player_guns",
//            joinColumns = @JoinColumn(name = "gun_id"),
//            inverseJoinColumns = @JoinColumn(name = "player_id"))
    @JsonView(Views.Public.class)
    @OneToMany(targetEntity = PlayerGuns.class)
    public List<Long> gunIds;

    public void insertGun(Long id){
        gunIds.add(id);
    }
}
