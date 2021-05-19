package com.icecool.ordercalculation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icecool.ordercalculation.model.Order;
import com.icecool.ordercalculation.model.ProductList;
import com.icecool.ordercalculation.service.BaseFlavorService;
import com.icecool.ordercalculation.service.CondimentService;
import com.icecool.ordercalculation.service.ContainerService;
import com.icecool.ordercalculation.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BaseFlavorService baseFlavorService;
	
	@Autowired
	private CondimentService condimentService;
	
	@Autowired
	private ContainerService containerService;
	
	@GetMapping("displayProducts")
	public ProductList displayProducts() {
		
		ProductList productList = new ProductList();
		
		productList.setBaseFlavors(baseFlavorService.getAllBaseFlavors());
		
		productList.setCondiments(condimentService.getAllCondiments());
		
		productList.setContainer(containerService.getAllContainers());
		
		return productList;
	}
	
//	@PostMapping("/addOrder")
//	public String addOrder(@RequestBody Item item) {
//		System.out.print(item);
//		return orderService.saveOrder(item);
//		orderService.saveOrder(item);
	
	@PostMapping("/addOrder")
	public String addOrder(@RequestBody Order order) {
		try {
			String responseMessage = "";
			
			responseMessage = orderService.orderPriceCalculation(order);
			
			return responseMessage;
			
		}catch(Exception e) {
			
			String exception = e.getMessage();
			return exception;
		}
	}
}
