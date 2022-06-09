package org.ramonportalanza.examenjunio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfaceCuenta extends JFrame {

	private JPanel contentPane;
	private JPanel panel_0;
	private JPanel panel_1;
	private JTextField textCuentaN;
	private JTextField textDetalle;
	private JTextField textImporte;

	private JRadioButton rbDebe;
	private JRadioButton rbHaber;
	private ButtonGroup rbDebeHaber = new ButtonGroup();

	private JRadioButton rbLocal;
	private JRadioButton rbLista;
	private ButtonGroup rbLocalJlistButtonGroup = new ButtonGroup();

	private JButton btnGuardar;
	private JLabel lblSalida;
	private JButton btnMostrar;

	private List<Cuenta> jListCuentaDebe = new ArrayList<Cuenta>();
	private List<Cuenta> jListCuentaHaber = new ArrayList<Cuenta>();

	private JLabel lblTotal;

	DefaultListModel<Cuenta> modeloListaDebe = new DefaultListModel();
	DefaultListModel<Cuenta> modeloListaHaber = new DefaultListModel();

	private String nCuenta = "", dCuenta = "", tCuenta = "";
	private Double iCuenta = 0D, totalDebe = 0D, totalHaber = 0D;
	private JList<Cuenta> CuentaJList;
	private JList<Cuenta> list;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public InterfaceCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("By Ramón 09/06/2022");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		panel_0 = new JPanel();
		panel_0.setBounds(0, 11, 486, 449);
		contentPane.add(panel_0);
		panel_0.setLayout(null);

		JLabel lblnumCta = new JLabel("Cuenta n\u00BA:");
		lblnumCta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnumCta.setBounds(42, 32, 87, 14);
		panel_0.add(lblnumCta);

		textCuentaN = new JTextField();
		textCuentaN.setFont(new Font("Tahoma", Font.BOLD, 12));
		textCuentaN.setBounds(154, 30, 274, 20);
		panel_0.add(textCuentaN);
		textCuentaN.setColumns(10);

		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalle.setBounds(42, 64, 87, 14);
		panel_0.add(lblDetalle);

		textDetalle = new JTextField();
		textDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		textDetalle.setBounds(154, 61, 274, 20);
		panel_0.add(textDetalle);
		textDetalle.setColumns(10);

		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImporte.setBounds(42, 99, 87, 14);
		panel_0.add(lblImporte);

		textImporte = new JTextField();
		textImporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		textImporte.setBounds(154, 97, 274, 20);
		panel_0.add(textImporte);
		textImporte.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo de Cuenta");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(186, 148, 118, 14);
		panel_0.add(lblTipo);

		rbDebe = new JRadioButton("DEBE");
		rbDebe.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbDebe.setBounds(139, 181, 100, 23);
		panel_0.add(rbDebe);

		rbHaber = new JRadioButton("HABER");
		rbHaber.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbHaber.setBounds(283, 181, 118, 23);
		panel_0.add(rbHaber);

		rbDebeHaber.add(rbDebe);
		rbDebeHaber.add(rbHaber);

		lblSalida = new JLabel("Tipo de Salida");
		lblSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalida.setBounds(186, 248, 118, 14);
		panel_0.add(lblSalida);

		rbLocal = new JRadioButton("LOCAL");
		rbLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbLocal.setBounds(139, 286, 107, 23);
		panel_0.add(rbLocal);

		rbLista = new JRadioButton("JList");
		rbLista.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbLista.setBounds(283, 287, 107, 23);
		panel_0.add(rbLista);

		rbLocalJlistButtonGroup.add(rbLocal);
		rbLocalJlistButtonGroup.add(rbLista);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Cuenta cuenta = new Cuenta();
				if (e.getSource() == btnGuardar) {
					cuenta.setNumeroCuenta(textCuentaN.getText());
					nCuenta = cuenta.getNumeroCuenta();

					cuenta.setDetalleCuenta(textDetalle.getText());
					dCuenta = cuenta.getDetalleCuenta();

					cuenta.setImporte(Double.parseDouble(textImporte.getText()));
					iCuenta = cuenta.getImporte();

					if (rbDebe.isSelected()) {
						cuenta.setTipoCuenta(rbDebe.getLabel());
						tCuenta = cuenta.getTipoCuenta();
						totalDebe += cuenta.getImporte();
						jListCuentaDebe.add(new Cuenta(nCuenta, dCuenta, tCuenta, iCuenta));
						rbDebe.setSelected(false);
						rbHaber.setSelected(false);
					}
					if (rbHaber.isSelected()) {
						cuenta.setTipoCuenta(rbHaber.getLabel());
						tCuenta = cuenta.getTipoCuenta();
						totalHaber += cuenta.getImporte();
						jListCuentaHaber.add(new Cuenta(nCuenta, dCuenta, tCuenta, iCuenta));
						rbDebe.setSelected(false);
						rbHaber.setSelected(false);
					}

					// System.out.println(jListCuentaDebe);
					JOptionPane.showMessageDialog(null, "Datos guardados con éxito!");

					textCuentaN.setText("");
					textDetalle.setText("");
					textImporte.setText("");
					rbDebe.setSelected(false);
					rbHaber.setSelected(false);
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(97, 380, 107, 23);
		panel_0.add(btnGuardar);

		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rbDebe.isSelected() && rbLocal.isSelected()) {
					JOptionPane.showMessageDialog(null, jListCuentaDebe + "total debe = " + totalDebe);
				}
				if (rbHaber.isSelected() && rbLocal.isSelected()) {
					JOptionPane.showMessageDialog(null, jListCuentaHaber + "total haber = " + totalHaber);
				}

				if (rbDebe.isSelected() && rbLista.isSelected()) {
					panel_0.setVisible(false);
					panel_1.setVisible(true);
					lblTotal.setText("total debe = " + totalDebe);
					for (Cuenta ctaDebe : jListCuentaDebe) {
						modeloListaDebe.addElement(ctaDebe);
					}
					CuentaJList.setModel(modeloListaDebe);
				}

				if (rbHaber.isSelected() && rbLista.isSelected()) {
					panel_0.setVisible(false);
					panel_1.setVisible(true);
					lblTotal.setText("total Haber = " + totalHaber);
					for (Cuenta ctaHaber : jListCuentaHaber) {
						modeloListaHaber.addElement(ctaHaber);
					}
					list.setModel(modeloListaHaber);
				}
			}
		});
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMostrar.setBounds(257, 381, 107, 23);
		panel_0.add(btnMostrar);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 11, 486, 449);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblTotal = new JLabel("Total: ");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(78, 355, 356, 25);
		panel_1.add(lblTotal);

		CuentaJList = new JList<Cuenta>();
		CuentaJList.setFont(new Font("Tahoma", Font.BOLD, 12));
		CuentaJList.setBounds(10, 21, 466, 157);
		panel_1.add(CuentaJList);

		list = new JList<Cuenta>();
		list.setBounds(10, 202, 466, 147);
		panel_1.add(list);

		lblNewLabel = new JLabel("DEBE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(179, 0, 126, 14);
		panel_1.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("HABER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(179, 189, 126, 14);
		panel_1.add(lblNewLabel_1);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfaceCuenta frame = new InterfaceCuenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
