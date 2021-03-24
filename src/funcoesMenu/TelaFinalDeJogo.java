package funcoesMenu;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import menus.MenuUsuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFinalDeJogo {
		
	private static JPanel panel;
	public static JFrame frameTelaFinal;
	public static String ganhador;
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void TelaFinal(){
		
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
	
		frameTelaFinal = new JFrame();
		frameTelaFinal.getContentPane().setBackground(Color.BLACK);
		frameTelaFinal.setSize(593, 456);
		
		frameTelaFinal.setLocation(700, 250);
		frameTelaFinal.getContentPane().setLayout(null);
		
		JLabel ganhou = new JLabel("Ganhou!!!");
		ganhou.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ganhou.setForeground(Color.GREEN);
		ganhou.setBounds(230, 64, 141, 14);
		frameTelaFinal.getContentPane().add(ganhou);
		
		JLabel nomeUsuarioGanhador = new JLabel(ganhador);
		nomeUsuarioGanhador.setFont(new Font("Tahoma", Font.BOLD, 24));
		nomeUsuarioGanhador.setForeground(Color.GREEN);
		nomeUsuarioGanhador.setBounds(231, 31, 182, 23);
		frameTelaFinal.getContentPane().add(nomeUsuarioGanhador);
		
		JLabel resumo = new JLabel("Resumo:");
		resumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		resumo.setForeground(Color.GREEN);
		resumo.setBounds(190, 108, 110, 14);
		frameTelaFinal.getContentPane().add(resumo);
		
		JLabel pontosLabel = new JLabel("Total Pontos no Rank:");
		pontosLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pontosLabel.setForeground(new Color(0, 255, 0));
		pontosLabel.setBounds(186, 244, 148, 14);
		frameTelaFinal.getContentPane().add(pontosLabel);
		
		JButton botaoFinalizar = new JButton("Finalizar Partida!");
		botaoFinalizar.setForeground(Color.GREEN);
		botaoFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dama.frameDama.dispose();
				Dama.gameInProgress = false;
				frameTelaFinal.dispose();
				MenuUsuario.menu2();
			}
		});
		botaoFinalizar.setBackground(new Color(128, 128, 128));
		botaoFinalizar.setBounds(226, 376, 187, 23);
		frameTelaFinal.getContentPane().add(botaoFinalizar);
		
		JLabel pontosUsuarioVerde = new JLabel("Pontos Verde:");
		pontosUsuarioVerde.setForeground(Color.GREEN);
		pontosUsuarioVerde.setBounds(186, 158, 94, 14);
		frameTelaFinal.getContentPane().add(pontosUsuarioVerde);
		
		JLabel pontosUsuarioBranco = new JLabel("Pontos Branco:");
		pontosUsuarioBranco.setForeground(Color.WHITE);
		pontosUsuarioBranco.setBounds(186, 183, 102, 14);
		frameTelaFinal.getContentPane().add(pontosUsuarioBranco);
		
		JLabel numeroPontosBranco = new JLabel(String.valueOf(Dama.pontosBranco));
		numeroPontosBranco.setForeground(Color.WHITE);
		numeroPontosBranco.setBounds(315, 183, 60, 14);
		frameTelaFinal.getContentPane().add(numeroPontosBranco);
		
		JLabel numeroPontosVerde = new JLabel(String.valueOf(Dama.pontosVerde));
		numeroPontosVerde.setForeground(Color.GREEN);
		numeroPontosVerde.setBounds(315, 158, 60, 14);
		frameTelaFinal.getContentPane().add(numeroPontosVerde);
		
		JLabel usuarioLogVerde = new JLabel(LoginUsuario.usuarioLogado[0]);
		usuarioLogVerde.setForeground(Color.GREEN);
		usuarioLogVerde.setBounds(186, 282, 70, 14);
		frameTelaFinal.getContentPane().add(usuarioLogVerde);
		
		JLabel pontosUserLogVerde = new JLabel(String.valueOf(CadastrarUsuario.userMap.get(LoginUsuario.usuarioLogado[0]).getPontos()));
		pontosUserLogVerde.setForeground(Color.GREEN);
		pontosUserLogVerde.setBounds(315, 282, 46, 14);
		frameTelaFinal.getContentPane().add(pontosUserLogVerde);
		
		JLabel usuarioLogBranco = new JLabel(LoginUsuario.usuarioLogado[1]);
		usuarioLogBranco.setForeground(Color.WHITE);
		usuarioLogBranco.setBounds(186, 320, 70, 14);
		frameTelaFinal.getContentPane().add(usuarioLogBranco);
		
		JLabel pontosUserLogBranco = new JLabel(String.valueOf(CadastrarUsuario.userMap.get(LoginUsuario.usuarioLogado[1]).getPontos()));
		pontosUserLogBranco.setForeground(Color.WHITE);
		pontosUserLogBranco.setBounds(315, 320, 46, 14);
		frameTelaFinal.getContentPane().add(pontosUserLogBranco);
		
		frameTelaFinal.setVisible(true);
	}
	
	
}
