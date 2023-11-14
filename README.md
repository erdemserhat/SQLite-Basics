# CRUD Operations in SQLite: Basic Database Operations

SQLite is a widely used local database management system utilized for performing database operations. CRUD operations represent fundamental operations that manage data within a database.

## 1. Create
Creating Tables (CREATE TABLE):
To create a new table in SQLite, the CREATE TABLE statement is used. For instance:
```sql
CREATE TABLE Users (
    id INTEGER PRIMARY KEY,
    name TEXT,
    age INTEGER
);
```
## 2. Read
Reading Data (SELECT):
To read data in SQLite, the SELECT query is used. * can be used to select all columns or specific columns can be specified. For example:
```sql
SELECT * FROM Users;

```
This query selects all data from the Users table.

## 3. Update
Updating Data (UPDATE):
UPDATE is used to update data that meets specific conditions. For example:
```sql
UPDATE Users SET age = 30 WHERE name = 'John';
```
This query updates the age to 30 for users with the name 'John'.

## 4. Delete
Deleting Data (DELETE):
DELETE is used to delete data that meets specific conditions. For instance:
```sql
DELETE FROM Users WHERE id = 5;
```
This query deletes the user with id 5 from the Users table.

# Example Usage of SQLite CRUD Operations:
```sql
-- Creating a new table
CREATE TABLE Employees (
    id INTEGER PRIMARY KEY,
    name TEXT,
    department TEXT,
    salary REAL
);

-- Inserting data
INSERT INTO Employees (name, department, salary) VALUES ('Alice', 'HR', 50000);
INSERT INTO Employees (name, department, salary) VALUES ('Bob', 'IT', 60000);

-- Reading data
SELECT * FROM Employees;

-- Updating data
UPDATE Employees SET salary = 55000 WHERE name = 'Alice';

-- Deleting data
DELETE FROM Employees WHERE id = 2;
```
These examples illustrate how CRUD operations are performed in SQLite. Each operation uses different SQL statements to modify or query the database structure and data.







