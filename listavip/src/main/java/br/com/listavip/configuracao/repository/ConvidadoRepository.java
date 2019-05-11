package br.com.listavip.configuracao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.listavip.configuracao.model.Convidado;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

	List<Convidado> findByNome(String nome);
	
}
