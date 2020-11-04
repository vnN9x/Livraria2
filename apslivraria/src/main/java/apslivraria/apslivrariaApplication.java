package apslivraria;

import java.util.ArrayList;
import java.util.List;

import apslivraria.entidades.Autor;
import apslivraria.entidades.Editora;
import apslivraria.entidades.Livro;
import apslivraria.model.dao.Crud;

public class apslivrariaApplication{
	static Crud crud = new Crud();

	public static void main(String[] args) {
		List <Livro> livros = crud.findAllBooks();
		for (int i = 0; i < livros.size(); i++) {	
			System.out.println("LIVRO: " + livros.get(i) + ", AUTORES: " + livros.get(i).getAutores() + 
					", EDITORA: "+ livros.get(i).getEditora());
		}
		
		List<Autor> autores = crud.findAllAuthors();
		for (int i = 0; i < autores.size(); i++) {
			System.out.println(autores.get(i)+ ", Livros: " + autores.get(i).getLivros());
		}
		
		List<Editora> editoras = crud.findAllPublishers();
		for (int i = 0; i < editoras.size(); i++) {
			System.out.println(editoras.get(i)+ ", Livros: " + editoras.get(i).getLivros());
		}
	}
}