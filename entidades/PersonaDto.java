package entidades;

public class PersonaDto {
	private int id;
	private int edad;
	private String nombre;

	public PersonaDto(int id, int edad, String nombre) {
		super();
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
	}

	public PersonaDto(int id, String nombre, int edad) {

		this(id, edad, nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
