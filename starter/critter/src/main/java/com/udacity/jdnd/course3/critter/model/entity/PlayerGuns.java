package com.udacity.jdnd.course3.critter.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.LAZY;

@Data
@ToString(includeFieldNames = true)
@Entity
@Table(name="player_guns")
public class PlayerGuns implements Serializable {

    @EmbeddedId
    private  JoinedPlayerGunId joinedPlayerGunId;

    @ManyToOne(optional = false, fetch = LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(optional = false, fetch = LAZY)
    @MapsId("gunId")
    @JoinColumn(name = "gun_id")
    private Gun gun;

}
