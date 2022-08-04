package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Expense;

@Repository
public interface ExpenseTrackerRepository extends  JpaRepository<Expense,Integer>{


	List<Expense> findByCategory(String category);

}
