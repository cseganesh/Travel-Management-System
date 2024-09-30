# Travel Management System

## Project Description
The **Travel Management System** is a desktop-based Java application designed to streamline the operations of a travel agency. It automates the process of booking travel packages, managing customer details, and organizing tour packages. This system aims to reduce manual tasks traditionally involved in travel bookings and provides a user-friendly interface for both customers and administrators.

The system is structured to handle real-time travel information, package availability, customer bookings, and hotel reservations. It includes a secure login system, and users can recover their passwords through security questions. Admins have full control over managing customers, booking records, and available travel packages.

### Key Features:
- **Streamlined Booking Process**: Allows customers to easily browse and book travel packages.
- **Customer and Hotel Management**: Efficient handling of customer and hotel data.
- **Secure User Authentication**: Login, signup, and password recovery functionalities.
- **Real-time Package and Pricing Information**: Provides up-to-date travel package information.
- **Admin Dashboard**: Full control for admins over customer records, bookings, and packages.

### Advantages:
- Reduces manual processes and paperwork.
- Provides real-time travel information and package pricing.
- User-friendly interface for both customers and administrators.
- Simplifies customer management and hotel reservations.

## Technologies Used
- **Java**: Backend programming and business logic.
- **Swing**: Used for the graphical user interface (GUI).
- **MySQL**: Relational database to store and manage data, including customers and bookings.
- **JDBC (Java Database Connectivity)**: For connecting Java with the MySQL database.
- **SQL**: For creating and managing database tables.

## Specification Requirements

### Hardware Requirements:
- **Processor**: Intel Core i3 or higher.
- **RAM**: Minimum 4GB.
- **Storage**: 500MB of free space.
- **Monitor**: 1024x768 resolution or higher.

### Software Requirements:
- **Operating System**: Windows 10 or higher / Linux-based systems.
- **Java Development Kit (JDK)**: Version 8 or higher.
- **MySQL Server**: Version 5.7 or higher for database management.
- **Java IDE**: IntelliJ IDEA, Eclipse, or NetBeans for running and debugging the project.
- **JDBC Driver**: Required for connecting Java applications with MySQL.

## Installation Instructions

### Step 1: Clone the Repository
- Download or clone the project repository from your preferred source control platform (GitHub, GitLab, etc.).

### Step 2: Database Setup
1. **Install MySQL**:
   - Download and install MySQL server if you haven't already. You can find it [here](https://dev.mysql.com/downloads/mysql/).

2. **Create the Database**:
   - Open the MySQL command line or any SQL client tool (such as MySQL Workbench) and run the following commands to create the database:
     ```sql
     CREATE DATABASE travel_management_system;
     USE travel_management_system;
     ```
   
3. **Import Database Schema**:
   - Use the SQL schema provided in the `/sql` folder of the project to create the necessary tables. You can execute the SQL file using the following command in MySQL:
     ```bash
     mysql -u root -p travel_management_system < path/to/your/sql/file.sql
     ```
     Alternatively, you can use MySQL Workbench or another GUI tool to import the SQL file.

4. **Update Database Credentials**:
   - Open the `Conn.java` file and update the database connection credentials (username, password, and database name) to match your MySQL setup:
     ```java
     c = DriverManager.getConnection("jdbc:mysql:///travel_management_system", "root", "your_password");
     ```

### Step 3: Configure and Run the Application
1. **Open the Project**: Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, or NetBeans).
2. **Ensure MySQL is Running**: Start the MySQL server on your machine.
3. **Run `Splash.java`**: To start the application, run the `Splash.java` file. The splash screen will appear, followed by the login screen.

### Step 4: Login and Testing
- Use the following default credentials to test the application:
  - **Username**: `admin`
  - **Password**: `admin123`

## Screenshots

