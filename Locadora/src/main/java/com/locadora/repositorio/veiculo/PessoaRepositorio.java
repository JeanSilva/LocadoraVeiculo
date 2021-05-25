package com.locadora.repositorio.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.dominio.pessoa.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
			Pessoa findByCpf(String cpf);
}
