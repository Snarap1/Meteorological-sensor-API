package com.firstRESTapiAPP.firtstRESTapi.repositories;

import com.firstRESTapiAPP.firtstRESTapi.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorsRepository  extends JpaRepository<Sensor,Integer> {
   Optional <Sensor> findByName(String name);

}
