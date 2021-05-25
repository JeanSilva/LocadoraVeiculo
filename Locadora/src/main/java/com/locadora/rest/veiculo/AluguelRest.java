package com.locadora.rest.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.aplicacao.AlugarVeiculo;
import com.locadora.dto.DtoAluguelVeiculo;
import com.locadora.dto.resposta.Resposta;

@RestController
@RequestMapping("/AluguelVeiculo")
public class AluguelRest {

	@Autowired
	private AlugarVeiculo alugarVeiculo;
	
	@ResponseBody
	@RequestMapping(value="/alugarVeiculo", method = RequestMethod.POST)
	public Resposta alugarVeiculo(@RequestBody DtoAluguelVeiculo dtoAluguelVeiculo) {
		return alugarVeiculo.alugarVeiculo(dtoAluguelVeiculo);
	}
	

}
