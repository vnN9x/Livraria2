package apslivraria.entidades;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Livro {
	
	@Column(name = "titulo")
	private String titulo;
	@Id
	private String isbn;
	@Column(name = "editora_id")
	private long editoraId;
	@Column(name = "preco")
	private double preco;
	
	@ManyToOne()
	private Editora editora;
	@ManyToMany()
	private List <Autor> autores;
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List <Autor>getAutores() {
		return autores;
	}

	public void setAutores(List <Autor> autores) { 
		this.autores = autores;
	}

	public Livro() {}
	
	public Livro(String titulo, String isbn, long editoraId, double preco) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.editoraId = editoraId;
	}
	public long getEditoraId() {
		return editoraId;
	}
	public void setEditoraId(long editoraId) {
		this.editoraId = editoraId;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ISBN: " + isbn + ", Titulo: " + titulo + ", Preço: " + preco + "\n";
	}

	
}
