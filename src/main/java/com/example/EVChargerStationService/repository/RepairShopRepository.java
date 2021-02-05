package com.example.EVChargerStationService.repository;

import com.example.EVChargerStationService.entity.EVStation;
import com.example.EVChargerStationService.entity.RepairShop;
import org.springframework.data.repository.CrudRepository;

public interface RepairShopRepository extends CrudRepository<RepairShop,Long> {
}
