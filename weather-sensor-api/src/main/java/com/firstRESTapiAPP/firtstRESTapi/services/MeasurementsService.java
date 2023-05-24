package com.firstRESTapiAPP.firtstRESTapi.services;

import com.firstRESTapiAPP.firtstRESTapi.models.Measurements;
import com.firstRESTapiAPP.firtstRESTapi.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementsService {
    private  final MeasurementsRepository measurementsRepository;
    private  final  SensorsService sensorsService;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsService sensorsService) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsService = sensorsService;
    }

    public List<Measurements> getAll(){
        return measurementsRepository.findAll();
    }

    public  int countRainyDays(){
        return  measurementsRepository.countMeasurementsByRainingIsTrue();
    }

    @Transactional
    public  void add(Measurements measurements){
        enrichMeasurement(measurements);
        measurementsRepository.save(measurements);
    }

    @Transactional
    public  void enrichMeasurement(Measurements measurements){
        measurements.setDateTime(LocalDateTime.now());
        measurements.setSensor(sensorsService.findByName(measurements.getSensor().getName()).get());
    }

}
