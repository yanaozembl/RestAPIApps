package com.example.RestApiApp.services;

import com.example.RestApiApp.models.Sensor;
import com.example.RestApiApp.repositories.SensorsRepository;
import com.example.RestApiApp.util.ObjectIsAlreadyUsedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SensorService {
    private final SensorsRepository sensorsRepository;

    public List<Sensor> findAll() {
        return sensorsRepository.findAll();
    }

    @Transactional
    public void save(Sensor sensor) {
        if (this.findByName(sensor.getName()).isPresent()) {
            throw new ObjectIsAlreadyUsedException("This name of sensor is already used");
        }

        sensorsRepository.save(sensor);
    }

    public Optional<Sensor> findByName(String name) {
        return sensorsRepository.findByName(name);
    }
}
