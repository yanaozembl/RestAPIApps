package com.example.RestApiApp.repositories;

import com.example.RestApiApp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
}

