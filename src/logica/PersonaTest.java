package logica;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test 
	public void interesMusicalValido() {
		Persona p = new Persona("nombre", 4,5,4,3);
		assertTrue(p.valorInteres("musical")> 0);
	}
	/*(expected = IllegalArgumentException.class)*/
}
