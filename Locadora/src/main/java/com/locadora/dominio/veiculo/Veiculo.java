package com.locadora.dominio.veiculo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(schema = "SCHEMA_LOCADORA", name = "VEICULO")
@Entity
public class Veiculo implements IVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "MARCA")
	private String marca;

	@Column(name = "MODELO")
	private String modelo;

	@Column(name = "COR")
	private String cor;

	@Column(name = "PLACA")
	private String placa;

	@Column(name = "VALOR_DIARIA")
	private BigDecimal valorDiaria;

	public Veiculo(String marca, String modelo, String cor, String placa, BigDecimal valorDiaria) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.valorDiaria = valorDiaria;
	}

}
