package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import entidades.PersonaDto;
import modelo.Persona;

public class ClienteListar extends JInternalFrame {
	private JTable table;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	private JPanel panel;
	private ArrayList<PersonaDto> lista;
	private Ventana ventana;

	/**
	 * Create the frame.
	 */
	public ClienteListar(Ventana ven) {
		this.ventana = ven;
		setClosable(true);
		table = new JTable();

		dtm = new DefaultTableModel();
		setTitle("Lista Clientes");
		setBounds(50, 0, 800, 600);
		getContentPane().setLayout(null);

		dtm.addColumn("ID");
		dtm.addColumn("Edad");
		dtm.addColumn("Nombre");

		// String column[] = { "ID", "NAME", "SALARY" };

		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 48, 600, 219);
		getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(dtm);
		/* seleccione de una sola fila */
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		panel = new JPanel();
		panel.setBounds(73, 304, 600, 86);
		getContentPane().add(panel);

		JButton btnEliminar = new JButton("Eliminar");

		panel.add(btnEliminar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		panel.add(btnEditar);
		cargarDatos();
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				recargar();
				// borrarTodo();
			}

		});
	}

	protected void eliminar() {
		// TODO Auto-generated method stub
		int fila = table.getSelectedRow();
		int id = lista.get(fila).getId();
		JOptionPane.showMessageDialog(null, "Persona creada con id:" + id);
		if (fila >= 0) {
			try {
				int input = JOptionPane.showConfirmDialog(null, "quieres eliminar a la persona cliente con id: " + id);
				// 0=yes, 1=no, 2=cancel
				if (input == 0) {
					Persona persona = new Persona();
					persona.setId(id);
					boolean res = persona.eliminar();
					recargar();
					if (res) {
						JOptionPane.showMessageDialog(null, "Persona eliminada id:" + id);
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void editar() {
		// TODO Auto-generated method stub
		int fila = table.getSelectedRow();
		int id = lista.get(fila).getId();
		JOptionPane.showMessageDialog(null, "Persona creada con id:" + id);
		PersonaDto dto = lista.get(fila);
		this.ventana.verEditarCliente(dto);

	}

	private void cargarDatos() {
		try {
			Persona persona = new Persona();
			lista = persona.listar();
			for (PersonaDto item : lista) {
				String[] fila = new String[3];
				fila[0] = String.valueOf(item.getId());
				fila[1] = String.valueOf(item.getEdad());
				fila[2] = String.valueOf(item.getNombre());
				dtm.addRow(fila);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void borrarTodo() {
		// TODO Auto-generated method stub
		int cant = table.getRowCount();
		for (int i = cant - 1; i >= 0; i--) {
			dtm.removeRow(i);
		}
	}

	public void recargar() {
		borrarTodo();
		cargarDatos();
	}

}
