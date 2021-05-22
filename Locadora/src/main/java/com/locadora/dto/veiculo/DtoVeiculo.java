package com.locadora.dto.veiculo;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DtoVeiculo {
	
	public String marca;
	public String modelo;
	public String cor;
	public String placa;
	public BigDecimal valorDiaria;
	public boolean disponivel;
	
}
