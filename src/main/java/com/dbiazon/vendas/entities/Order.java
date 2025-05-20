package com.dbiazon.vendas.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "TB_ORDER")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
	
	private static final long serialVersionUID = 3094557289022894842L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer code;
	private double basic;
	private double discount;
	
	

	/**
	 * @param codigo
	 * @param basic
	 * @param discount
	 */
	public Order(Integer code, double basic, double discount) {
		this.code = code;
		this.basic = basic;
		this.discount = discount;
	}
	
}
