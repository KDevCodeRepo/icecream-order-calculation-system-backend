package com.icecool.ordercalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icecool.ordercalculation.model.BaseFlavor;

@Repository
public interface BaseFlavorRepository extends JpaRepository<BaseFlavor, Long> {

}
