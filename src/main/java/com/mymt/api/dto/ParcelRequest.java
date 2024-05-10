package com.mymt.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParcelRequest {

    @NotNull(message = "Weight is required.")
    @Min(value=0, message = "Minimum weight is 0.")
    private double weight;

    @NotNull(message = "height is required.")
    @Min(value=0, message = "Minimum height is 0.")
    private double height;

    @NotNull(message = "Width is required.")
    @Min(value=0, message = "Minimum width is 0.")
    private double width;

    @NotNull(message = "Length is required.")
    @Min(value=0, message = "Minimum length is 0.")
    private double length;

    private String voucher;
}
