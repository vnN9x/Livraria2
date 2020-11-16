package apslivraria.model;

import java.util.List;

import org.hibernate.SessionFactory;

import apslivraria.entidades.Autor;
import apslivraria.entidades.Editora;
import apslivraria.entidades.Livro;

public interface Model {
	public SessionFactory getCurrentSessionFromJPA();
	
	//adiciona
	public void addLivro(Livro livro, List <Long> autoresId);
	public void addEditora(Editora editora);
	public void addAutor(Autor autor);
	
	//encontra todos
	public List <Livro> findAllBooks();
	public List <Autor> findAllAuthors();
	public List <Editora> findAllPublishers();
	
	//encontra por id
	public Livro getLivroById(final String id);
	public Autor getAutorById(final long id);
	public Editora getEditoraById(final long id);
	
	//atualiza
	public void updateLivro(String isbn, String titulo, double preco);
	public void updateAutor(long id, String nome, String sobrenome);
	public void updateEditora(long id, String nome, String site);
	
	//exclui
	public void deleteLivro(String isbn);
	public void deleteAutor(long id);
	public void deleteEditora(long id);
	
	//busca
	public List<Livro> buscarLivro(String titulo);
	public List<Autor> buscarAutor(String nome);
	public List<Editora> buscarEditora(String nome);
}
