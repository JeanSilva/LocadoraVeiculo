package com.locadora.repositorio.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.dominio.AluguelVeiculo.AluguelVeiculo;


public interface AlugarVeiculoRepositorio  extends JpaRepository<AluguelVeiculo, Long>{ 
	
}
