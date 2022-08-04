package com.example.demo.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.Entity.Expense;

public interface ExpenseTrackerService {
	//List<Expense> getAllExpenses();

	List<Expense> getAllExpenses();
	Expense getExpensefindbyID(Integer id);
	void deleteExpenseById(Integer id);
	 Expense saveExpense(Expense expense);
	Expense updateExpense(Expense expense,int id);

	List<Expense> readByCategory(String category);
}
