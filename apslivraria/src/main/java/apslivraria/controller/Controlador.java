package apslivraria.controller;

import apslivraria.model.Model;
import apslivraria.model.dao.Crud;
import apslivraria.view.View;

public class Controlador {
	private Model model;
	private View view;
	
	public Controlador(View view, Model model) {
		this.view = view;
		this.model = model;
		view.JanelaPrincipal(model);

	}
	
	public void init() {
		view.JanelaPrincipal(new Crud());
	}
	
//	JanelaPrincipal minhaJanela = new JanelaPrincipal(crud);}
}	
