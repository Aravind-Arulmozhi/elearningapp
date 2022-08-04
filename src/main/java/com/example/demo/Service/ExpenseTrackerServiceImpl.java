package com.example.demo.Service;



import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.ExpenseTrackerRepository;
import com.example.demo.Entity.Expense;
import com.example.demo.Entity.Test;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService {
@Autowired
private ExpenseTrackerRepository expo;
	
@Override
public List<Expense> getAllExpenses() {
	return expo.findAll();
	
}
public List<Expense> readByCategory(String category) {
	return expo.findByCategory(category);
}
	public Expense getExpensefindbyID(Integer id) {
			
			
		Optional<Expense> expense =expo.findById(id);
		if (expense.isPresent())
		{
			return expense.get();
		}
		throw new RuntimeException("Expense is not found " + id );
	}
	
	public void deleteExpenseById(Integer id)
	{
		expo.deleteById(id);
	}
	public Expense saveExpense(Expense expense) {
		return expo.save(expense);
	}

	public Expense updateExpense(Expense expense,int id) {
		Expense existingExpense=getExpensefindbyID(id);
		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
		return expo.save(existingExpense);
//		Test t;
	

}


	

	

}