package logica;

import java.util.ArrayList;

public class AGM {
	private Grafo grafo;
	private Grafo agm;
	private ArrayList<Integer> marcados;
	private ArrayList<Integer> NoMarcados;
	private int cantidadDeMarcados;

	public AGM(Grafo g) {
		cantidadDeMarcados = 0;
		grafo = g;
		agm = new Grafo(grafo.tamano());
		marcados = new ArrayList<Integer>();
		NoMarcados = new ArrayList<Integer>();
		inicializar(); // comienzo de armado del arbol

	}

	//////////////// inicializaciones /////////////////
	private void inicializar() {
		int vertice = 0;
		cargarNoMarcados();
		marcados.add(vertice); // marcamos el vertice 0 como comienzo del arbol
		NoMarcados.remove(vertice); // sacamos de los no marcados al vertice de inicio
	}

	private void cargarNoMarcados() {
		for (int i = 0; i < grafo.tamano(); i++) {
			NoMarcados.add(i);
		}

	}

	///// creacion De Un Arbol Genarador Minimo //////////
	public void construirArbol() { //

		while (cantidadDeMarcados < grafo.tamano()) {
			buscarPesoMinimo();

		}

	}
	/*
	 * -1 2 3 2 -1 -1 3 -1 -1
	 */

	/////////////// Cargar enlaces de menor distancia //////////
	private void buscarPesoMinimo() { ///////// Algoritmo de Prim
		int peso = 0;

		for (int actual = 0; actual < marcados.size(); actual++) {
			for (int noMarcado = 0; noMarcado < NoMarcados.size(); noMarcado++) {
				if (peso == 0) {
					peso = grafo.pesoArista(marcados.get(actual), NoMarcados.get(noMarcado));
				} else {

					peso = Math.min(peso, grafo.pesoArista(marcados.get(actual), NoMarcados.get(noMarcado)));
				}

			}
		}
		cantidadDeMarcados++;
		agregarEnlaceDeMenorPeso(peso);

	}

	/* arma nuevamente el arbol */
	private void agregarEnlaceDeMenorPeso(int pesoMenorElegido) {

		for (int marcado = 0; marcado < marcados.size(); marcado++) {
			for (int noMarcado = 0; noMarcado < NoMarcados.size(); noMarcado++) {
				/* agregarArista */
				if (grafo.pesoArista(marcados.get(marcado), NoMarcados.get(noMarcado)) == pesoMenorElegido) {
					agm.agregarArista(marcados.get(marcado), NoMarcados.get(noMarcado), pesoMenorElegido);
					marcados.add(NoMarcados.get(noMarcado));
					NoMarcados.remove(NoMarcados.get(noMarcado));

				}

			}
		}
	}

	public Grafo dameGrafoAGM() {
		return agm;
	}

}
