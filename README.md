# icecream-order-calculation-system-backend

## Implemented and tested functionality. 

  1. A Java Spring Boot based application with an API with the ability to accept an order from customers.
  2. A Customer can order one or more Ice Creams in a single order. 
  3. The API will respond with the final price of the ice cream order.
  4. A Customer can order an Ice Cream with a Base flavor and a container. 
  5. A Customer can order an Ice Cream with a Base flavor, a condiment, and a container.
  6. A Customer can order an Ice Cream without adding a condiment. 
  7. If a Customer requests condiments that are not supported by the base flavor which the customer requests, then the API will return a response stating that the request is invalid (validations implemented as defined in the scenario).
  8. A Customer cannot place an empty order. 
  9. A Customer cannot place an order without a Base flavor. 
  10. A Customer cannot place an order without a container.
  11. The reviewer can manage the base flavors, condiments, cone types and prices using a static JSON file named **manage-data** and all of this data will be saved to the relevant database tables. 
  12. All the orders and the items added to an order including the item combinations (Ice creams and combinations purchased by a customer) will be commited and saved to the relevant database tables. 
