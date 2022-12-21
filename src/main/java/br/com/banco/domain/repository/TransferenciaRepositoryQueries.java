package br.com.banco.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import br.com.banco.domain.model.Transferencia;

public interface TransferenciaRepositoryQueries {

	List<Transferencia> find(Long contaId);

}