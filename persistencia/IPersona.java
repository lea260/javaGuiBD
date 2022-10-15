
package persistencia;

import java.util.ArrayList;

import entidades.PersonaDto;

public interface IPersona {

	ArrayList<PersonaDto> listar();
	/*
	 * retornar el id del nuevo cliente
	 */
	int crear(PersonaDto persona);
	/*
	 * elimna la Persona de id pasado como parametro post retorna true
	 * 
	 */
	boolean eliminar(int id);

	/*
	 * elimna la Persona de id pasado como parametro
	 */
	boolean actualizar(PersonaDto persona);
	
	

}
