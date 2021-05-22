package com.locadora.rest.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.aplicacao.CadastroVeiculo;
import com.locadora.dto.resposta.Resposta;
import com.locadora.dto.veiculo.DtoVeiculo;

@RestController
@RequestMapping("/veiculo")
public class VeiculoRest {

	@Autowired
	private CadastroVeiculo cadastroVeiculo;
	
	@GetMapping
	@ResponseBody
	public Resposta teste() {
		return cadastroVeiculo.Teste();
	}
	
	@ResponseBody
	@RequestMapping(value="/cadastrar" , method = RequestMethod.POST)
	public Resposta Cadastro(@RequestBody DtoVeiculo dtoVeiculo) {
		return cadastroVeiculo.cadastro(dtoVeiculo);
	}
}
	