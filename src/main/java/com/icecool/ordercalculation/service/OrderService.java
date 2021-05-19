package com.icecool.ordercalculation.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icecool.ordercalculation.exception.InvalidInputException;
import com.icecool.ordercalculation.model.Condiment;
import com.icecool.ordercalculation.model.Item;
import com.icecool.ordercalculation.model.Order;
import com.icecool.ordercalculation.repository.OrderRepository;

/*
 * Sprinkles - LKR 50 (Available for Raspberry Slushy and Nutty Fruit only)
 * 
 * Toasted Marshmallow - LKR 100 (Available for Raspberry Slushy, Nutty Fruit and Pistachio Delight only)
 * 
 * Toasted Almond Flakes - LKR 150 (Available for Nutty Fruit, Coco Coffee and Pistachio Delight only)
 * 
 * Dash of Peanut butter - LKR 50 per tablespoon of peanut butter (Available for any base flavor)
 * 
 * Oreo Crumbles - LKR 60 per Oreo cookie (Available for any base flavor)
 * 
 * Dried Fruit - Dried Apples - LKR 25, Dried Mango - LKR 30, Dried Apricot - LKR 40, Dried Blueberry - LKR 45
 * (Available for Raspberry Slushy and Nutty Fruit only
*/

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public void validateItem(Item item) throws InvalidInputException {
		
		// First check whether a base flavor is selected.
		// Then check whether a container is selected.
		// Finally check the Base flavor and Condiment combinations. 
		
		if(item.getBaseFlavor() == null) {
			throw new InvalidInputException("Please select a base flavor to proceed.");
		}
		
		else if(item.getContainer() == null) {
			throw new InvalidInputException("Please select a container to proceed.");
		}
		
		// Condiment Validations
		else {
			if(item.getSelectedCondiments() == null) {
				System.out.println("No condiments added, but that's okay.");
			}
			
			else {
				for (Condiment condiment : item.getSelectedCondiments()) {
					if(condiment.getName().equals("Sprinkles")) {
						if(item.getBaseFlavor().getName().equals("Raspberry Slushy") || item.getBaseFlavor().getName().equals("Nutty Fruit")){
							continue;
						}
						else {
							String validateResult = String.format("Sorry, you can't add Sprinkles to %s, but you can try Sprinkles with Raspberry Slushy or Nutty Fruit.", item.getBaseFlavor().getName());
							throw new InvalidInputException(validateResult);
						}
					}
					else if(condiment.getName().equals("Toasted Marshmallow")) {
						if(item.getBaseFlavor().getName().equals("Coco Coffee")){
							String validateResult = String.format("Sorry, you can't add Toasted Marshmallow to %s, but you can try Toasted Marshmallow with any other base flavor that we serve.", item.getBaseFlavor().getName());
							throw new InvalidInputException(validateResult);
						}
						else {
							continue;
						}
					}
					else if(condiment.getName().equals("Toasted Almond Flakes")) {
						if(item.getBaseFlavor().getName().equals("Raspberry Slushy")){
							String validateResult = String.format("Sorry, you can't add Toasted Almond Flakes to %s, but you can try Toasted Almond Flakes with any other base flavor that we serve.", item.getBaseFlavor().getName());
							throw new InvalidInputException(validateResult);
						}
						else {
							continue;
						}
					}
					else if(condiment.getName().equals("Dried Apples") 
							|| condiment.getName().equals("Dried Mango")
							|| condiment.getName().equals("Dried Apricot") 
							|| condiment.getName().equals("Dried Blueberry")) {
						if(item.getBaseFlavor().getName().equals("Raspberry Slushy") || item.getBaseFlavor().getName().equals("Nutty Fruit")){
							continue;
						}
						else {
							String validateResult = String.format("Sorry, can't add %s to %s,but you can try %s with Raspberry Slushy or Nutty Fruit.", condiment.getName(),item.getBaseFlavor().getName(), condiment.getName());
							throw new InvalidInputException(validateResult);
						}
					}
					else {
						continue;
					}
				}
			}
		}
	}
		
	public String orderPriceCalculation(Order order) throws InvalidInputException {
		String totalOrderPrice = "";
		
		// Store the price of the order.
		double orderTotal = 0;
		if(order.getItems() == null) {
			throw new InvalidInputException("Please build an item to proceed.");
		}
		else {
			for(Item item: order.getItems()) {			
				try {
					validateItem(item);
					
					// Hold the price of an item.
					double itemPrice = itemPriceCalculation(item);
					
					// Add the price of an item to the order total price.
					orderTotal += itemPrice;
				
				} catch (Exception e) {
					String exception = e.getMessage();
					return exception;
				}
			}
			//	Format the order total price (orderTotal) to be displayed with two decimal places to the customer.  
			totalOrderPrice = new DecimalFormat("LKR ##.00").format(orderTotal);
			
			// Set the total order price to the "orderTotalPrice" variable declared in the "Order" class, which will be saved to the database table.
			order.setOrderTotalPrice(totalOrderPrice);
			}
			// Save the order to the database.
			orderRepository.save(order);
		
			// Return the order total price to the endpoint to display to the customer. .
			return String.format("The total value of your order is %s. Thank you for shopping with us. Enjoy!",totalOrderPrice);
	}
	
	/* 
	 * This method will be used to calculate the price of each item. The price of each item is composed of the
	 * Base Flavor, Condiments (if added), and the Container.  
	 */
	
	public double itemPriceCalculation(Item item) {
					// The value of the Base Flavor, Condiments, and the Container will be added to this variable.  
					double itemTotal;
					
					// Get the price of the base flavor selected for this item. 
					itemTotal = Double.valueOf(item.getBaseFlavor().getPrice().replace("LKR", "").trim());
					
					/* 
					 * Check whether any condiments are selected. If not added, add "0" to the item price, if condiments are added, add 
					 * the price of each condiment to the item price. 
					 */			
					if(item.getSelectedCondiments() == null) {
						itemTotal += 0.00;
					}
					else {	
						for(Condiment condiment: item.getSelectedCondiments()) {
							itemTotal += Double.valueOf(condiment.getPrice().replace("LKR", "").trim());
							}
					}
					
					// Add the price of the selected container to the item price. 
					itemTotal += Double.valueOf(item.getContainer().getPrice().replace("LKR", "").trim()); 
				
					return itemTotal;
	}
}
