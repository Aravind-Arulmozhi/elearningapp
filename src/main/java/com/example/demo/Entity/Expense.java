package com.example.demo.Entity;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "expense_name")
	@NotBlank(message = "Expense name must not be null")
	@Size(min = 3, message = "Expense name must be atleast 3 characters")
	private String name;
	
	
	private String description;
	
	@Column(name = "expense_amount")
	@NotNull(message = "Expense amount should not be null")
	private BigDecimal amount;
	
	@NotBlank(message = "Category should not be null")
	private String category;
	
	@NotNull(message = "Date must not be null")
	private Date date;
	

}
