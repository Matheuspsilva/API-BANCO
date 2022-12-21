package br.com.banco.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import br.com.banco.domain.model.Transferencia;

public interface TransferenciaRepositoryQueries {

	List<Transferencia> find(Long contaId, String nomeOperador, LocalDateTime dataTransferenciaInicial, LocalDateTime dataTransferenciaFinal);

}