package com.locadora.aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.dominio.AluguelVeiculo.AluguelVeiculo;
import com.locadora.dominio.pessoa.Pessoa;
import com.locadora.dominio.veiculo.Veiculo;
import com.locadora.dto.DtoAluguelVeiculo;
import com.locadora.dto.resposta.Resposta;
import com.locadora.dto.veiculo.DtoVeiculo;
import com.locadora.repositorio.veiculo.AlugarVeiculoRepositorio;
import com.locadora.repositorio.veiculo.PessoaRepositorio;
import com.locadora.repositorio.veiculo.VeiculoRepositorio;

@Service
public class AlugarVeiculo {

	private AlugarVeiculoRepositorio alugarVeiculoRepositorio;
	private VeiculoRepositorio veiculoRepositorio;
	private PessoaRepositorio pessoaRepositorio;

	@Autowired
	public AlugarVeiculo(AlugarVeiculoRepositorio alugarVeiculoRepositorio, VeiculoRepositorio veiculoRepositorio, PessoaRepositorio pessoaRepositorio) {

		this.alugarVeiculoRepositorio = alugarVeiculoRepositorio;
		this.veiculoRepositorio = veiculoRepositorio;
		this.pessoaRepositorio = pessoaRepositorio;

	}

	public Resposta alugarVeiculo(DtoAluguelVeiculo dtoAluguelVeiculo) {
		Veiculo veiculo = veiculoRepositorio.findByPlacaIs(dtoAluguelVeiculo.getPlaca());

		if (veiculo != null) {
			if (veiculo.isDisponivel()) {
				Pessoa pessoa = pessoaRepositorio.findByCpf(dtoAluguelVeiculo.cpf);
				if (pessoa != null) {
					AluguelVeiculo aluguelVeiculo = new AluguelVeiculo(veiculo, pessoa,
							dtoAluguelVeiculo.getDataDevolucao());
					alugarVeiculoRepositorio.save(aluguelVeiculo);
					return new Resposta("Aluguel realizado com sucesso");
				

				} else {
					pessoa = new Pessoa(dtoAluguelVeiculo.nome, dtoAluguelVeiculo.email, dtoAluguelVeiculo.cpf);
					AluguelVeiculo aluguelVeiculo = new AluguelVeiculo(veiculo, pessoa,
							dtoAluguelVeiculo.getDataDevolucao());

					alugarVeiculoRepositorio.save(aluguelVeiculo);
					return new Resposta("Aluguel realizado com sucesso");
				}

			} else {
				return new Resposta("Veiculo nao Disponivel");

			}

		} else {
			return new Resposta("Veiculo não encontrado");
		}

	}
}
