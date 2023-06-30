package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="livros")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Nome não pode ser vazio" )
	private String nome;
	
	@NotBlank(message = "Genero não pode ser vazio" )
	private String genero;
	
	@NotBlank(message = "Autor não pode ser vazio" )
	private String autor;
	
	
	private String quantidade;

	public Livro() {};
	
	public Livro(Integer id)
	{
		this.id = id;
		setNome("");
		setGenero("");
		setAutor("");
		setQuantidade("");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
}