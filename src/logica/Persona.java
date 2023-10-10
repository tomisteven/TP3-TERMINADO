package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*poner emun para c*/
public class Persona {
	private enum tipoInteres {
		musical, ciencia, deporte, espectaculo
	}

	/*
	 * private static int _idPersona=0; private int _id;----> mejor uso su posicion
	 * cuando cargo las personas en una lista* desde la vista, cada posicion
	 * representa su ubicacion en el grafo / /*El tamanio del map no podra ser mas
	 * de 4, por la implementacion
	 */
	private HashMap<String, Integer> _intereses;
	private String _nombre;

	public Persona(String nombre, int valorMusica, int valorCiencia, int valorDeporte, int valorEspectaculo) {
		this._nombre = nombre;
		this._intereses = new HashMap<>();
		List<Integer> lista = crearLista(valorMusica, valorCiencia, valorDeporte, valorEspectaculo);
		agregarInteres(lista);
	}

	private List<Integer> crearLista(int valorMusica, int valorCiencia, int valorDeporte, int valorEspectaculo) {
		List<Integer> lista = new ArrayList<>();
		lista.add(valorMusica);
		lista.add(valorCiencia);
		lista.add(valorDeporte);
		lista.add(valorEspectaculo);
		return lista;
	}

	private void agregarInteres(List<Integer> valorIntereses) {
		validarValores(valorIntereses);
		int iterador = 0;
		for (tipoInteres t : tipoInteres.values()) {
			_intereses.put(String.valueOf(t), valorIntereses.get(iterador));
			iterador++;
		}
	}
	// similaridad(p1, p2) = |di − dj | + |mi − mj | + |ei − ej | + |ci − cj |
	public int calcularSimilaridad(HashMap<String, Integer> p2Intereses) {
		int peso = 0;
		Set<String> keys = p2Intereses.keySet();
		for (String key : keys) {
			peso = peso +Math.abs( _intereses.get(key) - p2Intereses.get(key));
		}
		return peso;
	}

	public String getNombre() {
		return _nombre;
	}

	private void validarValores(List<Integer> valores) {
		for (int i = 0; i < valores.size(); i++) {
			if (fueraDeRango(valores.get(i))) {
				throw new ArithmeticException("valor ingresado es incorrecto es : " + valores.get(i));
			}
		}
	}
	public HashMap<String , Integer> getIntereses()
	{
		return _intereses;
	}

	private boolean fueraDeRango(Integer valor) {
		return valor > 5 || valor < 0;
	}

	/* solo uso para el test */
	boolean existeInteres(String nombre) {
		return _intereses.containsKey(nombre);
	}

	public void determinarValorDeInteres(String nombre, int valor) {
		_intereses.put(nombre, valor);
	}

	public int valorInteres(String nombre) {
		return _intereses.get(nombre);
	}

	public boolean soloLetras(String nombre) {
		return sinSignoInvalidos(nombre);
	}

	private boolean sinSignoInvalidos(String nombre) {
		boolean ret = true;
		for (int i = 0; i < nombre.toLowerCase().length(); i++) {
			ret &= nombre.charAt(i) >= 97 && nombre.charAt(i) <= 122;
		}
		return ret;
	}


	public String info() {
		return getNombre()+ " "+ this.valorInteres("musical")+" "+ valorInteres("ciencia")
		+" "+ valorInteres("deporte")+ " " +valorInteres("espectaculo");
	}

}
