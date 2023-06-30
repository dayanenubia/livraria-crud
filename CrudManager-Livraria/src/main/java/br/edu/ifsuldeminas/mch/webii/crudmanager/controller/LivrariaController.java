package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.LivrariaRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.LivroRepository;

@Controller
public class LivrariaController {
	
	@Autowired
	private LivrariaRepository livrariaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/livrarias")
	public String livrarias(Model model) {
		
		List<Livraria> livrarias = livrariaRepository.findAll();
		model.addAttribute("livrarias", livrarias);
		
		return "indexLivrarias";
	}
	
	@GetMapping("/livrarias/form")
	public String livrariaForm(Model model, @ModelAttribute("livraria") Livraria livraria) {
		List<Livro> livros = livroRepository.findAll();
		model.addAttribute("livros",livros);
		return "livraria_form";
	}
	
	@PostMapping("/livrarias/new")
	public String livrariaNew(@Valid @ModelAttribute("livraria=") Livraria livraria, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "livraria_form";
		}
		livrariaRepository.save(livraria);
		return "redirect:/livrarias";
	}
	
	@GetMapping("/livrarias/update/{id}")
	public String livrariaUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Livraria> optLivraria = livrariaRepository.findById(id);
		
		if(!optLivraria.isPresent()) {
			//Gerar erro
		}
		
		Livraria livraria = optLivraria.get();
		
		model.addAttribute("livraria", livraria);
		
		List<Livro> livros = livroRepository.findAll();
		model.addAttribute("livros",livros);
		
		return "livraria_form";
	}
	
	@GetMapping("/livrarias/delete/{id}")
	public String livrariaDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Livraria> optLivraria = livrariaRepository.findById(id);
		
		if(!optLivraria.isPresent()) {
			//Gerar erro
		}
		
		Livraria livraria = optLivraria.get();
		
		livrariaRepository.delete(livraria);
		
		return "redirect:/livrarias";
	}
}