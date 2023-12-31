package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="livrarias")
public class Livraria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Nome não pode ser vazio" )
    private String nome;
	
	@NotBlank(message = "Endereço não pode ser vazio" )
    private String endereco;
	
	@NotBlank(message = "Telefone não pode ser vazio" )
    private String telefone;
	
    private String site;
    
    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    private Livro livro;
	
	public Livraria() {};
	
	public Livraria(Integer id)
	{
		this.id = id;
		setNome("");
		setEndereco("");
		setTelefone("");
		setSite("");
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}