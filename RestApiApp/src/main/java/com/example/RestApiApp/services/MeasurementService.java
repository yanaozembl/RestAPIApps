package com.example.RestApiApp.services;

import com.example.RestApiApp.models.Measurement;
import com.example.RestApiApp.repositories.MeasurementsRepository;
import com.example.RestApiApp.util.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MeasurementService {
    private final MeasurementsRepository measurementsRepository;
    private final SensorService sensorService;

    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        String sensorName = measurement.getSensor().getName();
        measurement.setSensor(sensorService.findByName(sensorName)
                .orElseThrow(() -> new ObjectNotFoundException("This sensor isn't registered")));

        measurement.setCreatedAt(LocalDateTime.now());
    }
}
