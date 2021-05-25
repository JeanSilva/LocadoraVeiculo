package com.locadora.dominio.AluguelVeiculo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.locadora.dominio.pessoa.Pessoa;
import com.locadora.dominio.veiculo.Veiculo;

import lombok.Getter;

@Getter
@Table(schema = "SCHEMA_LOCADORA", name = "ALUGUEL_VEICULO")
@Entity
public class AluguelVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "VEICULO_ID")
	private Veiculo veiculo;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PESSOA_ID")
	private Pessoa pessoa;
  
	@Column(name = "DATA_RETIRADA", nullable = false)
	private Date dataRetirada;

	@Column(name = "DATA_DEVOLUCAO", nullable = false)
	private Date dataDevolucao;

	@Column(name = "VALOR_TOTAL")
	private double valorTotal;

	public AluguelVeiculo(Veiculo veiculo, Pessoa pessoa, Date dataDevolucao) {
		this.veiculo = veiculo;
		this.pessoa = pessoa;
		this.dataDevolucao = dataDevolucao;
		this.dataRetirada = new Date();
		this.veiculo.reserva();
		calcularValorTotal(veiculo.getValorDiaria());

	}

	public void calcularValorTotal(double valorDiaria) {

		int quantidadeDias = (int) ((this.dataDevolucao.getTime() - this.dataRetirada.getTime()) / 86400000L);

		this.valorTotal = valorDiaria * quantidadeDias;

	}

	
	public void realizarPagamento() {
		  if(this.dataDevolucao.before(new Date())) {
			  
			  this.valorTotal += this.veiculo.getValorDiaria();
		  }
		
		this.veiculo.devolucao();
		
	}
}
