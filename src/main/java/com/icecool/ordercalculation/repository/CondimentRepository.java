package com.icecool.ordercalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icecool.ordercalculation.model.Condiment;

@Repository
public interface CondimentRepository extends JpaRepository<Condiment, Long> {

}
