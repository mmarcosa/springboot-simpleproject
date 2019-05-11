package br.com.listavip.configuracao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.enviadorEmail.service.EmailService;
import br.com.listavip.configuracao.model.Convidado;
import br.com.listavip.configuracao.repository.ConvidadoRepository;
import br.com.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository repository;
	
	@Autowired
    private ConvidadoService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("listaconvidados")
    public String listaConvidados(Model model){

        Iterable<Convidado> convidados = service.obterTodos();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }
	
	
	@RequestMapping(value="salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone, Model model) {
		Convidado novoConvidado = new Convidado(nome, email, telefone);
		service.salvar(novoConvidado);
	    
	    new EmailService().enviarEmail(nome, email);
	    
	    Iterable<Convidado> convidados = service.obterTodos();
	    model.addAttribute("convidados", convidados);
	    
	    return "listaconvidados";
	}
	
	@RequestMapping(value="remover/{nome}", method = RequestMethod.POST)
	public String remover(@RequestParam("nome")String nome, Model model) {
		List<Convidado>  convidado = repository.findByNome(nome);
		repository.delete(convidado);
		
		return "redirect:/listaconvidados";
	}
	
}
