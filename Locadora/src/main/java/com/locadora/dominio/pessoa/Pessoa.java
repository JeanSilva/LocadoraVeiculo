package com.locadora.dominio.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Table(schema = "SCHEMA_LOCADORA", name = "PESSOA")
@Entity
public class Pessoa implements IPessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	public Pessoa(String nome, String email, String cpf) {
			this.nome = nome;
			this.email = email;
			this.cpf = cpf;
		
	}
	public Pessoa() {
		
	}
	
}
