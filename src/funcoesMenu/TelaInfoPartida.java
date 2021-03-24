package funcoesMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;



import menus.MenuUsuario;


public class TelaInfoPartida {
	
	public static JLabel nPontosVerde;
	public static JLabel nPontosBranco;
	public static JLabel vezVerde;
	public static JLabel vezBranco;
	public static String verdeJoga = "Vez do Verde";
	public static String brancoJoga = "Vez do Branco";
	public static JFrame frameInfoPartida;
	private static JPanel panel;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void submenu(){
		
			
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
	
		frameInfoPartida = new JFrame();
		frameInfoPartida.getContentPane().setBackground(Color.BLACK);
		frameInfoPartida.setSize(450, 400);
		
		frameInfoPartida.setLocation(1400, 250);
		frameInfoPartida.getContentPane().setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar Partida");
		btnCancelar.setForeground(Color.GREEN);
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dama.frameDama.dispose();
				Dama.gameInProgress = false;
				frameInfoPartida.dispose();
				MenuUsuario.menu2();
				
			}
		});
		btnCancelar.setBounds(109, 315, 227, 23);
		frameInfoPartida.getContentPane().add(btnCancelar);
		
		JLabel infoCancelar = new JLabel("Para cancelar a partida, clique no bot\u00E3o abaixo");
		infoCancelar.setForeground(Color.GREEN);
		infoCancelar.setBounds(109, 281, 266, 23);
		frameInfoPartida.getContentPane().add(infoCancelar);
		
		vezVerde = new JLabel("Vez do Verde");
		vezVerde.setForeground(Color.GREEN);
		vezVerde.setBounds(43, 181, 113, 23);
		frameInfoPartida.getContentPane().add(vezVerde);
		
		vezBranco = new JLabel("Vez do Branco");
		vezBranco.setForeground(Color.WHITE);
		vezBranco.setBounds(43, 215, 113, 23);
		frameInfoPartida.getContentPane().add(vezBranco);
		
		JLabel lblPtsVerde = new JLabel("Pontos Verde: ");
		lblPtsVerde.setForeground(Color.GREEN);
		lblPtsVerde.setBounds(216, 185, 99, 14);
		frameInfoPartida.getContentPane().add(lblPtsVerde);
		
		JLabel lblPtsBranco = new JLabel("Pontos Branco: ");
		lblPtsBranco.setForeground(Color.WHITE);
		lblPtsBranco.setBounds(216, 219, 107, 14);
		frameInfoPartida.getContentPane().add(lblPtsBranco);
		
		nPontosVerde = new JLabel("0");
		nPontosVerde.setForeground(Color.GREEN);
		nPontosVerde.setBounds(325, 185, 60, 14);
		frameInfoPartida.getContentPane().add(nPontosVerde);
		
		nPontosBranco = new JLabel("0");
		nPontosBranco.setForeground(Color.WHITE);
		nPontosBranco.setBounds(325, 219, 60, 14);
		frameInfoPartida.getContentPane().add(nPontosBranco);
		
		JLabel lblPontos_2 = new JLabel("Pontos");
		lblPontos_2.setForeground(Color.GREEN);
		lblPontos_2.setBounds(290, 156, 60, 14);
		frameInfoPartida.getContentPane().add(lblPontos_2);
		
		JLabel lblPontos_3 = new JLabel(LoginUsuario.usuarioLogado[0]);
		lblPontos_3.setForeground(Color.GREEN);
		lblPontos_3.setBounds(43, 11, 99, 28);
		frameInfoPartida.getContentPane().add(lblPontos_3);
		
		JLabel lblUser = new JLabel(LoginUsuario.usuarioLogado[1]);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(290, 11, 99, 28);
		frameInfoPartida.getContentPane().add(lblUser);
		
		JLabel lblJogandoComAs = new JLabel("Jogando com as BRANCAS");
		lblJogandoComAs.setForeground(Color.WHITE);
		lblJogandoComAs.setBounds(250, 37, 153, 28);
		frameInfoPartida.getContentPane().add(lblJogandoComAs);
		
		JLabel lblJogandoComAs_1 = new JLabel("Jogando com as VERDES");
		lblJogandoComAs_1.setForeground(Color.GREEN);
		lblJogandoComAs_1.setBounds(24, 37, 153, 28);
		frameInfoPartida.getContentPane().add(lblJogandoComAs_1);
		frameInfoPartida.setVisible(true);
		
		
		
	}
	public static void vezVerde() {
		vezVerde.setText(verdeJoga);
		vezBranco.setText(" ");
	}
	public static void vezBranco() {
		vezBranco.setText(brancoJoga);
		vezVerde.setText(" ");
	}
	public static void pontosVerde(){
		String verde = String.valueOf(Dama.pontosVerde);
		nPontosVerde.setText(verde);	 
	}
	public static void pontosBranco(){
		String branco = String.valueOf(Dama.pontosBranco);
		nPontosBranco.setText(branco);
	}
}
