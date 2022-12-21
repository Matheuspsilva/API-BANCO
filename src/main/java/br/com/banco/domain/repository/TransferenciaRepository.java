package br.com.banco.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.domain.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>, TransferenciaRepositoryQueries{
	
	@Override
	default List<Transferencia> find(Long contaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Query("from Transferencia where conta.id = :id")
	List<Transferencia> consultarPorConta(@Param("id") Long id);

}
