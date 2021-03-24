package funcoesMenu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import menus.MenuUsuario;
import usuario.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rank {
	private static JPanel panel;
	public static JFrame frameRank;
	

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void rank(){
		
		
		List<Usuario> rank = new ArrayList<Usuario>(CadastrarUsuario.userMap.values());
		Collections.sort(rank, Comparator.comparing(Usuario::getPontos));
		
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
	
		frameRank = new JFrame();
		frameRank.getContentPane().setBackground(Color.BLACK);
		frameRank.setSize(750, 500);
		
		frameRank.setLocation(500, 250);
		frameRank.getContentPane().setLayout(null);
	
			
		JLabel lblNome = new JLabel(rank.get(rank.size()-1).getNome(null));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setForeground(Color.GREEN);
		lblNome.setBounds(311, 132, 117, 14);
		frameRank.getContentPane().add(lblNome);
		
		
		
		
		JLabel lblNome2 = new JLabel(rank.get(rank.size()-2).getNome(null));
		lblNome2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome2.setForeground(Color.GREEN);
		lblNome2.setBounds(311, 167, 117, 14);
		frameRank.getContentPane().add(lblNome2);
		
		JLabel label = new JLabel(rank.get(rank.size()-3).getNome(null));
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(311, 194, 117, 14);
		frameRank.getContentPane().add(label);
		
		JLabel lblRank_1 = new JLabel("Rank 1 - ");
		lblRank_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRank_1.setForeground(Color.GREEN);
		lblRank_1.setBounds(241, 132, 74, 14);
		frameRank.getContentPane().add(lblRank_1);
		
		JLabel lblRank_2 = new JLabel("Rank 2   - ");
		lblRank_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRank_2.setForeground(Color.GREEN);
		lblRank_2.setBounds(241, 166, 74, 14);
		frameRank.getContentPane().add(lblRank_2);
		
		JLabel lblTop3 = new JLabel("RANK TOP 3 JOGADORES!!!");
		lblTop3.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblTop3.setForeground(Color.GREEN);
		lblTop3.setBounds(141, 60, 530, 26);
		frameRank.getContentPane().add(lblTop3);
		
		JLabel lblRank_3 = new JLabel("Rank 3     -");
		lblRank_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRank_3.setForeground(Color.GREEN);
		lblRank_3.setBounds(241, 193, 74, 14);
		frameRank.getContentPane().add(lblRank_3);
		
		
		
		JLabel lblPontos = new JLabel("Pontos:");
		lblPontos.setForeground(Color.GREEN);
		lblPontos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPontos.setBounds(438, 134, 74, 14);
		frameRank.getContentPane().add(lblPontos);
		
		JLabel lblPontosRank1 = new JLabel(String.valueOf(rank.get(rank.size()-1).getPontos()));
		lblPontosRank1.setForeground(Color.GREEN);
		lblPontosRank1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPontosRank1.setBounds(522, 134, 117, 14);
		frameRank.getContentPane().add(lblPontosRank1);
		
		JLabel lblPontosRank2 = new JLabel("Pontos:");
		lblPontosRank2.setForeground(Color.GREEN);
		lblPontosRank2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPontosRank2.setBounds(438, 168, 74, 14);
		frameRank.getContentPane().add(lblPontosRank2);
		
		JLabel lblRankPontos3 = new JLabel(String.valueOf(rank.get(rank.size()-2).getPontos()));
		lblRankPontos3.setForeground(Color.GREEN);
		lblRankPontos3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRankPontos3.setBounds(522, 168, 117, 14);
		frameRank.getContentPane().add(lblRankPontos3);
		
		JLabel lblPontosRank4 = new JLabel("Pontos:");
		lblPontosRank4.setForeground(Color.GREEN);
		lblPontosRank4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPontosRank4.setBounds(438, 194, 74, 14);
		frameRank.getContentPane().add(lblPontosRank4);
		
		JLabel lblRankPontos5 = new JLabel(String.valueOf(rank.get(rank.size()-3).getPontos()));
		lblRankPontos5.setForeground(Color.GREEN);
		lblRankPontos5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRankPontos5.setBounds(522, 194, 117, 14);
		frameRank.getContentPane().add(lblRankPontos5);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUsuario.menu2();
				frameRank.dispose();
			}
		});
		btnVoltar.setBackground(Color.GRAY);
		btnVoltar.setForeground(Color.GREEN);
		btnVoltar.setBounds(595, 396, 89, 23);
		frameRank.getContentPane().add(btnVoltar);
		
		JLabel lblNomeUser1 = new JLabel(LoginUsuario.usuarioLogado[0]);
		lblNomeUser1.setForeground(Color.GREEN);
		lblNomeUser1.setBounds(46, 346, 83, 14);
		frameRank.getContentPane().add(lblNomeUser1);
		
		JLabel lblNomeUser2 = new JLabel(LoginUsuario.usuarioLogado[1]);
		lblNomeUser2.setForeground(Color.GREEN);
		lblNomeUser2.setBounds(154, 346, 83, 14);
		frameRank.getContentPane().add(lblNomeUser2);
		
		JLabel lblSeusPontos = new JLabel("Sua pontua\u00E7\u00E3o:");
		lblSeusPontos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSeusPontos.setForeground(Color.GREEN);
		lblSeusPontos.setBounds(46, 309, 191, 26);
		frameRank.getContentPane().add(lblSeusPontos);
		
		JLabel lblUserPontos = new JLabel(String.valueOf(CadastrarUsuario.userMap.get(LoginUsuario.usuarioLogado[0]).getPontos()));
		lblUserPontos.setForeground(Color.GREEN);
		lblUserPontos.setBounds(46, 379, 83, 14);
		frameRank.getContentPane().add(lblUserPontos);
		
		JLabel lblPontosuser2 = new JLabel(String.valueOf(CadastrarUsuario.userMap.get(LoginUsuario.usuarioLogado[1]).getPontos()));
		lblPontosuser2.setForeground(Color.GREEN);
		lblPontosuser2.setBounds(154, 379, 83, 14);
		frameRank.getContentPane().add(lblPontosuser2);
		
		JLabel lblMonterDama = new JLabel("Monster Dama!");
		lblMonterDama.setForeground(Color.GREEN);
		lblMonterDama.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMonterDama.setBounds(241, 11, 233, 38);
		frameRank.getContentPane().add(lblMonterDama);
		
		frameRank.setVisible(true);
		
	}
}
