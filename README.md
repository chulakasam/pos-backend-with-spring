# POS Backend API with Spring

This API is built to manage core functionalities of a Point of Sale (POS) system, including operations for customers, items, and orders. The API is built using the Spring Framework and follows the RESTful architecture pattern.

## Features

### 1. **Customer Management**
- Add new customers.
- Update existing customer details.
- Delete customers.
- Search for customers by their ID.

### 2. **Item Management**
- Add new items to the inventory.
- Update item details.
- Delete items from the system.
- Search for items by their item code.

### 3. **Order Management**
- Place new orders.
- Update or manage existing orders.

## Endpoints

### **Customer Endpoints**
- **POST**: `/api/v1/customer` - Add a new customer.
- **GET**: `/api/v1/customer/{customerId}` - Search for a customer by their ID.
- **PUT**: `/api/v1/customer/{customerId}` - Update customer details.
- **DELETE**: `/api/v1/customer/{customerId}` - Delete a customer.

### **Item Endpoints**
- **POST**: `/api/v1/item` - Add a new item.
- **GET**: `/api/v1/item/{itemCode}` - Search for an item by its code.
- **PUT**: `/api/v1/item/{itemCode}` - Update item details.
- **DELETE**: `/api/v1/item/{itemCode}` - Delete an item.

### **Order Endpoints**
- **POST**: `/api/v1/order` - Place an order.

## Technologies Used

- **Framework**: Spring Framework
- **Database**: MySQL
- **Dependency Management**: Maven
- **ORM**: Hibernate with JPA
- **Language**: Java
- **Version**: JDK 21
- **Request/Response Format**: JSON

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/chulakasam/pos-backend-api.git

