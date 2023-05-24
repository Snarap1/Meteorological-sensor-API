package com.firstRESTapiAPP.firtstRESTapi.models;

import com.firstRESTapiAPP.firtstRESTapi.dto.SensorsDTO;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.Reference;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "Measurements")
public class Measurements implements Serializable {

    @Id
    @Column(name = "measurement_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    @Min(value = -100, message = "Value should be more than -100")
    @Max(value = 100, message = " Value should be less than 100")
    @Column(name = "value")
    double value;

    @Column(name = "isRaining")
    boolean raining;

    @ManyToOne
    @JoinColumn(referencedColumnName = "sensor_name")
    Sensor sensor;

    @Column(name = "DateTime")
    LocalDateTime DateTime;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        DateTime = dateTime;
    }
}
