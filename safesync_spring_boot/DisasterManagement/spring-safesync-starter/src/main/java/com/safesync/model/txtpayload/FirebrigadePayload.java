package com.safesync.model.txtpayload;

import com.safesync.dto.Firebrigade;
import com.safesync.dto.Hospital;
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
public class FirebrigadePayload {
    private String agent;
    private List<Firebrigade> instances = new ArrayList<>();
}
