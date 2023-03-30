package com.group3.camping_project.entities;

import lombok.Data;

@Data
public class EquipmentResponse {
    private Equipment equipment;
    private String message;

    public EquipmentResponse(Equipment equipment, String message) {
        this.equipment = equipment;
        this.message = message;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
