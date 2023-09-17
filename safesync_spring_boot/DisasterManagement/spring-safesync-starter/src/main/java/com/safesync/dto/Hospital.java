package com.safesync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "hospital")
public class Hospital {
    @Id
    private Integer id;
    private String name;
    private Integer beds;
    private Integer ambulances;
    private Integer icus;
    private Integer doctors;
    private Integer nurses;
}
