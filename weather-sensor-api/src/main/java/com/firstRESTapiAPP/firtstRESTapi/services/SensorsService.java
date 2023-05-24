package com.firstRESTapiAPP.firtstRESTapi.services;

import com.firstRESTapiAPP.firtstRESTapi.models.Sensor;
import com.firstRESTapiAPP.firtstRESTapi.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SensorsService {
    private  final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public List<Sensor> findAll (){
        return  sensorsRepository.findAll();
    }

    public Sensor findById(int id){
        Optional<Sensor>  sensors= sensorsRepository.findById(id);
        return sensors.orElse(null);
    }

    public   Optional<Sensor> findByName (String name){
     return sensorsRepository.findByName(name);
    }

    @Transactional
    public  void save(Sensor sensor){
            sensorsRepository.save(sensor);
    }


}
