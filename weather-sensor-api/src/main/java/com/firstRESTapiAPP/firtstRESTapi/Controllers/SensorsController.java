package com.firstRESTapiAPP.firtstRESTapi.Controllers;

import com.firstRESTapiAPP.firtstRESTapi.Util.SensorErrorResponse;
import com.firstRESTapiAPP.firtstRESTapi.Util.SensorException;
import com.firstRESTapiAPP.firtstRESTapi.Util.SensorValidator;
import com.firstRESTapiAPP.firtstRESTapi.dto.SensorsDTO;
import com.firstRESTapiAPP.firtstRESTapi.models.Sensor;
import com.firstRESTapiAPP.firtstRESTapi.services.SensorsService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.firstRESTapiAPP.firtstRESTapi.Util.ErrorsMethod.returnErrors;

@RequestMapping("/sensors")
@Controller
public class SensorsController {
    private final ModelMapper modelMapper;
    private  final SensorsService sensorsService;
    private  final SensorValidator sensorValidator;

    @Autowired
    public SensorsController(ModelMapper modelMapper, SensorsService sensorsService, SensorValidator sensorValidator) {
        this.modelMapper = modelMapper;
        this.sensorsService = sensorsService;
        this.sensorValidator = sensorValidator;
    }

    private Sensor convertToSensors (SensorsDTO sensorsDTO){
        return modelMapper.map(sensorsDTO, Sensor.class);
    }

    @ResponseBody
    @PostMapping("/registration")
    public ResponseEntity addSensor(@RequestBody @Valid SensorsDTO sensorsDTO, BindingResult bindingResult){
        sensorValidator.validate(convertToSensors(sensorsDTO),bindingResult);

        if(bindingResult.hasErrors()){
            returnErrors(bindingResult);
        }
        sensorsService.save(convertToSensors(sensorsDTO));
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorException e){
        SensorErrorResponse response = new SensorErrorResponse(
                e.getMessage(),System.currentTimeMillis()
        );

        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
