package com.icecool.ordercalculation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icecool.ordercalculation.model.Condiment;
import com.icecool.ordercalculation.repository.CondimentRepository;

@Service
public class CondimentService {

	@Autowired
	private CondimentRepository condimentRepository;
	
	public List<Condiment> getAllCondiments(){
		return condimentRepository.findAll();
	}
	
}
