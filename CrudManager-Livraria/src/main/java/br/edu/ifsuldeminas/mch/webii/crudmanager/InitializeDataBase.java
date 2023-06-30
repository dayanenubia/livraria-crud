package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Livraria;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Livro;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.LivrariaRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.LivroRepository;
@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
    
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private LivrariaRepository livrariaRepository;
    
    @Override
    public void run(String... args) throws Exception {
        Livro livro1 = new Livro();
        livro1.setNome("Dom Quixote");
        livro1.setGenero("Romance de Cavalaria/Sátira");
        livro1.setAutor("Miguel de Cervantes");
        livro1.setQuantidade("123");
        
        Livro livro2 = new Livro();
        livro2.setNome("1984");
        livro2.setGenero("Distopia");
        livro2.setAutor("George Orwell");
        livro2.setQuantidade("123");
        
        Livraria livraria1 = new Livraria();
        livraria1.setNome("Livraria Cultura");
        livraria1.setEndereco("Av. Paulista, 2073 - Bela Vista, São Paulo - SP");
        livraria1.setTelefone(" (11) 3170-4033");
        livraria1.setSite("https://www.livrariacultura.com.br/");
        livraria1.setLivro(livro1);
        
        Livraria livraria2 = new Livraria();
        livraria2.setNome("Livraria Saraiva");
        livraria2.setEndereco("Av. Paulista, 1499 - Bela Vista, São Paulo - SP");
        livraria2.setTelefone(" (11) 3170-1010");
        livraria2.setSite("https://www.saraiva.com.br/");
        livraria2.setLivro(livro1);
        
        
        livroRepository.save(livro1);
        livroRepository.save(livro2);
        livrariaRepository.save(livraria1);
        livrariaRepository.save(livraria2);
        
     }
    
}