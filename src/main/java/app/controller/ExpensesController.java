package app.controller;

import app.controller.model.FinanceResponse;
import app.controller.model.QueryRequest;
import app.controller.model.QueryType;
import app.model.Expense;
import app.service.ExpensesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping(Values.EXPENSES_BASE_URL)
public class ExpensesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpensesController.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

    @Autowired
    private ExpensesService expensesService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody FinanceResponse getExpensesBetween(
            @RequestBody QueryRequest body
    ) {
        return expensesService.getExpenses(QueryType.getQueryTypeByName(body.getQueryType()), body.getQueryData(),
                                           body.getPage(), body.getRecordsPerPage());
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody FinanceResponse addExpense(
            @RequestBody Expense expense
    ) {
        FinanceResponse response = new FinanceResponse();
        response.setStatus(expensesService.saveExpense(expense) ? "success" : "failed");
        response.setMessage("");
        response.setErrorCode("");
        response.setData(null);
        return response;
    }

    @PatchMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody FinanceResponse updateExpense(
            @RequestBody Expense expense
    ) {
        FinanceResponse response = new FinanceResponse();
        response.setStatus(expensesService.saveExpense(expense) ? "success" : "failed");
        response.setMessage("");
        response.setErrorCode("");
        response.setData(null);
        return response;
    }

    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody FinanceResponse deleteExpense(
            @RequestBody Map<String, Object> deleteData
    ) {
        FinanceResponse response = new FinanceResponse();
        response.setStatus(expensesService.deleteExpense(deleteData.get("id").toString()) ? "success" : "failed");
        response.setMessage("");
        response.setErrorCode("");
        response.setData(null);
        return response;
    }
}
