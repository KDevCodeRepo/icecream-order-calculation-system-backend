package com.icecool.ordercalculation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icecool.ordercalculation.model.Container;
import com.icecool.ordercalculation.repository.ContainerRepository;

@Service
public class ContainerService {

	@Autowired
	private ContainerRepository containerRepository;
	
	public List<Container> getAllContainers(){
		return containerRepository.findAll();
	}
	
}
