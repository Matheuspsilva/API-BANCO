package br.com.banco.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.TransferenciaRepository;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@GetMapping(value = "/{contaBancaria}")
	public List<Transferencia> buscar(
			@PathVariable Long contaBancaria, 
			@RequestParam String nomeOperador, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataTransferenciaInicial,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataTransferenciaFinal) {
		return transferenciaRepository.find(contaBancaria, nomeOperador, dataTransferenciaInicial, dataTransferenciaFinal);
	}

}
