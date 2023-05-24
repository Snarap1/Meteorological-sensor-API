package com.firstRESTapiAPP.firtstRESTapi.Controllers;

import com.firstRESTapiAPP.firtstRESTapi.Util.SensorErrorResponse;
import com.firstRESTapiAPP.firtstRESTapi.Util.SensorException;
import com.firstRESTapiAPP.firtstRESTapi.dto.MeasurementsDTO;
import com.firstRESTapiAPP.firtstRESTapi.models.Measurements;
import com.firstRESTapiAPP.firtstRESTapi.services.MeasurementsService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.firstRESTapiAPP.firtstRESTapi.Util.ErrorsMethod.returnErrors;

@RequestMapping("/measurements")
@RestController
public class MeasurementsController {
    private final MeasurementsService measurementsService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }


    private MeasurementsDTO convertToDTO(Measurements measurements){
       return modelMapper.map(measurements, MeasurementsDTO.class);
    }

    private Measurements convertToMeasurements (MeasurementsDTO measurementsDTO){
        return modelMapper.map(measurementsDTO, Measurements.class);
    }

    @GetMapping("")
    public List<MeasurementsDTO> getMeasurements(){
        return  measurementsService.getAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping("/rainyDaysCount")
    public String rainingDays(){
        return  measurementsService.countRainyDays() +"";
    }

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasure(@RequestBody @Valid MeasurementsDTO measurementsDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            returnErrors(bindingResult);
        }
        Measurements measurementsToAdd = convertToMeasurements(measurementsDTO);
        measurementsService.add(measurementsToAdd);
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
