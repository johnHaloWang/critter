package com.udacity.jdnd.course3.critter.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(includeFieldNames = true)
public class PlayerDTO {
    private Long player_id;
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Long> gunIds;

    public PlayerDTO(){

    }

    public PlayerDTO(Long player_id, String name, String phoneNumber, String notes, List<Long> gunIds) {
        this.player_id = player_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.gunIds = gunIds;
    }

    public Long getId() {
        return player_id;
    }

    public void setId(Long id) {
        this.player_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<Long> getGunIds() {
        return gunIds;
    }

    public void setGunIds(List<Long> gunIds) {
        this.gunIds = gunIds;
    }
}
