package com.example.RestApiApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MeasurementDTO {
    @Min(value = -100, message = "Value should be greater than -100")
    @Max(value = 100, message = "Value should be less than 100")
    @NotNull(message = "Value should not be empty")
    private Float value;

    @NotNull(message = "Raining value should not be empty")
    private Boolean raining;

    @Valid
    @NotNull(message = "Sensor value should not be empty")
    private SensorDTO sensor;
}
