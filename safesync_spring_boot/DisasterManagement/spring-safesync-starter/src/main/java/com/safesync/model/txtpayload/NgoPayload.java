package com.safesync.model.txtpayload;

import com.safesync.dto.Hospital;
import com.safesync.dto.Ngo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NgoPayload {
    private String agent;
    private List<Ngo> instances = new ArrayList<>();
}
