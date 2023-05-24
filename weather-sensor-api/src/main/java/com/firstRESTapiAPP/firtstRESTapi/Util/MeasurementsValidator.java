package com.firstRESTapiAPP.firtstRESTapi.Util;

import com.firstRESTapiAPP.firtstRESTapi.models.Measurements;
import com.firstRESTapiAPP.firtstRESTapi.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementsValidator implements Validator {
private final SensorsService sensorsService;

@Autowired
    public MeasurementsValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurements.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurements measurements = (Measurements) target;

        if(sensorsService.findByName(measurements.getSensor().getName()).isEmpty()){
            errors.rejectValue("name","", "Sensor with this Name NOT EXIST");
        }
    }
}
