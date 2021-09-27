package app.controller;

import app.model.Expense;
import app.service.ExpensesService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ExpensesController.class)
public class ExpensesControllerIntegrationTest {
/*
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpensesService expensesService;

    private List<Expense> mockExpenses;

    private String expenseJson = "";

    @BeforeAll
    public void preload() {
        mockExpenses = Arrays.asList(
             new Expense.Builder().create().get()
        );
    }

    @Test
    public void getExpensesBetweenDatesTest() throws Exception {
        LocalDateTime date1 = LocalDateTime.parse("20210614 00:00:00", FORMATTER);
        LocalDateTime date2 = LocalDateTime.parse("20210915 00:00:00", FORMATTER);
        String expectedResponse = "";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/finance/expenses")
                .accept(MediaType.APPLICATION_JSON);
        Mockito.when(
                expensesService.getExpensesBetween(date1, date2)
        ).thenReturn(mockExpenses);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    }
 */
}
