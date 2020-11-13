package apslivraria.view;

import apslivraria.*;
import apslivraria.entidades.Autor;
import apslivraria.entidades.Editora;
import apslivraria.entidades.Livro;
import apslivraria.model.dao.Crud;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.LinkedHashMap;

import javax.swing.*;

//public class JanelaPrincipal extends JFrame implements ActionListener {
public class JanelaPrincipal extends JFrame{
	Crud crud = new Crud();
	private static final long serialVersionUID = 1L;

	JTabbedPane tabbedPane;

	// BUSCA
	JButton busca_jbutton_run;
	JTextField busca_jtextfield_input;
	JPanel busca_jpanel_return_results;
	JCheckBox busca_jcheckbox_select_autor;
	JCheckBox busca_jcheckbox_select_editora;
	JCheckBox busca_jcheckbox_select_livro;


	// ALTERA
	JButton altera_jbutton_run;
	JButton altera_jbutton_run_busca;
	JCheckBox altera_jcheckbox_select_autor;
	JCheckBox altera_jcheckbox_select_editora;
	JCheckBox altera_jcheckbox_select_livro;
	List<JRadioButton> altera_list_jradiobuttons;
	JPanel altera_jpanel_return_busca_result;

	// INCLUI
	JButton inclui_jbutton_run;
	JCheckBox inclui_jcheckbox_select_autor;
	JCheckBox inclui_jcheckbox_select_editora;
	JCheckBox inclui_jcheckbox_select_livro;
	JPanel inclui_jpanel_cardlayout_panel;
	JPanel inclui_jpanel_autores_comboboxes_wrapper;
	JPanel inclui_jpanel_mother_panel_autor;
	JPanel inclui_jpanel_autor_alinhamento_horizontal;
	JPanel inclui_jpanel_mother_panel_editora;
	JPanel inclui_jpanel_editora_alinhamento_horizontal;
	JPanel inclui_jpanel_mother_panel_livro;
	JPanel inclui_jpanel_livro_alinhamento_horizontal;
	Vector inclui_vector_combobox_opcoes_editora;
	Vector inclui_vector_combobox_opcoes_autor;
	JTextField inclui_jtextfield_autor_nome;
	JTextField inclui_jtextfield_autor_sobrenome;
	JTextField inclui_jtextfield_editora_nome;
	JTextField inclui_jtextfield_editora_site;
	JTextField inclui_jtextfield_livro_isbn;
	JTextField inclui_jtextfield_livro_nome;
	JComboBox inclui_jcombobox_opcoes_editora;
	JComboBox inclui_jcombobox_opcoes_autor;
	Map<JComboBox, Boolean> inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor;
	//Map<JComboBox, Map<Boolean, JPanel>> inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor;

	// EXCLUI
	JButton exclui_jbutton_run;
	JButton exclui_jbutton_run_busca;
	JPanel exclui_jpanel_return_busca_results;
	JTextField exclui_jtextfield_busca_input;
	JCheckBox exclui_jcheckbox_select_autor;
	JCheckBox exclui_jcheckbox_select_editora;
	JCheckBox exclui_jcheckbox_select_livro;
	List<JRadioButton> exclui_list_jradiobutton_result;

	// Listas "globais"(serão usadas em todas as 'tabs') de busca
//	List<Autor> tst_autores_list = new ArrayList<Autor>();
//	List<Editora> tst_editoras_list = new ArrayList<Editora>();
//	List<Livro> tst_livros_list = new ArrayList<Livro>();
//
//	// TST
//	Autor tst_autor0 = new Autor("Alexander", "Christopher");
//	Autor tst_autor1 = new Autor("Jamelão", "Christopher");
//	Autor tst_autor2 = new Autor("Randemonson", "Christopher");
//	Autor tst_autor3 = new Autor("Christopher", "Christopher");
//	Autor tst_autor4 = new Autor("Cabação", "Christopher");
//	Autor tst_autor5 = new Autor("Não sabe ler", "Christopher");
//
//	Editora tst_editora0 = new Editora("Addison-Wesley", "www.aw-bc.com");
//	Editora tst_editora1 = new Editora("Addison-asçdlkfj", "www.aw-!!!!!!!com");
//	Editora tst_editora2 = new Editora("Addison-ZZZZZZZZ", "www.??????-bc.com");
//	Editora tst_editora3 = new Editora("Addison-iiiiiiiiii", "www.aw-bc.com");
//	Editora tst_editora4 = new Editora("@@@@@@@@@-Wesley", "xxxxxxx.aw-bc.com");
//	Editora tst_editora5 = new Editora("%%%%%%%%%%%%55-Wesley", "www.aw-bc********");
//
//	Livro tst_livro0 = new Livro(201964260L, "A Guide to the SQL Standard", 37.45f, tst_editora0);
//	Livro tst_livro1 = new Livro(293842390L, "A Guide to the asçdlfklja Standard", 53.45f, tst_editora1);
//	Livro tst_livro2 = new Livro(328984238L, "A Guide to the ?????????????????", 54.45f, tst_editora2);
//	Livro tst_livro3 = new Livro(932893298L, "A Guide to the kkkkkkkkk", 27.45f, tst_editora3);
//	Livro tst_livro4 = new Livro(437491923L, "A Guide to the !!!!!!!!!!!!", 54.45f, tst_editora4);
//	Livro tst_livro5 = new Livro(298348293L, "A Guide to the XXXXXXXXXXXX", 52.45f, tst_editora5);

