package app.data;

import app.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ExpenseRepository extends JpaRepository<Expense, String> {

    @Query(value = "SELECT * FROM Expenses LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Expense> getExpensesByPage(int limit, int offset);

    @Query(value = "SELECT * FROM Expenses WHERE expense_date BETWEEN ?1 AND ?2 LIMIT ?3 OFFSET ?4", nativeQuery = true)
    List<Expense> getExpensesBetween(LocalDateTime dateTime1, LocalDateTime dateTime2, int limit, int offset);

    @Query(value = "SELECT * FROM Expenses WHERE title = ?1 LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Expense> getExpensesByTitle(String name, int limit, int offset);

    @Query(value = "SELECT * FROM Expenses WHERE category = ?1 LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Expense> getExpensesByCategory(String category, int limit, int offset);

    @Query(value = "SELECT category, SUM(total_amount) as 'total' FROM todays_expenses GROUP BY Category", nativeQuery = true)
    List<Map<String, Object>> getTodayExpensesCategorySummary();

    @Query(value = "SELECT category, SUM(total_amount) as 'total' FROM month_expenses GROUP BY Category", nativeQuery = true)
    List<Map<String, Object>> getMonthExpensesCategorySummary();

    @Query(value = "SELECT category, SUM(total_amount) as 'total' FROM year_expenses GROUP BY Category", nativeQuery = true)
    List<Map<String, Object>> getYearExpensesCategorySummary();

    @Query(value = "SELECT COUNT(*) FROM Expenses", nativeQuery = true)
    int getTotalExpenses();
}
