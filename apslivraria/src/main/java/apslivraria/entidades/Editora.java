package apslivraria.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "editora", uniqueConstraints = @UniqueConstraint(columnNames = {"nome"}))
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "editora_id")
	private long editoraId;
	@Column(name = "nome")
	private String nome;
	@Column(name = "site")
	private String site;
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@OneToMany(cascade = CascadeType.ALL)
	List <Livro> livros;
	
	public Editora() {}

	public Editora(String nome, String site) {
		this.nome = nome;
		this.site = site;
	}

	public long getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(long editoraId) {
		this.editoraId = editoraId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Id: " + editoraId + ", Nome: " + nome + ", Site: " + site + "";
	}
	
	
}
