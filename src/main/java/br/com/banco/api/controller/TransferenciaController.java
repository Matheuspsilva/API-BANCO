package br.com.banco.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.TransferenciaRepository;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;


	@GetMapping(value = "/")
	public List<Transferencia> listar() {
		return transferenciaRepository.findAll();
	}
	
	@GetMapping(value = "/{contaBancaria}")
	public List<Transferencia> buscar(@PathVariable Long contaBancaria) {
		System.out.println("Por conta");
		return transferenciaRepository.consultarPorConta(contaBancaria);
	}

}
