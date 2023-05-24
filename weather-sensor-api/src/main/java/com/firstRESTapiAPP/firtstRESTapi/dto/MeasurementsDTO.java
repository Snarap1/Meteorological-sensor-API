package com.firstRESTapiAPP.firtstRESTapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class MeasurementsDTO {

    @Min(value = -100, message = "Value should be more than -100")
    @Max(value = 100, message = " Value should be less than 100")
    double value;

    boolean raining;

    SensorsDTO sensor;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorsDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorsDTO sensor) {
        this.sensor = sensor;
    }
}
