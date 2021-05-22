package com.locadora.aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.dominio.veiculo.Veiculo;
import com.locadora.dto.resposta.Resposta;
import com.locadora.dto.veiculo.DtoVeiculo;
import com.locadora.repositorio.veiculo.VeiculoRepositorio;

@Service
public class CadastroVeiculo {

	private VeiculoRepositorio veiculoRepositorio;

	@Autowired
	public CadastroVeiculo(VeiculoRepositorio veiculoRepositorio) {
		this.veiculoRepositorio = veiculoRepositorio;
	}

	public Resposta cadastro(DtoVeiculo dtoVeiculo) {

		try {
			Veiculo veiculo = new Veiculo(dtoVeiculo.marca, dtoVeiculo.modelo, dtoVeiculo.cor, dtoVeiculo.placa,
					dtoVeiculo.valorDiaria);

			veiculoRepositorio.save(veiculo);

			return new Resposta("Veiculo Cadastrado com sucesso!");
		} catch (Exception erro) {
			erro.printStackTrace();
			return new Resposta("Falha no cadastro do veiculo");
		}

	}
	
	public Resposta Teste() {
		return new Resposta("Veiculo Cadastrado com sucesso!");
	}
}
