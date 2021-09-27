package app.service;

import app.controller.ExpensesController;
import app.controller.model.FinanceResponse;
import app.controller.model.QueryType;
import app.data.ExpenseRepository;
import app.model.Expense;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class ExpensesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpensesService.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getExpensesBetween(LocalDateTime dateTime1,
                                            LocalDateTime dateTime2,
                                            int page,
                                            int recordsPerPage) {
        return expenseRepository.getExpensesBetween(dateTime1, dateTime2, recordsPerPage, (page - 1) * recordsPerPage);
    }

    public FinanceResponse getExpenses(QueryType type,
                                       Map<String, Object> params,
                                       int page,
                                       int recordsPerPage) {
        FinanceResponse response = new FinanceResponse();
        int offset = (page - 1) * recordsPerPage;
        try {
            Object data = null;
            switch (type) {
                case ALL:
                    data = expenseRepository.getExpensesByPage(recordsPerPage, offset);
                    break;
                case DATE_BETWEEN:
                    LocalDateTime from = LocalDateTime.parse(params.get("from").toString().trim(), FORMATTER);
                    LocalDateTime to = LocalDateTime.parse(params.get("to").toString().trim(), FORMATTER);
                    data = expenseRepository.getExpensesBetween(from, to, recordsPerPage, offset);
                    break;
                case BY_TITLE:
                    String name = params.get("name").toString();
                    data = expenseRepository.getExpensesByTitle(name, recordsPerPage, offset);
                    break;
                case BY_CATEGORY:
                    String category = params.get("category").toString();
                    data = expenseRepository.getExpensesByCategory(category, recordsPerPage, offset);
                    break;
                case CATEGORY_PERCENTAGE:
                    String period = params.get("period").toString();
                    if ("today".equals(period)) {
                        data = expenseRepository.getTodayExpensesCategorySummary();
                    } else if ("month".equals(period)) {
                        data = expenseRepository.getMonthExpensesCategorySummary();
                    } else if ("year".equals(period)) {
                        data = expenseRepository.getYearExpensesCategorySummary();
                    }
                    break;
            }
            response.setTotalRecords(expenseRepository.getTotalExpenses());
            response.setData(data);
            response.setMessage("");
            response.setStatus("success");
            response.setErrorCode("0");
        } catch (Exception e) {
            response.setMessage("Error getting expenses");
            response.setStatus("failed");
            response.setErrorCode("1");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            LOGGER.warn(sw.toString());
        }
        return response;
    }

    public boolean saveExpense(Expense expense) {
        Expense savedExpense = expenseRepository.save(expense);
        return expenseRepository.existsById(savedExpense.getId());
    }

    public boolean deleteExpense(String id) {
        expenseRepository.deleteById(id);
        return !expenseRepository.existsById(id);
    }
}
