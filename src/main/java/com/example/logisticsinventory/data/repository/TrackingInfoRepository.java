package com.example.logisticsinventory.data.repository;

import com.example.logisticsinventory.data.model.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingInfoRepository extends JpaRepository<TrackingInfo,Long> {
}
