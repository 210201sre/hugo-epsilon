# Project 1: Inventory & Merchant Bartering System

## Project Description

This is an application for Merchants to store their inventory and barter with each other. This was migrated from a RESTful Javalin web application to a Spring Boot that was deployed on Kubernetes. The application logs were aggregated with FluentD agents that exported to Loki and displayed in a Grafana Dashboard.

## Technologies Used

* Kubernetes
* Maven
* Git
* Log4J
* Java
* PostgreSQL
* Spring Boot
* Spring Data
* AWS RDS
* Grafana
* Loki
* FluentD

## Features

* User (Admin, Merchant) Login/Logout
* Get all users
* Get user by ID
* Register User
* Update User
* Delete User
* Create Inventory
* Get all inventories
* Update inventory items
* Delete inventory by id
* Bartering system

## Usage

* It is suggested to use Postman to take actions
* Login: Send POST request with following path: /merch-app/login
  * Input "username" and "password" in JSON formatting

To-do list:
* Need to display all inventories and inventory items while displaying users
* Need to fully implement restrictions on Merchants
* Restructure Bartering system
