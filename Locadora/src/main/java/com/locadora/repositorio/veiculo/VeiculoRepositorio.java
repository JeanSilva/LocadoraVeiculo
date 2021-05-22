package com.locadora.repositorio.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.dominio.veiculo.Veiculo;

public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long>{
  	
	Veiculo findByPlacaIs(String placa);
	
}