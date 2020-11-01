package br.ies.APS.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField campoNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicio() {
		initialize();
	}

	private void initialize() {
		setTitle("Inicio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);

		JLabel lblJogoDoOito = new JLabel("Jogo do Oito");
		lblJogoDoOito.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblJogoDoOito.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblInsiraNome = new JLabel("Insira o seu nome:");
		lblInsiraNome.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnIniciarJogo = new JButton("Iniciar");

		campoNome = new JTextField();
		campoNome.setColumns(10);

		ActionListener btnIniciarJogoPressionado = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setPlayer(campoNome.getText());
				tela.setVisible(true);
				dispose();
			}
		};

		btnIniciarJogo.addActionListener(btnIniciarJogoPressionado);

		GroupLayout gl_contentPane = new GroupLayout(painel);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup()
												.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 346,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addComponent(lblJogoDoOito).addGap(105))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addComponent(lblInsiraNome).addGap(128))
								.addGroup(Alignment.TRAILING,
										gl_contentPane
												.createSequentialGroup().addComponent(btnIniciarJogo,
														GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
												.addGap(151)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblJogoDoOito)
						.addGap(49).addComponent(lblInsiraNome).addGap(18)
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnIniciarJogo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(60, Short.MAX_VALUE)));
		painel.setLayout(gl_contentPane);
	}

}