### 1. **Hotel Management System**
   ![Screenshot 2024-09-29 200616](https://github.com/user-attachments/assets/be9e1130-8288-4297-901e-555ca11dee99)


### 2. **Login**
  ![Screenshot 2024-09-29 200954](https://github.com/user-attachments/assets/004abadf-e686-46cf-b510-cc35cdade860)


### 3. **Signup**
   ![Screenshot 2024-09-29 201235](https://github.com/user-attachments/assets/ac0dfc9c-6e17-416f-9de5-6e4f9f981406)


### 4. **Forgot Password**
  ![Screenshot 2024-09-29 201712](https://github.com/user-attachments/assets/ceae6229-1591-4e0b-9ce2-f0d9aece0b94)


### 5. **Project Opening (Splash Screen)**
  ![Screenshot 2024-09-29 201912](https://github.com/user-attachments/assets/b82d349c-988b-4147-b81a-c89bd3b49ddb)


### 6. **Home (Main Dashboard)**
   ![Screenshot 2024-09-29 202322](https://github.com/user-attachments/assets/d63533ef-5071-4fdd-a92f-6b37363c702b)


### 7. **New Customer**
   ![Screenshot 2024-09-29 202635](https://github.com/user-attachments/assets/e4625490-8bcb-4433-b221-695e37aa57cc)


### 8. **Update Customer**
  ![Screenshot 2024-09-29 202838](https://github.com/user-attachments/assets/a2f786b5-4e57-4eae-a10b-5e759c924e43)


### 9. **Customer Details**
   ![Screenshot 2024-09-29 203043](https://github.com/user-attachments/assets/d42b1ba5-da64-4f30-b24b-c5aaad921ed8)


### 10. **Delete Customer**
   ![Screenshot 2024-09-29 203426](https://github.com/user-attachments/assets/3e0777f4-dbac-45b8-841c-ed9a3708ac7f)


### 11. **Package**
   ![Screenshot 2024-09-29 203624](https://github.com/user-attachments/assets/ffc9149e-da38-4572-a57f-3bac1177f348)

### 12. **Book Package**
![Screenshot 2024-09-29 203721](https://github.com/user-attachments/assets/2db9a65b-a986-4718-bfd1-79f81dc32840)

### 13. **Package View**
![Screenshot 2024-09-29 204047](https://github.com/user-attachments/assets/4db95335-b5e9-4dfc-9db2-044f5befe794)


### 14. **Hotel View**
   ![Screenshot 2024-09-29 204242](https://github.com/user-attachments/assets/e565f457-0758-4223-a3a6-5a0790156aaa)


### 15. **Temple**
  ![Screenshot 2024-09-29 204415](https://github.com/user-attachments/assets/9b44bb13-687b-4db6-9925-c85be9fcb654)


### 16. **Book Hotel**
   ![Screenshot 2024-09-29 204632](https://github.com/user-attachments/assets/0aecb5fd-96a2-4d4b-af37-a636ec3e61a6)


### 17. **View Book**
   ![Screenshot 2024-09-29 210837](https://github.com/user-attachments/assets/d3a8c17e-863f-491c-96f2-8cfadcd6f83b)


### 18. **Payment**
   ![Screenshot 2024-09-29 211110](https://github.com/user-attachments/assets/125b7364-62de-4e13-b541-ddaaf1d138ff)


### 19. **View Payment**
   ![Screenshot 2024-09-29 211336](https://github.com/user-attachments/assets/d663e949-2448-44d9-80c8-d7c9721b2989)


### 20. **About Project**
   ![Screenshot 2024-09-29 211534](https://github.com/user-attachments/assets/8e3079e7-491e-4cf7-b363-0def03dfdb9a)


## Database Structure
- **account**: Stores user credentials and security questions.
- **customer**: Stores customer data, including contact and booking information.
- **bookPackage**: Stores details of travel packages booked by customers.
- **hotel**: Stores hotel details and booking information, including room availability and prices.

## Conclusion
The **Travel Management System** provides a powerful and intuitive solution for managing travel bookings, customer records, and hotel reservations. By automating the travel booking process and providing real-time data, the system enhances efficiency and reduces manual efforts for travel agencies. The secure login system and user-friendly interface ensure a smooth experience for both customers and administrators.

This project leverages Java for backend logic and MySQL for data management, making it a reliable system for small to medium-sized travel agencies. With scalability in mind, this project can be further enhanced with additional features such as payment gateway integration and mobile app support, making it a versatile solution in the travel industry.

### Future Enhancements:
- **Payment Gateway Integration**: Adding support for actual payment services like PayPal or Stripe.
- **Email Notifications**: Automating confirmation emails for bookings.
- **Mobile App Version**: Developing a mobile application for wider accessibility.
