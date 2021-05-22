package com.locadora.dto.veiculo;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DtoVeiculo {
	
	public String marca;
	public String modelo;
	public String cor;
	public String placa;
	public BigDecimal valorDiaria;
	
}
