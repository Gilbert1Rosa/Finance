CREATE TABLE Expenses
(
	id             VARCHAR(255),
    title          VARCHAR(45),
	category       VARCHAR(45),
    descr          VARCHAR(45),
    expense_date   DATETIME,
    total_amount   DOUBLE,
    taxes          DOUBLE,
    payment_method VARCHAR(15)
);

ALTER TABLE Expenses
ADD PRIMARY KEY (id);

CREATE VIEW all_expenses
AS
SELECT * FROM Expenses;

CREATE VIEW todays_expenses
AS
SELECT * FROM Expenses WHERE DAY(expense_date) = DAY(current_date());

CREATE VIEW month_expenses
AS
SELECT * FROM Expenses WHERE MONTH(expense_date) = MONTH(current_date());

CREATE VIEW year_expenses
AS
SELECT * FROM Expenses WHERE YEAR(expense_date) = YEAR(current_date());