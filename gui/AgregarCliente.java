package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.PersonaDto;
import modelo.Persona;

public class AgregarCliente extends JInternalFrame {
	private JTextField textEdad;
	private JTextField textNombre;
	private JButton btnagregar;
	private PersonaDto personaDto;

	enum Modo {
		AGREGAR, EDITAR, ELIMINAR
	}

	private Modo modo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param personaDto
	 */

	public AgregarCliente(Modo modo, PersonaDto personaDto) {
		this.modo = modo;
		this.personaDto = personaDto;
		gui();
		cargarCliente();
	}

	private void cargarCliente() {
		// TODO Auto-generated method stub
		if (modo == Modo.EDITAR) {
			textEdad.setText(personaDto.getEdad() + "");
			textNombre.setText(personaDto.getNombre());
		}

	}

	private void gui() {
		// TODO Auto-generated method stub
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		setTitle("Agregar Cliente");
		setBounds(50, 0, 850, 400);
		setClosable(true);
		getContentPane().setLayout(null);

		textEdad = new JTextField();
		textEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEdad.setBounds(280, 78, 188, 20);
		getContentPane().add(textEdad);
		textEdad.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setBounds(280, 136, 188, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		btnagregar = new JButton("Agregar");
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		btnagregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnagregar.setBounds(54, 245, 141, 23);
		getContentPane().add(btnagregar);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdad.setBounds(34, 81, 149, 14);
		getContentPane().add(lblEdad);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(34, 139, 125, 14);
		getContentPane().add(lblNombre);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}

		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditar.setBounds(255, 247, 141, 23);
		getContentPane().add(btnEditar);
	}

	private void crearCliente() {
		// TODO Auto-generated method stub
		try {
			String nombre = textNombre.getText();
			String edadString = textEdad.getText();
			int edad = Integer.parseInt(edadString);
			Persona persona = new Persona(edad, nombre);
			int id = persona.crear();
			JOptionPane.showMessageDialog(null, "Persona creada con id:" + id);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "la edad no puede ser negativa");
		}
	}

	private void editarCliente() {
		// TODO Auto-generated method stub
		try {
			String nombre = textNombre.getText();
			String edadString = textEdad.getText();
			int edad = Integer.parseInt(edadString);
			Persona persona = new Persona(edad, nombre);
			persona.setId(personaDto.getId());
			// llamar a editar
			boolean id = persona.actualizar();
			JOptionPane.showMessageDialog(null, "Persona creada con id:" + id);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "la edad no puede ser negativa");
		}
	}
}
