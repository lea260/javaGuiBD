package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.PersonaDto;
import gui.AgregarCliente.Modo;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JDesktopPane dk;
	private JMenu mnCliente;
	private JMenuItem mnitClienteListar;
	private JMenuBar menuBar;
	private JMenuItem mnitClientesListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCliente = new JMenu("Cliente");

		menuBar.add(mnCliente);

		mnitClientesListar = new JMenuItem("Listar");
		mnitClientesListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostarVentanaClientes();
			}

		});
		mnCliente.add(mnitClientesListar);

		JMenuItem mnitAgregarCliente = new JMenuItem("AgregarCliente");
		mnitAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verAgregarCliente();
			}

		});
		mnCliente.add(mnitAgregarCliente);

		mnitClienteListar = new JMenuItem("Listar");
		// mnitClienteListar.addActionListener(this);
		// mnCliente.add(mnitClienteListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		dk = new JDesktopPane();
		dk.setBackground(SystemColor.activeCaption);
		contentPane.add(dk, BorderLayout.CENTER);
	}

	private void mostarVentanaClientes() {
		// TODO Auto-generated method stub
		ClienteListar ventana = new ClienteListar(this);
		ventana.setVisible(true);
		dk.add(ventana);

	}

	public void verAgregarCliente() {
		// TODO Auto-generated method stub
		AgregarCliente ventana = new AgregarCliente(Modo.AGREGAR, null);
		ventana.setVisible(true);
		dk.add(ventana);
	}

	public void verEditarCliente(PersonaDto personaDto) {
		// TODO Auto-generated method stub
		AgregarCliente ventana = new AgregarCliente(Modo.EDITAR, personaDto);
		ventana.setVisible(true);
		dk.add(ventana);
	}
}
