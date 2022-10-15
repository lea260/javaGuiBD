package persistencia;

import java.util.ArrayList;

import entidades.PersonaDto;

public class FakeRepositorioPersona implements IPersona {

	@Override
	public ArrayList<PersonaDto> listar() {
		// TODO Auto-generated method stub
		ArrayList<PersonaDto> lista = new ArrayList<PersonaDto>();
		Singleton sin = Singleton.getInstancia();
		lista = sin.listarP();
		return lista;
	}

	@Override
	public int crear(PersonaDto persona) {
		// TODO Auto-generated method stub
		ArrayList<PersonaDto> lista = new ArrayList<PersonaDto>();
		Singleton sin = Singleton.getInstancia();
		lista = sin.listarP();
		persona.setId(Singleton.PersonaId++);
		lista.add(persona);
		return persona.getId();
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		boolean encontrado = false;
		ArrayList<PersonaDto> lista = new ArrayList<PersonaDto>();
		Singleton sin = Singleton.getInstancia();
		lista = sin.listarP();
		int i = 0;
		int pos = 0;
		while (!encontrado && i < lista.size()) {
			if (lista.get(i).getId() == id) {
				encontrado = true;
				pos = i;
			}
			i++;
		}
		if (encontrado) {
			lista.remove(pos);
		}
		return encontrado;
	}

	@Override
	public boolean actualizar(PersonaDto persona) {
		// TODO Auto-generated method stub
		boolean encontrado = false;
		ArrayList<PersonaDto> lista = new ArrayList<PersonaDto>();
		Singleton sin = Singleton.getInstancia();
		lista = sin.listarP();
		int i = 0;
		int pos = 0;
		while (!encontrado && i < lista.size()) {
			if (lista.get(i).getId() == persona.getId()) {
				encontrado = true;
				pos = i;
			}
			i++;
		}
		if (encontrado) {
			lista.get(pos).setEdad(persona.getEdad());
			lista.get(pos).setNombre(persona.getNombre());
		}
		return encontrado;
	}

}
