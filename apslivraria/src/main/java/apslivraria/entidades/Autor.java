package apslivraria.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autor_id")
	private long autorId;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List <Livro> livros;
	
	public long getAutorId() {
		return autorId;
	}
	public Autor() {}
	
	public Autor(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	public void setAutorId(long autorId) {
		this.autorId = autorId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public List <Livro> getLivros() {
		return livros;
	}
	public void setLivros(List <Livro> livros) {
		this.livros = livros;
	}
	@Override
	public String toString() {
		return "Id: " + autorId + ", Nome: " + nome + ", Sobrenome: " + sobrenome + "\n";
	}
	
		
}
