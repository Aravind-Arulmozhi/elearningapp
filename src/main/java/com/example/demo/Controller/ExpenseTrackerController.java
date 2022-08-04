package com.example.demo.Controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Expense;
import com.example.demo.Service.ExpenseTrackerService;



@RestController
public class ExpenseTrackerController {
@Autowired
//private ExpenseTrackerServiceImpl service;
private ExpenseTrackerService trackerService;

@GetMapping("/expenses")
public List<Expense> getAllExpenses() {
	return trackerService.getAllExpenses();
}


@GetMapping("/expenses/category/{category}")
public List<Expense> getExpensesbyCategory(@PathVariable String category) {
	return trackerService.readByCategory(category);
}


@GetMapping("/expenses/{id}")
public Expense getExpenseById(@PathVariable Integer id){
	return trackerService.getExpensefindbyID(id);
}

@ResponseStatus(value = HttpStatus.NO_CONTENT)
@DeleteMapping("/expenses/{id}")
public void deleteExpensebyID(@PathVariable Integer id){
	trackerService.deleteExpenseById(id);
}
@ResponseStatus(value=HttpStatus.CREATED)
@PostMapping("/create")
public Expense SaveExpense(@Valid @RequestBody Expense expense)
{
	return trackerService.saveExpense(expense);
	
}
@PutMapping("/expenses/{id}")
public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Integer id){
	return trackerService.updateExpense(expense,id);
}

}
