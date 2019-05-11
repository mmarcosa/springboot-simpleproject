package br.com.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listavip.configuracao.model.Convidado;
import br.com.listavip.configuracao.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	@Autowired
    private ConvidadoRepository repository;  //para o spring disponibilizar um objeto com as características de um repository

    public Iterable<Convidado> obterTodos(){
        Iterable<Convidado> convidados = repository.findAll();
        return convidados;
    }

    public void salvar(Convidado convidado){
        repository.save(convidado);
    }
}
