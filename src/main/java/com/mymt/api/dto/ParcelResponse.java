package com.mymt.api.dto;

import com.mymt.model.Parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParcelResponse {

    private byte priority;
    private String status; // rule name
    private String condition;
    private double deliveryCost;

    public ParcelResponse(Parcel parcel) {

    }

    public String getStatus() {
        return this.status;
    }

}
