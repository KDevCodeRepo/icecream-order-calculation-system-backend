package com.icecool.ordercalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icecool.ordercalculation.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

}
