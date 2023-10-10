package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Set;
import java.awt.Color;
import javax.swing.JPanel;
import logica.*;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal {

	private JFrame frame;
	private JTextField nombreInput;
	private JTextField musicalInput;
	private JTextField deportivoInput;
	private JTextField espectaculoInput;
	private JTextField cienciaInput;
	private DefaultTableModel model;
	private DefaultTableModel model_g1;
	private DefaultTableModel model_g2;

	private ArrayList<Persona> personas;

	private Grafo g;

	String nombre;
	int idPersona = 0;
	int dI;
	int eI;
	int mI;
	int cI;
	private JTable table;
	private JTable table_g2;
	private JTable table_g1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FramePrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JButton btnGenerarSimilitudes = new JButton("Generar Similitudes");
		JPanel panelListaPersonas = new JPanel();
		personas = new ArrayList<Persona>();
		// ------------ Frame Principal -----------------
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(168, 187, 255));
		frame.setBounds(100, 100, 1340, 801);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Clustering humano");
		lblNewLabel.setBounds(412, 11, 315, 68);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 42));

		JLabel lblNewLabel_1 = new JLabel("Lista de Personas");
		lblNewLabel_1.setBounds(520, 85, 207, 43);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 25));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Agregar Nueva Persona");
		lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1_1.setBounds(51, 85, 283, 43);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Lista de Similitudes");
		lblNewLabel_1_2.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(991, 85, 223, 34);
		frame.getContentPane().add(lblNewLabel_1_2);

		// ------------FIN Frame Principal -----------------

		// ------------ Panel Agregar Personas -----------------

		JPanel panelAgregarPersonas = new JPanel();
		panelAgregarPersonas.setBackground(new Color(0, 128, 255));
		panelAgregarPersonas.setBounds(25, 139, 323, 568);
		frame.getContentPane().add(panelAgregarPersonas);
		panelAgregarPersonas.setLayout(null);

		nombreInput = new JTextField();
		nombreInput.setBounds(31, 40, 264, 31);
		panelAgregarPersonas.add(nombreInput);
		nombreInput.setColumns(10);

		musicalInput = new JTextField();
		musicalInput.setColumns(10);
		musicalInput.setBounds(31, 129, 264, 31);
		panelAgregarPersonas.add(musicalInput);

		deportivoInput = new JTextField();
		deportivoInput.setColumns(10);
		deportivoInput.setBounds(31, 216, 264, 31);
		panelAgregarPersonas.add(deportivoInput);

		espectaculoInput = new JTextField();
		espectaculoInput.setColumns(10);
		espectaculoInput.setBounds(31, 309, 264, 31);
		panelAgregarPersonas.add(espectaculoInput);

		cienciaInput = new JTextField();
		cienciaInput.setColumns(10);
		cienciaInput.setBounds(31, 394, 264, 31);
		panelAgregarPersonas.add(cienciaInput);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(137, 15, 94, 14);
		panelAgregarPersonas.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Interes Musical");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(101, 105, 143, 14);
		panelAgregarPersonas.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Interes deportivo");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(88, 191, 143, 14);
		panelAgregarPersonas.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Interes en Espectaculos");
		lblNewLabel_2_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(74, 273, 200, 14);
		panelAgregarPersonas.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Interes en Ciencia");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1.setBounds(91, 369, 170, 14);
		panelAgregarPersonas.add(lblNewLabel_2_1_1_1_1);

		JButton agregarPersonaButton = new JButton("Agregar Persona");
		agregarPersonaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		agregarPersonaButton.setBackground(new Color(0, 255, 0));
		agregarPersonaButton.setBounds(10, 506, 303, 41);
		agregarPersonaButton.addActionListener(e -> {

			nombre = nombreInput.getText();
			dI = Integer.parseInt(deportivoInput.getText());
			eI = Integer.parseInt(espectaculoInput.getText());
			mI = Integer.parseInt(musicalInput.getText());
			cI = Integer.parseInt(cienciaInput.getText());

			personas.add(new Persona(nombre, mI, cI, dI, eI));

			limpiarCampos(); // limpia los campos de texto

			// agregamos la persona a la tabla
			agregarPersonaATabla(personas.get(personas.size() - 1).info());

			// cambiamos el texto del boton
			agregarPersonaButton.setBackground(new Color(0, 255, 0));
			agregarPersonaButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			agregarPersonaButton.setText("Agregado Correctamente !!");

			System.out.println(personas.get(personas.size() - 1).info());
			// borrar el texto del boton despues de 2 segundos
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					agregarPersonaButton.setText("Agregar Persona");
					agregarPersonaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
					agregarPersonaButton.setBackground(new Color(0, 255, 0));
				}
			}, 2000);

		});
		panelAgregarPersonas.add(agregarPersonaButton);

		JButton limpiarCamposButton = new JButton("Limpiar Campos");
		limpiarCamposButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		limpiarCamposButton.setForeground(new Color(0, 0, 0));
		limpiarCamposButton.setBackground(new Color(255, 128, 64));
		limpiarCamposButton.setBounds(88, 461, 149, 23);
		limpiarCamposButton.addActionListener(e -> {
			limpiarCampos();
			agregarPersonaButton.setBackground(new Color(0, 255, 0));
			agregarPersonaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			agregarPersonaButton.setText("Agregar Persona");

		});
		panelAgregarPersonas.add(limpiarCamposButton);

		// ------------FIN Panel Agregar Personas -----------------

		// ------------ Panel Lista de Personas -----------------

		panelListaPersonas.setBorder(null);
		panelListaPersonas.setBackground(new Color(255, 255, 128));
		panelListaPersonas.setBounds(358, 139, 513, 568);
		frame.getContentPane().add(panelListaPersonas);
		panelListaPersonas.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelListaPersonas.add(scrollPane, "name_30036416860000");

		table = new JTable();
		table.setRowMargin(0);
		table.setEnabled(false);
		table.setDragEnabled(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(false);
		model = new DefaultTableModel();
		table.setModel(model);
		table.setFillsViewportHeight(true);

		model.addColumn("Nombre");
		model.addColumn("I. Deportivo");
		model.addColumn("I. Espectaculo");
		model.addColumn("I. Musical");
		model.addColumn("I. Ciencia");
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.repaint();

		// ------------FIN Panel Lista de Personas -----------------

		// ------------ Panel Lista de Similitudes -----------------

		// PANEL PRINCIPAL DE SIMILITUD

		// GRUPO 1 *******
		JPanel panelListaSimilitudGrupo1 = new JPanel();
		panelListaSimilitudGrupo1.setBounds(895, 139, 404, 268);
		frame.getContentPane().add(panelListaSimilitudGrupo1);
		panelListaSimilitudGrupo1.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panelListaSimilitudGrupo1.add(scrollPane_1, "name_10468837110600");
		table_g1 = new JTable();
		table_g1.setRowMargin(0);
		table_g1.setEnabled(false);
		table_g1.setDragEnabled(true);
		table_g1.setCellSelectionEnabled(true);
		table_g1.setColumnSelectionAllowed(true);
		table_g1.setRowSelectionAllowed(false);
		model_g1 = new DefaultTableModel();
		table_g1.setModel(model_g1);
		table_g1.setFillsViewportHeight(true);

		model_g1.addColumn("Nombre");
		model_g1.addColumn("I. Deportivo");
		model_g1.addColumn("I. Espectaculo");
		model_g1.addColumn("I. Musical");
		model_g1.addColumn("I. Ciencia");

		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPane_1.setViewportView(table_g1);
		scrollPane_1.repaint();

		// FIN GRUPO 1 *******

		// GRUPO 2 *******

		JPanel panelListaSimilitudGrupo2 = new JPanel();
		panelListaSimilitudGrupo2.setBounds(895, 439, 404, 268);
		frame.getContentPane().add(panelListaSimilitudGrupo2);
		panelListaSimilitudGrupo2.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelListaSimilitudGrupo2.add(scrollPane_2, "name_10477293565800");

		table_g2 = new JTable();
		table_g2.setRowMargin(0);
		table_g2.setEnabled(false);
		table_g2.setDragEnabled(true);
		table_g2.setCellSelectionEnabled(true);
		table_g2.setColumnSelectionAllowed(true);
		table_g2.setRowSelectionAllowed(false);
		model_g2 = new DefaultTableModel();
		scrollPane_2.setViewportView(table_g2);
		table_g2.setModel(model_g2);
		table_g2.setFillsViewportHeight(true);

		model_g2.addColumn("Nombre");
		model_g2.addColumn("I. Deportivo");
		model_g2.addColumn("I. Espectaculo");
		model_g2.addColumn("I. Musical");
		model_g2.addColumn("I. Ciencia");

		// FIN GRUPO 2 *******

		// BOTON GENERAR SIMILITUDES

		btnGenerarSimilitudes.setBackground(new Color(0, 0, 0));
		btnGenerarSimilitudes.setForeground(new Color(255, 255, 255));
		btnGenerarSimilitudes.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		btnGenerarSimilitudes.setBounds(980, 44, 244, 35);
		frame.getContentPane().add(btnGenerarSimilitudes);

		JLabel lblNewLabel_3 = new JLabel("GRUPO 1");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(1071, 119, 70, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("GRUPO 2");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3_1.setBounds(1071, 414, 70, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		// FIN BOTON GENERAR SIMILITUDES

		btnGenerarSimilitudes.addActionListener(e -> {
			if (personas.size() > 2) {
				g = new Grafo(personas.size());
				g.agregarVecinos(personas);

				AGM agm = new AGM(g);
				agm.construirArbol();

				Grafo aux = agm.dameGrafoAGM();
				Point arista = aux.verticesRelacionado(aux.pesoMax());

				aux.eliminarArista(arista.x, arista.y);

				Set<Integer> grupo1 = BFS.alcanzables(aux, arista.x);
				Set<Integer> grupo2 = BFS.alcanzables(aux, arista.y);

				for (Integer i : grupo1) {
					agregarPersonaATablaGrupo1(personas.get(i).info());
				}

				for (Integer i : grupo2) {
					agregarPersonaATablaGrupo2(personas.get(i).info());
				}

			}

		});

		// ------------FIN Panel Lista de Similitudes -----------------

		/* Funciones Auxiliares */

	}

	public void agregarPersonaATabla(String infoCompleta) {

		String[] info = infoCompleta.split(" ");
		model.addRow(new Object[] { info[0], info[1], info[2], info[3], info[4] });

	}

	public void agregarPersonaATablaGrupo1(String infoCompleta) {
		String[] info = infoCompleta.split(" ");
		System.out.println(info[0] + " " + info[1] + " " + info[2] + " " + info[3] + " " + info[4]);
		model_g1.addRow(new Object[] { info[0], info[1], info[2], info[3], info[4] });
	}

	public void agregarPersonaATablaGrupo2(String infoCompleta) {
		String[] info = infoCompleta.split(" ");
		System.out.println(info[0] + " " + info[1] + " " + info[2] + " " + info[3] + " " + info[4]);
		model_g2.addRow(new Object[] { info[0], info[1], info[2], info[3], info[4] });
	}

	public void limpiarCampos() {
		nombreInput.setText("");
		musicalInput.setText("");
		deportivoInput.setText("");
		espectaculoInput.setText("");
		cienciaInput.setText("");
	}
}