	private JanelaPrincipal() {
		createGUI();
		setDisplay();
	}

	private void setDisplay() {
		setSize(900, 900);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createGUI() {
		setTitle("Gerenciador Livraria");
		createJTabbedPane();
		add(tabbedPane);
	}

	private void createJTabbedPane() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.add("Busca", createBuscaJPanel());
		tabbedPane.add("Alterar", createAlteraJPanel());
		tabbedPane.add("Incluir", createIncluiJPanel());
		tabbedPane.add("Excluir", createExcluiJPanel());
	}


	// BUSCA
	private JPanel createBuscaJPanel() {
		// variaveis globais
		busca_jbutton_run = new JButton("Executar Busca");
		busca_jbutton_run.setAlignmentX(CENTER_ALIGNMENT);

		busca_jtextfield_input = new JTextField("", 100);
		busca_jtextfield_input.setAlignmentX(CENTER_ALIGNMENT);
		busca_jtextfield_input.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		busca_jpanel_return_results = new JPanel();
		busca_jcheckbox_select_autor = new JCheckBox("Autor");
		busca_jcheckbox_select_editora = new JCheckBox("Editora");
		busca_jcheckbox_select_livro = new JCheckBox("Livro");

		// Panel principal
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		// panel para os check boxes de seleção de busca
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.LINE_AXIS));

		ButtonGroup button_panel_group = new ButtonGroup();
		button_panel_group.add(busca_jcheckbox_select_autor);
		button_panel_group.add(busca_jcheckbox_select_livro);
		button_panel_group.add(busca_jcheckbox_select_editora);

		button_panel.add(busca_jcheckbox_select_autor);
		button_panel.add(busca_jcheckbox_select_livro);
		button_panel.add(busca_jcheckbox_select_editora);

		// action listener do botao principal
		busca_jbutton_run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busca_jpanel_return_results.removeAll();

				busca(busca_jcheckbox_select_autor, busca_jcheckbox_select_livro, busca_jcheckbox_select_editora, busca_jpanel_return_results);

				busca_jpanel_return_results.revalidate();
				busca_jpanel_return_results.repaint();
			}
		});

		// adicionando tudo ao panel principal
		panel.add(busca_jbutton_run);
		panel.add(button_panel);
		panel.add(busca_jtextfield_input);
		panel.add(busca_jpanel_return_results);

		return panel;
	}

	// TODO:Adaptar autor para listas
	private void busca(JCheckBox autor_button, JCheckBox editora_button, JCheckBox livro_button, JPanel return_panel) {
		if (autor_button.isSelected()) {
			return_panel.add(returnautorBusca(tst_autor0));
		}
		if (livro_button.isSelected()) {
			return_panel.add(returnLivroBusca(tst_livro0));
		}
		if (editora_button.isSelected()) {
			return_panel.add(returnEditoraBusca(tst_editora0));
		}

	}

	private JLabel returnautorBusca(Autor autor) {
		String autorName = autor.getNome();
		String authoSurname = autor.getSobrenome();
		long autorId = autor.getAutorId();

		return new JLabel(autorId + " " + autorName + " " + authoSurname);
	}

	private JLabel returnEditoraBusca(Editora editora) {
		String editoraName = editora.getNome();
		String editoraSite = editora.getSite();
		long editoraId = editora.getEditoraId();

		return new JLabel(editoraId + " " + editoraName + " " + editoraSite);
	}

	private JLabel returnLivroBusca(Livro livro) {
		String livroName = livro.getNome();
		float livroPrice = livro.getPreco();
		long livroISBN = livro.getIsbn();
		String livroeditoraName = livro.getEditora().getNome();

		return new JLabel(livroName + " " + livroISBN + " " + livroPrice + " " + livroeditoraName);
	}



	// ALTERA
	private JPanel createAlteraJPanel() {
		//vars
		altera_jbutton_run = new JButton("Executar Alteração");
		altera_jbutton_run.setAlignmentX(CENTER_ALIGNMENT);

		altera_jbutton_run_busca = new JButton("Executar Busca");
		altera_jbutton_run_busca.setAlignmentX(CENTER_ALIGNMENT);

		altera_jcheckbox_select_autor = new JCheckBox("Autor");
		altera_jcheckbox_select_editora = new JCheckBox("Editora");
		altera_jcheckbox_select_livro = new JCheckBox("Livro");

		altera_jpanel_return_busca_result = new JPanel();
		altera_jpanel_return_busca_result.setLayout(new BoxLayout(altera_jpanel_return_busca_result, BoxLayout.PAGE_AXIS));

		altera_list_jradiobuttons = new ArrayList<JRadioButton>();
		Vector altera_vector_autor_combobox_itens = new Vector();
		Vector altera_vector_editora_combobox_itens = new Vector();

		//altera_jpanel_livro_horizontal_alignment_group
		Map<JComboBox, Boolean> altera_map_jcombobox_boolean_todas_opcoes_jcomboboxes_autor = new LinkedHashMap<>();

		List<Autor> tst_autores_list_altera = new ArrayList<Autor>();

		JComboBox altera_jcombobox_opcoes_autor = new JComboBox(new DefaultComboBoxModel(altera_vector_autor_combobox_itens));
		JComboBox altera_jcombobox_opcoes_editora = new JComboBox(new DefaultComboBoxModel(altera_vector_editora_combobox_itens));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JPanel button_panel = new JPanel();
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.LINE_AXIS));

		ButtonGroup button_panel_group = new ButtonGroup();
		button_panel_group.add(altera_jcheckbox_select_autor);
		button_panel_group.add(altera_jcheckbox_select_editora);
		button_panel_group.add(altera_jcheckbox_select_livro);

		button_panel.add(altera_jcheckbox_select_autor);
		button_panel.add(altera_jcheckbox_select_editora);
		button_panel.add(altera_jcheckbox_select_livro);


		JTextField altera_jtextfield_livro_nome = new JTextField("Novo nome", 20);
		altera_jtextfield_livro_nome.setAlignmentX(CENTER_ALIGNMENT);
		altera_jtextfield_livro_nome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		JTextField altera_jtextfield_livro_isbn = new JTextField("Novo isbn", 20);
		altera_jtextfield_livro_isbn.setAlignmentX(CENTER_ALIGNMENT);
		altera_jtextfield_livro_isbn.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		JComboBox altera_livro_editora;
		JComboBox altera_livro_autors;

		JTextField altera_jtextfield_autor_nome = new JTextField("Novo nome", 20);
		altera_jtextfield_autor_nome.setAlignmentX(CENTER_ALIGNMENT);
		altera_jtextfield_autor_nome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		JTextField altera_jtextfield_autor_sobrenome = new JTextField("Novo sobrenome", 20);
		altera_jtextfield_autor_sobrenome.setAlignmentX(CENTER_ALIGNMENT);
		altera_jtextfield_autor_sobrenome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		JTextField altera_jtextfield_editora_nome = new JTextField("Novo nome", 20);
		altera_jtextfield_editora_nome.setAlignmentX(CENTER_ALIGNMENT);
		altera_jtextfield_editora_nome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		JTextField altera_jtextfield_editora_site = new JTextField("Novo site", 20);
		altera_jtextfield_editora_site.setAlignmentX(CENTER_ALIGNMENT);
		altera_jtextfield_editora_site.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		JPanel altera_jpanel_cardlayout_panel = new JPanel();
		altera_jpanel_cardlayout_panel.setLayout(new CardLayout());

		// TST
		tst_autores_list.add(tst_autor0);
		tst_autores_list.add(tst_autor1);
		tst_autores_list.add(tst_autor2);
		tst_autores_list.add(tst_autor3);
		tst_autores_list.add(tst_autor4);
		tst_autores_list.add(tst_autor5);


		// livro
		JPanel altera_jpanel_livro_vertical_alignment = new JPanel();
		altera_jpanel_livro_vertical_alignment.setLayout(new BoxLayout(altera_jpanel_livro_vertical_alignment, BoxLayout.PAGE_AXIS));

		JPanel altera_jpanel_livro_horizontal_alignment = new JPanel();
		altera_jpanel_livro_horizontal_alignment.setLayout(new BoxLayout(altera_jpanel_livro_horizontal_alignment, BoxLayout.LINE_AXIS));

		JPanel altera_jpanel_livro_horizontal_alignment_wrapper = new JPanel();
		altera_jpanel_livro_horizontal_alignment_wrapper.setLayout(new BoxLayout(altera_jpanel_livro_horizontal_alignment_wrapper, BoxLayout.PAGE_AXIS));

		JPanel altera_jpanel_livro_horizontal_alignment_group = new JPanel();
		altera_jpanel_livro_horizontal_alignment_group.setLayout(new BoxLayout(altera_jpanel_livro_horizontal_alignment_group, BoxLayout.LINE_AXIS));

		//Vector inclui_vector_combobox_opcoes_autor = new Vector();
		
		altera_vector_editora_combobox_itens.add(null);
		for (Editora editora : tst_editoras_list) {
			altera_vector_editora_combobox_itens.add(editora);
		}

		altera_vector_autor_combobox_itens.add(null);
		for (Autor autor : tst_autores_list) {
			altera_vector_autor_combobox_itens.add(autor);
		}

		//TODO: atualizar o map
		//altera_map_jcombobox_boolean_todas_opcoes_jcomboboxes_autor.put(altera_jcombobox_opcoes_autor, new LinkedHashMap<Boolean, JPanel>(){{put(true, altera_jpanel_livro_horizontal_alignment_group);}});
		altera_map_jcombobox_boolean_todas_opcoes_jcomboboxes_autor.put(altera_jcombobox_opcoes_autor, true);

		altera_jcombobox_opcoes_autor.setAlignmentX(CENTER_ALIGNMENT);
		altera_jcombobox_opcoes_autor.setMaximumSize(busca_jtextfield_input.getPreferredSize());
		altera_jcombobox_opcoes_autor.addActionListener(new inclui_action_listener(altera_map_jcombobox_boolean_todas_opcoes_jcomboboxes_autor, altera_jpanel_livro_horizontal_alignment_group, tst_autores_list, busca_jtextfield_input));

		altera_jpanel_livro_horizontal_alignment_group.add(altera_jcombobox_opcoes_autor);

		altera_jpanel_livro_horizontal_alignment.add(altera_jtextfield_livro_nome);
		altera_jpanel_livro_horizontal_alignment.add(altera_jtextfield_livro_isbn);
		altera_jpanel_livro_horizontal_alignment_wrapper.add(altera_jpanel_livro_horizontal_alignment_group);
		altera_jpanel_livro_vertical_alignment.add(altera_jpanel_livro_horizontal_alignment);
		altera_jpanel_livro_vertical_alignment.add(altera_jpanel_livro_horizontal_alignment_wrapper);


		// editora
		JPanel altera_jpanel_editora_vertical_alignment_panel = new JPanel();
		altera_jpanel_editora_vertical_alignment_panel.setLayout(new BoxLayout(altera_jpanel_editora_vertical_alignment_panel, BoxLayout.PAGE_AXIS));

		JPanel altera_jpanel_editora_horizontal_alignment = new JPanel();
		altera_jpanel_editora_horizontal_alignment.setLayout(new BoxLayout(altera_jpanel_editora_horizontal_alignment, BoxLayout.LINE_AXIS));

		altera_jpanel_editora_vertical_alignment_panel.add(altera_jpanel_editora_horizontal_alignment);

		altera_jpanel_editora_horizontal_alignment.add(altera_jtextfield_editora_nome);
		altera_jpanel_editora_horizontal_alignment.add(altera_jtextfield_editora_site);


		// autor
		JPanel altera_jpanel_autor_vertical_alignment = new JPanel();
		altera_jpanel_autor_vertical_alignment.setLayout(new BoxLayout(altera_jpanel_autor_vertical_alignment, BoxLayout.PAGE_AXIS));

		JPanel altera_jpanel_autor_horizontal_alignment = new JPanel();
		altera_jpanel_autor_horizontal_alignment.setLayout(new BoxLayout(altera_jpanel_autor_horizontal_alignment, BoxLayout.LINE_AXIS));

		altera_jpanel_autor_vertical_alignment.add(altera_jpanel_autor_horizontal_alignment);

		altera_jpanel_autor_horizontal_alignment.add(altera_jtextfield_autor_nome);
		altera_jpanel_autor_horizontal_alignment.add(altera_jtextfield_autor_sobrenome);


		altera_jpanel_cardlayout_panel.add(altera_jpanel_livro_vertical_alignment, "Livro");
		altera_jpanel_cardlayout_panel.add(altera_jpanel_editora_vertical_alignment_panel, "Editora");
		altera_jpanel_cardlayout_panel.add(altera_jpanel_autor_vertical_alignment, "Autor");


		// Adicionar item listener aos radiobuttons, para mudar o jpanel template de acordo
		altera_jcheckbox_select_autor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				CardLayout cl = (CardLayout)(altera_jpanel_cardlayout_panel.getLayout());
				cl.show(altera_jpanel_cardlayout_panel, "Autor");
			}
		});

		altera_jcheckbox_select_editora.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				CardLayout cl = (CardLayout)(altera_jpanel_cardlayout_panel.getLayout());
				cl.show(altera_jpanel_cardlayout_panel, "Editora");

			}
		});

		altera_jcheckbox_select_livro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				CardLayout cl = (CardLayout)(altera_jpanel_cardlayout_panel.getLayout());
				cl.show(altera_jpanel_cardlayout_panel, "Livro");

			}
		});

		altera_jbutton_run_busca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altera_jpanel_return_busca_result.removeAll();

				exclui_list_jradiobutton_result.clear();

				ButtonGroup radio_buttons_group = new ButtonGroup();

				if (altera_jcheckbox_select_autor.isSelected()) {
					for (Autor crnt_autor : tst_autores_list) {
						JRadioButton crnt_autor_button = new JRadioButton(crnt_autor.getNome());
						crnt_autor_button.setAlignmentX(CENTER_ALIGNMENT);

						radio_buttons_group.add(crnt_autor_button);
						altera_list_jradiobuttons.add(crnt_autor_button);
						altera_jpanel_return_busca_result.add(crnt_autor_button);

						System.out.println(crnt_autor);
					}

				} else if (altera_jcheckbox_select_livro.isSelected()) {
					for (Livro crnt_livro : tst_livros_list) {
						JRadioButton crnt_livro_button = new JRadioButton(crnt_livro.getNome());
						crnt_livro_button.setAlignmentX(CENTER_ALIGNMENT);

						radio_buttons_group.add(crnt_livro_button);
						altera_list_jradiobuttons.add(crnt_livro_button);
						altera_jpanel_return_busca_result.add(crnt_livro_button);

						System.out.println(crnt_livro);
					}

				} else if (altera_jcheckbox_select_editora.isSelected()) {
					for (Editora crnt_editora : tst_editoras_list) {
						JRadioButton crnt_editora_button = new JRadioButton(crnt_editora.getNome());
						crnt_editora_button.setAlignmentX(CENTER_ALIGNMENT);

						radio_buttons_group.add(crnt_editora_button);
						altera_list_jradiobuttons.add(crnt_editora_button);
						altera_jpanel_return_busca_result.add(crnt_editora_button);

						System.out.println(crnt_editora);
					}
				}


				exclui_jpanel_return_busca_results.revalidate();
				exclui_jpanel_return_busca_results.repaint();
			}
		});

		panel.add(altera_jbutton_run_busca);
		panel.add(button_panel);
		panel.add(altera_jbutton_run);
		panel.add(altera_jpanel_cardlayout_panel);
		panel.add(altera_jpanel_return_busca_result);


		return panel;
	}



	// INCLUI
	private JPanel createIncluiJPanel() {
		// variaveis globais

		inclui_jbutton_run = new JButton("Executar Inclusão");
		inclui_jbutton_run.setAlignmentX(CENTER_ALIGNMENT);

		inclui_jcheckbox_select_autor = new JCheckBox("Autor");
		inclui_jcheckbox_select_editora = new JCheckBox("Editora");
		inclui_jcheckbox_select_livro = new JCheckBox("Livro");
		inclui_jpanel_cardlayout_panel = new JPanel();

		inclui_jpanel_autores_comboboxes_wrapper = new JPanel();
		inclui_jpanel_autores_comboboxes_wrapper.setLayout(new BoxLayout(inclui_jpanel_autores_comboboxes_wrapper, BoxLayout.LINE_AXIS));

		inclui_jpanel_mother_panel_autor = new JPanel();
		inclui_jpanel_mother_panel_autor.setLayout(new BoxLayout(inclui_jpanel_mother_panel_autor, BoxLayout.PAGE_AXIS));

		inclui_jpanel_autor_alinhamento_horizontal = new JPanel();
		inclui_jpanel_autor_alinhamento_horizontal.setLayout(new BoxLayout(inclui_jpanel_autor_alinhamento_horizontal, BoxLayout.LINE_AXIS));

		inclui_jpanel_mother_panel_editora = new JPanel();
		inclui_jpanel_mother_panel_editora.setLayout(new BoxLayout(inclui_jpanel_mother_panel_editora, BoxLayout.PAGE_AXIS));

		inclui_jpanel_editora_alinhamento_horizontal = new JPanel();
		inclui_jpanel_editora_alinhamento_horizontal.setLayout(new BoxLayout(inclui_jpanel_editora_alinhamento_horizontal, BoxLayout.LINE_AXIS));

		inclui_jpanel_mother_panel_livro = new JPanel();
		inclui_jpanel_mother_panel_livro.setLayout(new BoxLayout(inclui_jpanel_mother_panel_livro, BoxLayout.PAGE_AXIS));

		inclui_jpanel_livro_alinhamento_horizontal = new JPanel();
		inclui_jpanel_livro_alinhamento_horizontal.setLayout(new BoxLayout(inclui_jpanel_livro_alinhamento_horizontal, BoxLayout.LINE_AXIS));

		inclui_vector_combobox_opcoes_editora = new Vector();
		inclui_vector_combobox_opcoes_autor = new Vector();

		inclui_jtextfield_autor_nome = new JTextField("Nome", 20);
		inclui_jtextfield_autor_nome.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jtextfield_autor_nome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		inclui_jtextfield_autor_sobrenome = new JTextField("Sobrenome", 20);
		inclui_jtextfield_autor_sobrenome.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jtextfield_autor_sobrenome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		inclui_jtextfield_editora_nome = new JTextField("Nome", 20);
		inclui_jtextfield_editora_nome.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jtextfield_editora_nome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		inclui_jtextfield_editora_site = new JTextField("Site", 20);
		inclui_jtextfield_editora_site.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jtextfield_editora_site.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		inclui_jtextfield_livro_isbn = new JTextField("ISBN", 20);
		inclui_jtextfield_livro_isbn.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jtextfield_livro_isbn.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		inclui_jtextfield_livro_nome = new JTextField("Nome", 20);
		inclui_jtextfield_livro_nome.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jtextfield_livro_nome.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		inclui_jcombobox_opcoes_editora = new JComboBox(new DefaultComboBoxModel(inclui_vector_combobox_opcoes_editora));
		inclui_jcombobox_opcoes_editora.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jcombobox_opcoes_editora.setMaximumSize(busca_jtextfield_input.getPreferredSize());

		inclui_jcombobox_opcoes_autor = new JComboBox(new DefaultComboBoxModel(inclui_vector_combobox_opcoes_autor));
		inclui_jcombobox_opcoes_autor.setAlignmentX(CENTER_ALIGNMENT);
		inclui_jcombobox_opcoes_autor.setMaximumSize(busca_jtextfield_input.getPreferredSize());
		//inclui_jcombobox_opcoes_autor.addActionListener(new inclui_action_listener(inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor, inclui_jpanel_autores_comboboxes_wrapper, tst_autores_list, busca_jtextfield_input));

		inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor = new LinkedHashMap<>();


		// panel principal
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JPanel button_panel = new JPanel();
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.LINE_AXIS));

		ButtonGroup button_panel_group = new ButtonGroup();
		button_panel_group.add(inclui_jcheckbox_select_autor);
		button_panel_group.add(inclui_jcheckbox_select_editora);
		button_panel_group.add(inclui_jcheckbox_select_livro);

		button_panel.add(inclui_jcheckbox_select_autor);
		button_panel.add(inclui_jcheckbox_select_editora);
		button_panel.add(inclui_jcheckbox_select_livro);

		// autor
		inclui_jpanel_mother_panel_autor.add(inclui_jpanel_autor_alinhamento_horizontal);
		inclui_jpanel_autor_alinhamento_horizontal.add(inclui_jtextfield_autor_nome);
		inclui_jpanel_autor_alinhamento_horizontal.add(inclui_jtextfield_autor_sobrenome);

		// editora
		inclui_jpanel_mother_panel_editora.add(inclui_jpanel_editora_alinhamento_horizontal);
		inclui_jpanel_editora_alinhamento_horizontal.add(inclui_jtextfield_editora_nome);
		inclui_jpanel_editora_alinhamento_horizontal.add(inclui_jtextfield_editora_site);


		// livro
		inclui_jpanel_mother_panel_livro.add(inclui_jpanel_livro_alinhamento_horizontal);

		// Populando o combobox de seleção da editora
		for (Editora editora : tst_editoras_list) {
			inclui_vector_combobox_opcoes_editora.add(editora);
		}

		// Populando o combobox de seleção dos autores
		inclui_vector_combobox_opcoes_autor.add(null);
		for (Autor autor : tst_autores_list) {
			inclui_vector_combobox_opcoes_autor.add(autor);
		}

		// Incluindo o primeiro combobox no Map de comboboxes de seleção dos autores
		//inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor.put(inclui_jcombobox_opcoes_autor, new LinkedHashMap<Boolean, JPanel>(){{put(true, inclui_jpanel_autores_comboboxes_wrapper);}});
		inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor.put(inclui_jcombobox_opcoes_autor, true);


		inclui_jpanel_autores_comboboxes_wrapper.add(inclui_jcombobox_opcoes_autor);

		inclui_jpanel_livro_alinhamento_horizontal.add(inclui_jtextfield_livro_isbn);
		inclui_jpanel_livro_alinhamento_horizontal.add(inclui_jtextfield_livro_nome);
		inclui_jpanel_livro_alinhamento_horizontal.add(inclui_jcombobox_opcoes_editora);
		inclui_jpanel_livro_alinhamento_horizontal.add(inclui_jpanel_autores_comboboxes_wrapper);

		// Jpanel do card layout, que ira possibilitar a alternancia entre os 3 panels de edição(livro, editora, autor)
		inclui_jpanel_cardlayout_panel.setLayout(new CardLayout());
		inclui_jpanel_cardlayout_panel.add(inclui_jpanel_mother_panel_livro, "Livro");
		inclui_jpanel_cardlayout_panel.add(inclui_jpanel_mother_panel_editora, "Editora");
		inclui_jpanel_cardlayout_panel.add(inclui_jpanel_mother_panel_autor, "Autor");


		// Adicionar item listener aos radiobuttons, para mudar o jpanel template de acordo
		inclui_jcheckbox_select_autor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				CardLayout cl = (CardLayout)(inclui_jpanel_cardlayout_panel.getLayout());
				cl.show(inclui_jpanel_cardlayout_panel, "Autor");
			}
		});

		inclui_jcheckbox_select_editora.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				CardLayout cl = (CardLayout)(inclui_jpanel_cardlayout_panel.getLayout());
				cl.show(inclui_jpanel_cardlayout_panel, "Editora");

			}
		});

		inclui_jcheckbox_select_livro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				CardLayout cl = (CardLayout)(inclui_jpanel_cardlayout_panel.getLayout());
				cl.show(inclui_jpanel_cardlayout_panel, "Livro");

			}
		});

		// Action listener para o botão principal de execução do painel de inclusão
		inclui_jbutton_run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(inclui_jcheckbox_select_autor.isSelected()){
					System.out.println("autor");

					System.out.println(inclui_jtextfield_autor_nome.getText());
					System.out.println(inclui_jtextfield_autor_sobrenome.getText());


				} else if (inclui_jcheckbox_select_editora.isSelected()) {
					System.out.println("editora");

					System.out.println(inclui_jtextfield_editora_nome.getText());
					System.out.println(inclui_jtextfield_editora_site.getText());

				} else if (inclui_jcheckbox_select_livro.isSelected()) {
					System.out.println("livro");

					System.out.println(inclui_jtextfield_livro_isbn.getText());
					System.out.println(inclui_jtextfield_livro_nome.getText());
					System.out.println(inclui_jcombobox_opcoes_editora.getSelectedItem());

					for (JComboBox crnt_combobox : inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor.keySet()) {
						System.out.println(crnt_combobox.getSelectedItem());
					}

				}

			}
		});

		inclui_jcombobox_opcoes_autor.addActionListener(new inclui_action_listener(inclui_map_jcombobox_boolean_todos_jcomboboxes_de_autor, inclui_jpanel_autores_comboboxes_wrapper, tst_autores_list, busca_jtextfield_input));

		// Adicionando tudo ao painel principal
		panel.add(inclui_jbutton_run);
		panel.add(button_panel);
		panel.add(inclui_jpanel_cardlayout_panel);

		return panel;
	}


	// EXCLUI
	private JPanel createExcluiJPanel() {
		// variaveis globais
		exclui_jbutton_run = new JButton("Executar Exclusão");
		exclui_jbutton_run.setAlignmentX(CENTER_ALIGNMENT);

		exclui_jbutton_run_busca = new JButton("Executar Busca");
		exclui_jbutton_run_busca.setAlignmentX(CENTER_ALIGNMENT);

		exclui_jpanel_return_busca_results = new JPanel();
		exclui_jpanel_return_busca_results.setLayout(new BoxLayout(exclui_jpanel_return_busca_results, BoxLayout.PAGE_AXIS));

		exclui_jtextfield_busca_input = new JTextField("", 100);
		exclui_jtextfield_busca_input.setAlignmentX(CENTER_ALIGNMENT);
		exclui_jtextfield_busca_input.setMaximumSize(busca_jtextfield_input.getPreferredSize());


		exclui_jcheckbox_select_autor = new JCheckBox("Autor");
		exclui_jcheckbox_select_editora = new JCheckBox("Editora");
		exclui_jcheckbox_select_livro = new JCheckBox("Livro");
		exclui_list_jradiobutton_result = new ArrayList<JRadioButton>();


		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JPanel button_panel = new JPanel();
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.LINE_AXIS));

		ButtonGroup button_panel_group = new ButtonGroup();
		button_panel_group.add(exclui_jcheckbox_select_autor);
		button_panel_group.add(exclui_jcheckbox_select_livro);
		button_panel_group.add(exclui_jcheckbox_select_editora);

		button_panel.add(exclui_jcheckbox_select_autor);
		button_panel.add(exclui_jcheckbox_select_livro);
		button_panel.add(exclui_jcheckbox_select_editora);


		// BUSCA DENTRO DA TAB 'EXCLUI'
		exclui_jbutton_run_busca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exclui_jpanel_return_busca_results.removeAll();
				exclui_list_jradiobutton_result.clear();

				ButtonGroup radio_buttons_group = new ButtonGroup();

				if (exclui_jcheckbox_select_autor.isSelected()) {
					for (Autor crnt_autor : tst_autores_list) {

						JRadioButton crnt_autor_button = new JRadioButton(crnt_autor.getNome());
						crnt_autor_button.setAlignmentX(CENTER_ALIGNMENT);

						radio_buttons_group.add(crnt_autor_button);

						exclui_list_jradiobutton_result.add(crnt_autor_button);
						exclui_jpanel_return_busca_results.add(crnt_autor_button);

						System.out.println(crnt_autor);
					}

				} else if (exclui_jcheckbox_select_livro.isSelected()) {
					for (Livro crnt_livro : tst_livros_list) {

						JRadioButton crnt_livro_button = new JRadioButton(crnt_livro.getNome());
						crnt_livro_button.setAlignmentX(CENTER_ALIGNMENT);

						radio_buttons_group.add(crnt_livro_button);

						exclui_list_jradiobutton_result.add(crnt_livro_button);
						exclui_jpanel_return_busca_results.add(crnt_livro_button);

						System.out.println(crnt_livro);
					}

				} else if (exclui_jcheckbox_select_editora.isSelected()) {
					for (Editora crnt_editora : tst_editoras_list) {

						JRadioButton crnt_editora_button = new JRadioButton(crnt_editora.getNome());
						crnt_editora_button.setAlignmentX(CENTER_ALIGNMENT);

						radio_buttons_group.add(crnt_editora_button);

						exclui_list_jradiobutton_result.add(crnt_editora_button);
						exclui_jpanel_return_busca_results.add(crnt_editora_button);

						System.out.println(crnt_editora);
					}
				}


				exclui_jpanel_return_busca_results.revalidate();
				exclui_jpanel_return_busca_results.repaint();
			}
		});


		// EXCLUIR DENTRO DA TAB 'EXCLUI'
		exclui_jbutton_run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// para poder continuar usando um 'for each'
				int index = 0;
				for (JRadioButton crnt_button : exclui_list_jradiobutton_result) {

					if (crnt_button.isSelected()) {
						System.out.println(index);
					}

					index++;
				}
			}
		});


		panel.add(exclui_jbutton_run_busca);
		panel.add(button_panel);
		panel.add(exclui_jtextfield_busca_input);
		panel.add(exclui_jbutton_run);
		panel.add(exclui_jpanel_return_busca_results);

		return panel;
	}

	public static void main (String[] args) {
		new JanelaPrincipal();
	}

}


