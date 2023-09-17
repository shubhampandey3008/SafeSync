package com.safesync.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "firebrigade")
public class Firebrigade {
    @Id
    Integer id;
    String name;
    Integer personnel;
    Integer fireFightingVehicle;
    Integer rescueVehicle;
    Integer searchAndRescueTeam;
}
