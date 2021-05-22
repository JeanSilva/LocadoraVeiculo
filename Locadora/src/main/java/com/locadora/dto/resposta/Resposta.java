package com.locadora.dto.resposta;

import lombok.Getter;

@Getter
public class Resposta {
	
	private String mensagem;

	public Resposta(String mensagem) {		
		this.mensagem = mensagem;
	}

}
