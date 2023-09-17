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
@Document(collection = "police")
public class Police {
    @Id
    Integer id;
    String name;
    Integer personnel;
    Integer patrolVehicle;
    Integer policeVan;
}

