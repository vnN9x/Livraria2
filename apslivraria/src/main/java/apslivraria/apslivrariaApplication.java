package apslivraria;

import java.util.ArrayList;
import java.util.List;

import apslivraria.controller.Controlador;
import apslivraria.entidades.Livro;
import apslivraria.model.Model;
import apslivraria.model.dao.Crud;
import apslivraria.view.JanelaPrincipal;
import apslivraria.view.View;

public class apslivrariaApplication{
	

	public static void main(String[] args) {
		Livro livro = new Livro("Oie", "77-777", 19, 59.90);
		List <Long> autores = new ArrayList<Long>();
		autores.add(658l);
		Model model = new Crud();
		View view = new JanelaPrincipal();
		Controlador ctrl = new Controlador(view, model);
//		JanelaPrincipal janela = new JanelaPrincipal(new Crud());
//		for (Editora editora: model.findAllPublishers()) {
//			System.out.println(editora);
//		}
		
	}
}