class inclui_action_listener implements ActionListener {
	Map<JComboBox, Boolean> jcheckbox_map;
	JPanel jpanel_for_jcheckbox;
	List<Autor> autores_list;
	JTextField size_reference;

	public inclui_action_listener(Map<JComboBox, Boolean> jcheckbox_map, JPanel jpanel_for_jcheckbox, List<Autor> autores_list, JTextField size_reference) {
		this.jcheckbox_map = jcheckbox_map;
		this.jpanel_for_jcheckbox = jpanel_for_jcheckbox;
		this.autores_list = autores_list;
		this.size_reference = size_reference;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(jcheckbox_map);
		for (JComboBox crnt_combobox : jcheckbox_map.keySet()) {
			if (e.getSource() == crnt_combobox) {
				if (jcheckbox_map.get(crnt_combobox)) {

					Vector tmp_vector = new Vector();
					tmp_vector.add(null);

					for (Autor autor : autores_list) {
						tmp_vector.add(autor);
					}

					JComboBox tmp_combobox = new JComboBox(tmp_vector);
					jcheckbox_map.put(tmp_combobox, true);
					jpanel_for_jcheckbox.add(tmp_combobox);

					tmp_combobox.addActionListener(this);
					tmp_combobox.setAlignmentX(JFrame.CENTER_ALIGNMENT);
					tmp_combobox.setMaximumSize(size_reference.getPreferredSize());

					jpanel_for_jcheckbox.revalidate();
					jpanel_for_jcheckbox.repaint();

					jcheckbox_map.put(crnt_combobox, false);
				}
			}
		}
	}
}