# HalFood — Halal Food Delivery Application

**HalFood** is a full-stack halal food delivery system (Android + backend) created to solve a common problem: most delivery apps don’t provide halal-specific support, so users must manually verify halal compliance. HalFood separates halal meals and halal meat products clearly and focuses on **trust, convenience, and religious compliance**.

## Live Demo (GitHub Pages)
- https://emon-ashraf.github.io/HalFood-Delivery-Application/

## Project Goal
Build a complete halal food delivery platform with:
- **Android mobile client**
- **Secure backend API**
- **Clean architecture principles**

## Key Features
- Verified halal meals from local restaurants
- Fresh halal meats from certified butchers
- Secure authentication (JWT)
- Shop registration and management (restaurant/butcher)
- Product creation and management (dish/meat items)
- Basket (one basket per shop per user)
- Order placement flow

## Target Users (Roles)
- **Customer** (halal food buyer)
- **Vendor** (Restaurant / Butcher)
- **Delivery Personnel**
- **Administrator**

## Core Domain Entities
- User (role-based access)
- Shop (Restaurant or Butcher)
- Item (Dish or Meat product)
- Basket (per shop per user)
- Order (linked to one basket)

## Technologies Used
### Mobile Client
- Kotlin
- Jetpack Compose
- Retrofit2

### Backend
- ASP.NET Core Web API
- Entity Framework Core
- PostgreSQL
- JWT Authentication

## Architecture
### Mobile (MVVM)
- **View:** Jetpack Compose screens  
- **ViewModel:** state & events  
- **Repository/Model:** Retrofit, DataStore, DTO

### Backend (Layered)
- **Presentation:** Controllers  
- **Business Logic:** Services  
- **Data Access:** Repositories  
- **DTOs:** Data Transfer Objects  

## Getting Started (Run Locally)
> Update these commands based on your actual project structure.

### Clone
```bash
git clone https://github.com/Emon-Ashraf/HalFood-Delivery-Application.git
cd HalFood-Delivery-Application
