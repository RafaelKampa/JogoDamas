package funcoesMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import menus.MenuUsuario;

public class ComoJogar {
	private static JPanel panel;
	public static JFrame frameComoJogar;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void comoJogar(){
		
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
	
		frameComoJogar = new JFrame();
		frameComoJogar.getContentPane().setBackground(Color.BLACK);
		frameComoJogar.setSize(723, 458);
		
		frameComoJogar.setLocation(500, 250);
		frameComoJogar.getContentPane().setLayout(null);
		frameComoJogar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel comoJogarDama = new JLabel("Como Jogar Monster Dama!");
		comoJogarDama.setFont(new Font("Tahoma", Font.BOLD, 16));
		comoJogarDama.setForeground(Color.GREEN);
		comoJogarDama.setBounds(249, 11, 233, 38);
		frameComoJogar.getContentPane().add(comoJogarDama);
		
		JLabel pecas = new JLabel("Pe\u00E7as:");
		pecas.setFont(new Font("Tahoma", Font.BOLD, 16));
		pecas.setForeground(Color.GREEN);
		pecas.setBounds(118, 60, 471, 25);
		frameComoJogar.getContentPane().add(pecas);
		
		JLabel infoPecas1 = new JLabel("Cada jogador recebera 12 pe\u00E7as no tabuleiro, sendo elas VERDES ou BRANCAS");
		infoPecas1.setFont(new Font("Tahoma", Font.BOLD, 11));
		infoPecas1.setForeground(Color.GREEN);
		infoPecas1.setBounds(118, 84, 518, 25);
		frameComoJogar.getContentPane().add(infoPecas1);
		
		JLabel infoPecas2 = new JLabel("Os jogadores ser\u00E3o informados de suas respectivas cores na janela de informa\u00E7\u00F5es");
		infoPecas2.setFont(new Font("Tahoma", Font.BOLD, 11));
		infoPecas2.setForeground(Color.GREEN);
		infoPecas2.setBounds(118, 109, 579, 25);
		frameComoJogar.getContentPane().add(infoPecas2);
		
		JLabel movimentos = new JLabel("Movimentos: ");
		movimentos.setForeground(Color.GREEN);
		movimentos.setFont(new Font("Tahoma", Font.BOLD, 16));
		movimentos.setBounds(118, 147, 471, 25);
		frameComoJogar.getContentPane().add(movimentos);
		
		JLabel infoMoves1 = new JLabel("Cada jogador poder\u00E1 mover apenas 1 pe\u00E7a por turno.");
		infoMoves1.setForeground(Color.GREEN);
		infoMoves1.setBounds(118, 175, 445, 14);
		frameComoJogar.getContentPane().add(infoMoves1);
		
		JLabel infoMoves2 = new JLabel("Caso uma jogada possa resultar em capturar uma pe\u00E7a esteja dispon\u00EDvel, ser\u00E1 indicado no tabuleiro.");
		infoMoves2.setForeground(Color.GREEN);
		infoMoves2.setBounds(118, 188, 579, 25);
		frameComoJogar.getContentPane().add(infoMoves2);
		
		JLabel pontos = new JLabel("Pontos:");
		pontos.setForeground(Color.GREEN);
		pontos.setFont(new Font("Tahoma", Font.BOLD, 16));
		pontos.setBounds(118, 236, 422, 25);
		frameComoJogar.getContentPane().add(pontos);
		
		JLabel pontosInfo1 = new JLabel("Cada jogador ira ganhar 100 pontos por cada pe\u00E7a capturada.");
		pontosInfo1.setForeground(Color.GREEN);
		pontosInfo1.setBounds(118, 259, 445, 14);
		frameComoJogar.getContentPane().add(pontosInfo1);
		
		JLabel pontosInfo2 = new JLabel("Para receber seus pontos no Rank a partida deve ser finalizada. ");
		pontosInfo2.setForeground(Color.GREEN);
		pontosInfo2.setBounds(118, 272, 486, 20);
		frameComoJogar.getContentPane().add(pontosInfo2);
		
		JLabel vitoria = new JLabel("Vit\u00F3ria!");
		vitoria.setForeground(Color.GREEN);
		vitoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		vitoria.setBounds(118, 315, 422, 25);
		frameComoJogar.getContentPane().add(vitoria);
		
		JLabel vitoriaInfo1 = new JLabel("O primeiro jogador que comer todas as pe\u00E7as do advers\u00E1rio GANHA a partida!");
		vitoriaInfo1.setForeground(Color.GREEN);
		vitoriaInfo1.setBounds(118, 339, 445, 20);
		frameComoJogar.getContentPane().add(vitoriaInfo1);
		
		JButton voltar = new JButton("Voltar");
		voltar.setForeground(Color.GREEN);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUsuario.menu2();
				frameComoJogar.dispose();
				
			}
		});
		voltar.setBackground(Color.GRAY);
		voltar.setBounds(569, 376, 89, 23);
		frameComoJogar.getContentPane().add(voltar);
		
		JLabel infoMove3 = new JLabel("Por\u00E9m o movimento de comer pe\u00E7a n\u00E3o ser\u00E1 obrigat\u00F3rio. ");
		infoMove3.setForeground(Color.GREEN);
		infoMove3.setBounds(118, 211, 445, 14);
		frameComoJogar.getContentPane().add(infoMove3);
		
		JLabel cancelarPartida = new JLabel("Caso os jogadores decidam por cancelar a partida, os mesmo n\u00E3o receberam os Pontos de Rank.");
		cancelarPartida.setForeground(Color.GREEN);
		cancelarPartida.setBounds(118, 284, 563, 20);
		frameComoJogar.getContentPane().add(cancelarPartida);
		
		JLabel lblADireita = new JLabel(" \u00E0 direita do tabuleiro.");
		lblADireita.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblADireita.setForeground(Color.GREEN);
		lblADireita.setBounds(118, 133, 471, 14);
		frameComoJogar.getContentPane().add(lblADireita);
		
		frameComoJogar.setVisible(true);
	}
}

