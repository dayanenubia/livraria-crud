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

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Livro;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.LivroRepository;

@Controller
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/livros")
	public String livros(Model model) {
		
		List<Livro> livros = livroRepository.findAll();
		model.addAttribute("livros", livros);
		
		return "indexLivro";
	}
	

	@GetMapping("")
	public String index(Model model) {
		
		List<Livro> livros = livroRepository.findAll();
		model.addAttribute("livros", livros);
		
		return "indexLivro";
	}
	
	
	
	@GetMapping("/livros/form")
	public String livroForm(@ModelAttribute("livro") Livro livro) {
		return "livro_form";
	}
	
	@PostMapping("/livros/new")
	public String livroNew(@Valid @ModelAttribute("livro=") Livro livro, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "livro_form";
		}
		livroRepository.save(livro);
		return "redirect:/livros";
	}
	
	@GetMapping("/livros/update/{id}")
	public String livroUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Livro> optLivro = livroRepository.findById(id);
		
		if(!optLivro.isPresent()) {
			//Gerar erro
		}
		
		Livro livro = optLivro.get();
		
		model.addAttribute("livro", livro);
		
		return "livro_form";
	}
	
	@GetMapping("/livros/delete/{id}")
	public String livroDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Livro> optLivro = livroRepository.findById(id);
		
		if(!optLivro.isPresent()) {
			//Gerar erro
		}
		
		Livro livro = optLivro.get();
		
		livroRepository.delete(livro);
		
		return "redirect:/livros";
	}
}