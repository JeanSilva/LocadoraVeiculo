package com.locadora.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DtoAluguelVeiculo {
     public String nome;
     public String cpf;
     public String email;
     public String placa;
     public Date dataDevolucao;
    
	
	
}
