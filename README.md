# POS-BACKEND-Api-with spring

This API is used to manage the core functionalities in a POS system and this is including manage customer,items and orders functions.API is built with using Spring Frame work ,follow REST full architecture pattern.

# features
* Manage customer : Add ,Update ,Delete and Customer search by ID.
* Manage Item: Add ,Update ,Delete and Item search by ID.
* Manage order: Make an order and update place order.

# End points

* Customer end point : 
    POST : api/v1/customer   -> (use to save customer)
    GET  : api/v1/customer/{customerId}  -> (use to search by id customer)
    PUT  : api/v1/customer/{customerId}  ->(use to update customer)
    DELETE  : api/v1/customer/{customerId} ->(use to delete customer)

* Item end point :
  
POST : api/v1/item               -> (use to save item)
GET  : api/v1/item/{itemCode}    -> (use to search by id item)
PUT  : api/v1/item/{itemCode}    ->(use to update item)
DELETE  : api/v1/item/{itemCode} ->(use to delete item)

* Order end point :
POST : api/v1/order -> (use to make a order)

# Technologies 
Framework : Spring Framework
Database  : mySQL
Dependency: Maven
ORM Tool  : hibernate with JPA
Language  : java
version   : JDK 21
Request and Response : JSON

# License
project is licensed through the  LICENSE.txt file.
