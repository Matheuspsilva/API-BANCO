package br.com.banco.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.TransferenciaRepository;
import br.com.banco.domain.repository.TransferenciaRepositoryQueries;

@Repository
public class TransferenciaRepositoryImpl implements TransferenciaRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	@Lazy
	private TransferenciaRepository restauranteRepository;

	@Override
	public List<Transferencia> find(Long contaId, String nomeOperador, LocalDateTime dataTransferenciaInicial, LocalDateTime dataTransferenciaFinal) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Transferencia> criteria = builder.createQuery(Transferencia.class);

		Root<Transferencia> root = criteria.from(Transferencia.class);

		ArrayList<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(builder.equal(root.get("conta"), contaId));
		
		if(StringUtils.hasText(nomeOperador)) {
			predicates.add(builder.like(root.get("nomeOperadorTransacao"), "%" + nomeOperador + "%"));
		}

		if(dataTransferenciaInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataTransferencia"), dataTransferenciaInicial));
		}

		
		if(dataTransferenciaFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataTransferencia"), dataTransferenciaFinal));
		}
		
		
		criteria.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Transferencia> typedQuery = manager.createQuery(criteria);

		return typedQuery.getResultList();
	}

}
