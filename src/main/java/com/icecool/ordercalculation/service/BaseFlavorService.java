package com.icecool.ordercalculation.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icecool.ordercalculation.model.BaseFlavor;
import com.icecool.ordercalculation.repository.BaseFlavorRepository;

@Service
public class BaseFlavorService {

	@Autowired
	private BaseFlavorRepository baseFlavorRepository;
	
	public List<BaseFlavor> getAllBaseFlavors(){
		return baseFlavorRepository.findAll();
	}
}
