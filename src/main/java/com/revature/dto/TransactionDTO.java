package com.revature.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransactionDTO {

	private Integer id;
	private BigDecimal amount;
	
}
