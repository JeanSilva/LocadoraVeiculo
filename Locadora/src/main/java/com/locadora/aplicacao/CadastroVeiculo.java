package com.locadora.aplicacao;

import java.util.List;

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

	public Resposta excluirVeiculo(String placa) {
		try {

			Veiculo veiculo = veiculoRepositorio.findByPlacaIs(placa);

			veiculoRepositorio.delete(veiculo);
			return new Resposta("Veiculo excluido com sucesso");

		} catch (Exception erro) {
			erro.printStackTrace();
			return new Resposta("Erro ao Excluir");
		}

	}
	
	public Resposta atualizar(DtoVeiculo dtoVeiculo) {
		try {

			Veiculo veiculo = veiculoRepositorio.findByPlacaIs(dtoVeiculo.placa);

			veiculo.atualizar(dtoVeiculo.marca, dtoVeiculo.modelo, dtoVeiculo.cor, dtoVeiculo.placa,
					dtoVeiculo.valorDiaria, dtoVeiculo.disponivel);
			
					veiculoRepositorio.save(veiculo);
			return new Resposta("Veiculo atualizado");

		} catch (Exception erro) {
			erro.printStackTrace();
			return new Resposta("Erro ao atualizarr");
		}

	}
	
	public List<Veiculo> listarVeiculosAlugados() {
		try {
			return veiculoRepositorio.findByDisponivelIs(false);
		} catch (Exception erro) {
			erro.printStackTrace();
		}		
		return null;
	}
	
	public List<Veiculo> listarVeiculosDisponiveis() {
		try {
			return veiculoRepositorio.findByDisponivelIs(true);
		} catch (Exception erro) {
			erro.printStackTrace();
		}		
		return null;
	}	
	
}
