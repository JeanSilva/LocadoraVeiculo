package com.locadora.dominio.veiculo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Table(schema = "SCHEMA_LOCADORA", name = "VEICULO")
@Entity
public class Veiculo implements IVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "MARCA", nullable = false)
	private String marca;

	@Column(name = "MODELO", nullable = false)
	private String modelo;

	@Column(name = "COR", nullable = false)
	private String cor;

	@Column(name = "PLACA", nullable = false)
	private String placa;

	@Column(name = "VALOR_DIARIA", nullable = false)
	private double valorDiaria;

	@Column(name = "DISPONIVEL")
	private boolean disponivel;

	public Veiculo() {

	}

	public Veiculo(String marca, String modelo, String cor, String placa, double valorDiaria) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.valorDiaria = valorDiaria;
		this.disponivel = true;
	}

	public void atualizar(String marca, String modelo, String cor, String placa, double valorDiaria,
			boolean disponivel) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.valorDiaria = valorDiaria;
		this.disponivel = disponivel;

	}

	public void reserva() {
		this.disponivel = false;
	
	}
	public void devolucao() {
		this.disponivel = true;
		
	}

}
