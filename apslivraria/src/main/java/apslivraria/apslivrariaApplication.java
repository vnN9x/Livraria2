package apslivraria;

import apslivraria.controller.Controlador;
import apslivraria.model.Model;
import apslivraria.model.dao.Crud;
import apslivraria.view.JanelaPrincipal;
import apslivraria.view.View;

public class apslivrariaApplication{
	

	public static void main(String[] args) {
		Model model = new Crud();
		View view = new JanelaPrincipal();
		@SuppressWarnings("unused")
		Controlador ctrl = new Controlador(view, model);
	}
}