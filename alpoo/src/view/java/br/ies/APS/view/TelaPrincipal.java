package br.ies.APS.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ies.APS.game.GameBoard;
import br.ies.APS.game.Movement;
import br.ies.APS.game.models.BoardSize;
import br.ies.APS.game.models.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private GameBoard gameBoard = new GameBoard(BoardSize.MEDIUM);
	private Movement movement = new Movement(gameBoard);
	private Player player;
	private JPanel contentPane;
	private JLabel linha1coluna1 = new JLabel("" + gameBoard.getStateOfBoard()[0][0]);
	private JLabel linha1coluna2 = new JLabel("" + gameBoard.getStateOfBoard()[0][1]);
	private JLabel linha1coluna3 = new JLabel("" + gameBoard.getStateOfBoard()[0][2]);
	private JLabel linha2coluna1 = new JLabel("" + gameBoard.getStateOfBoard()[1][0]);
	private JLabel linha2coluna2 = new JLabel("" + gameBoard.getStateOfBoard()[1][1]);
	private JLabel linha2coluna3 = new JLabel("" + gameBoard.getStateOfBoard()[1][2]);
	private JLabel linha3coluna1 = new JLabel("" + gameBoard.getStateOfBoard()[2][0]);
	private JLabel linha3coluna2 = new JLabel("" + gameBoard.getStateOfBoard()[2][1]);
	private JLabel linha3coluna3 = new JLabel("" + gameBoard.getStateOfBoard()[2][2]);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setTitle("Eight Puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		linha1coluna1.setBounds(9, 10, 258, 92);
		linha1coluna1.setHorizontalAlignment(SwingConstants.CENTER);
		linha1coluna1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		linha1coluna1.setBackground(getForeground());
		contentPane.add(linha1coluna1);

		linha1coluna2.setBounds(267, 10, 258, 92);
		linha1coluna2.setHorizontalAlignment(SwingConstants.CENTER);
		linha1coluna2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha1coluna2);

		linha1coluna3.setBounds(525, 10, 258, 92);
		linha1coluna3.setHorizontalAlignment(SwingConstants.CENTER);
		linha1coluna3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha1coluna3);

		linha2coluna1.setBounds(9, 102, 258, 92);
		linha2coluna1.setHorizontalAlignment(SwingConstants.CENTER);
		linha2coluna1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha2coluna1);

		linha2coluna2.setBounds(267, 102, 258, 92);
		linha2coluna2.setForeground(Color.BLACK);
		linha2coluna2.setHorizontalAlignment(SwingConstants.CENTER);
		linha2coluna2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha2coluna2);

		linha2coluna3.setBounds(525, 102, 258, 92);
		linha2coluna3.setHorizontalAlignment(SwingConstants.CENTER);
		linha2coluna3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha2coluna3);

		linha3coluna1.setBounds(9, 194, 258, 92);
		linha3coluna1.setHorizontalAlignment(SwingConstants.CENTER);
		linha3coluna1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha3coluna1);

		linha3coluna2.setBounds(267, 194, 258, 92);
		linha3coluna2.setHorizontalAlignment(SwingConstants.CENTER);
		linha3coluna2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha3coluna2);

		linha3coluna3.setBounds(525, 194, 258, 92);
		linha3coluna3.setHorizontalAlignment(SwingConstants.CENTER);
		linha3coluna3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(linha3coluna3);

		ActionListener botaoCimaPressionado = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movement.moveUP();
				atualizarLabels();

				verifyVictory();
			}
		};

		ActionListener botaoEsquerdaPressionado = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movement.moveLeft();
				atualizarLabels();

				verifyVictory();
			}
		};

		ActionListener botaoBaixoPressionado = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movement.moveDown();
				atualizarLabels();

				verifyVictory();
			}
		};

		ActionListener botaoDireitaPressionado = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movement.moveRight();
				atualizarLabels();

				verifyVictory();
			}
		};

		JButton botaoEsquerda = new JButton("Esquerda");
		botaoEsquerda.setBounds(9, 378, 258, 92);
		botaoEsquerda.addActionListener(botaoEsquerdaPressionado);

		JLabel label = new JLabel("");
		label.setBounds(9, 286, 258, 92);
		contentPane.add(label);

		JButton botaoCima = new JButton("Cima");
		botaoCima.setBounds(267, 286, 258, 92);
		botaoCima.addActionListener(botaoCimaPressionado);
		contentPane.add(botaoCima);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(525, 286, 258, 92);
		contentPane.add(label_1);
		contentPane.add(botaoEsquerda);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(267, 378, 258, 92);
		contentPane.add(label_2);

		JButton botaoDireita = new JButton("Direita");
		botaoDireita.setBounds(525, 378, 258, 92);
		botaoDireita.addActionListener(botaoDireitaPressionado);
		contentPane.add(botaoDireita);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(9, 470, 258, 92);
		contentPane.add(label_3);

		JButton botaoBaixo = new JButton("Baixo");
		botaoBaixo.setBounds(267, 470, 258, 92);
		botaoBaixo.addActionListener(botaoBaixoPressionado);
		contentPane.add(botaoBaixo);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(525, 470, 258, 92);
		contentPane.add(label_4);
	}

	private void atualizarLabels() {
		linha1coluna1.setText("" + gameBoard.getStateOfBoard()[0][0]);
		linha1coluna2.setText("" + gameBoard.getStateOfBoard()[0][1]);
		linha1coluna3.setText("" + gameBoard.getStateOfBoard()[0][2]);
		linha2coluna1.setText("" + gameBoard.getStateOfBoard()[1][0]);
		linha2coluna2.setText("" + gameBoard.getStateOfBoard()[1][1]);
		linha2coluna3.setText("" + gameBoard.getStateOfBoard()[1][2]);
		linha3coluna1.setText("" + gameBoard.getStateOfBoard()[2][0]);
		linha3coluna2.setText("" + gameBoard.getStateOfBoard()[2][1]);
		linha3coluna3.setText("" + gameBoard.getStateOfBoard()[2][2]);
	}

	private void verifyVictory() {
		if (VictoryCheck.verify(gameBoard.getStateOfBoard())) {
			JOptionPane.showMessageDialog(null, "Parabéns, você conseguiu!");
		}
	}

	public void setPlayer(String nome) {
		this.player = new Player(nome, gameBoard);
	}
}
