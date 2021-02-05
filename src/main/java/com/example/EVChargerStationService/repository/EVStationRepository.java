package com.example.EVChargerStationService.repository;

import com.example.EVChargerStationService.entity.EVStation;
import org.springframework.data.repository.CrudRepository;
public interface EVStationRepository extends CrudRepository<EVStation,Long> {
}
