# Expense Tracker – Backend

Backend service for an expense-sharing application that manages groups, users, expenses, and aggregated debts.

Exposes RESTful CRUD APIs and implements transactional business logic to ensure data consistency when creating or deleting groups and expenses. Computes net user-wise balances and applies cascading deletes to automatically clean dependent records.

Tech Stack: Java, Spring Boot, Spring Data JPA (Hibernate), MySQL

Features:
- Group and user management
- Expense creation and splitting
- Aggregated debt calculation
- Cascading deletes for relational consistency
