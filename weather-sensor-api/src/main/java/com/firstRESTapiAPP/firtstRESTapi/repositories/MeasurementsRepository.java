package com.firstRESTapiAPP.firtstRESTapi.repositories;

import com.firstRESTapiAPP.firtstRESTapi.models.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementsRepository extends JpaRepository<Measurements, Integer> {
    int countMeasurementsByRainingIsTrue();
}
