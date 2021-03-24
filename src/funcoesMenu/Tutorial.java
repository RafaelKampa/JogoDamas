package funcoesMenu;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mainpack.Main;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tutorial {
	
	private static JPanel panel;
	public static JFrame frameTutorial;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void tutorial(){
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
	
		frameTutorial = new JFrame();
		frameTutorial.getContentPane().setBackground(Color.BLACK);
		frameTutorial.setSize(723, 458);
		
		frameTutorial.setLocation(500, 250);
		frameTutorial.getContentPane().setLayout(null);
		frameTutorial.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel lblTurorial = new JLabel("TUTORIAL");
		lblTurorial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTurorial.setForeground(Color.GREEN);
		lblTurorial.setBounds(305, 11, 111, 38);
		frameTutorial.getContentPane().add(lblTurorial);
		
		JLabel lblCadastro = new JLabel("Primeiramente efetue o Cadastro!");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastro.setForeground(Color.GREEN);
		lblCadastro.setBounds(118, 60, 258, 25);
		frameTutorial.getContentPane().add(lblCadastro);
		
		JLabel lblCadastro_2 = new JLabel("Para efutar o cadastro, escolha a op\u00E7\u00E3o CADASTRAR no menu principal.");
		lblCadastro_2.setForeground(Color.GREEN);
		lblCadastro_2.setBounds(118, 84, 459, 25);
		frameTutorial.getContentPane().add(lblCadastro_2);
		
		JLabel lblNomeSenha = new JLabel("Escolha um nome de usuario e uma senha.");
		lblNomeSenha.setForeground(Color.GREEN);
		lblNomeSenha.setBounds(118, 108, 402, 14);
		frameTutorial.getContentPane().add(lblNomeSenha);
		
		JLabel lblEmSeguidaClique = new JLabel("Em seguida clique no botao Cadastrar e verifique se os dados s\u00E3o v\u00E1lidos");
		lblEmSeguidaClique.setForeground(Color.GREEN);
		lblEmSeguidaClique.setBounds(118, 122, 445, 14);
		frameTutorial.getContentPane().add(lblEmSeguidaClique);
		
		JLabel lblVolteParaO = new JLabel("Volte para o menu principal e escolha a opc\u00E3o de Login!");
		lblVolteParaO.setForeground(Color.GREEN);
		lblVolteParaO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVolteParaO.setBounds(118, 147, 471, 25);
		frameTutorial.getContentPane().add(lblVolteParaO);
		
		JLabel lblParaVoltarAo = new JLabel("Para voltar ao menu principal, clique no bot\u00E3o finalizar na janela de Cadastro");
		lblParaVoltarAo.setForeground(Color.GREEN);
		lblParaVoltarAo.setBounds(118, 175, 445, 14);
		frameTutorial.getContentPane().add(lblParaVoltarAo);
		
		JLabel lblParaEfutarO = new JLabel("Para efutar o login, escolha a op\u00E7\u00E3o LOGIN no menu principal.");
		lblParaEfutarO.setForeground(Color.GREEN);
		lblParaEfutarO.setBounds(118, 188, 445, 25);
		frameTutorial.getContentPane().add(lblParaEfutarO);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.GREEN);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(118, 224, 422, 25);
		frameTutorial.getContentPane().add(lblLogin);
		
		JLabel lblColoqueSeuNome = new JLabel("Coloque seu nome de usuario no campo User e sua senha no campo Pass.");
		lblColoqueSeuNome.setForeground(Color.GREEN);
		lblColoqueSeuNome.setBounds(118, 260, 445, 14);
		frameTutorial.getContentPane().add(lblColoqueSeuNome);
		
		JLabel lblCliqueEmLogin = new JLabel("Clique em Login, caso o login n\u00E3o seja efetuado, verifique seus dados cadastrados!");
		lblCliqueEmLogin.setForeground(Color.GREEN);
		lblCliqueEmLogin.setBounds(118, 272, 486, 20);
		frameTutorial.getContentPane().add(lblCliqueEmLogin);
		
		JLabel lblGg = new JLabel("GG!!");
		lblGg.setForeground(Color.GREEN);
		lblGg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGg.setBounds(118, 303, 422, 25);
		frameTutorial.getContentPane().add(lblGg);
		
		JLabel lblOJogoFoi = new JLabel("O jogo foi desenvolvido para o modo multiplayer!");
		lblOJogoFoi.setForeground(Color.GREEN);
		lblOJogoFoi.setBounds(118, 327, 340, 20);
		frameTutorial.getContentPane().add(lblOJogoFoi);
		
		JLabel lblOsDoisJogadores = new JLabel("Os dois jogadores devem efetuar o Cadastro e efetuar o Login com os dados cadastrados!");
		lblOsDoisJogadores.setForeground(Color.GREEN);
		lblOsDoisJogadores.setBounds(118, 345, 518, 20);
		frameTutorial.getContentPane().add(lblOsDoisJogadores);
		
		JButton voltar = new JButton("Voltar");
		voltar.setForeground(Color.GREEN);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main(null);
				frameTutorial.dispose();
				
			}
		});
		voltar.setBackground(Color.GRAY);
		voltar.setBounds(569, 376, 89, 23);
		frameTutorial.getContentPane().add(voltar);
		
		frameTutorial.setVisible(true);
	}
}
