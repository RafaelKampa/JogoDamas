package funcoesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mainpack.Main;
import menus.MenuUsuario;

import java.awt.Color;
import java.awt.Font;

public class LoginUsuario implements ActionListener{

		 
		private static JLabel usuarioLabel;
		private static JTextField userText;
		private static JLabel senhaLabel;
		private static JPasswordField senhaTexto;
		private static JButton button;
		private static JLabel sucesso;
		private static JTextField user2;
		private static JPasswordField senha2;
		public static final String[] usuarioLogado = new String[2];
		private static JFrame frameLogin;
		private static JLabel lblNewLabel_2;
		private static JLabel lblNewLabel;
		private static JLabel lblNewLabel_1;
		private static JLabel lblColoqueSeuNome;
		private static JPanel panel;
		private static JButton btnVoltar;
		private static JLabel lblSeEstiverJogando;
		private static JLabel label;
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void logar() {
		
		
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
		frameLogin = new JFrame();
		frameLogin.setSize(750, 500);
		
		frameLogin.setLocation(500, 250);
		
		frameLogin.getContentPane().add(panel);
		
		panel.setLayout(null);
		usuarioLabel = new JLabel("User:");
		usuarioLabel.setBackground(Color.GREEN);
		usuarioLabel.setForeground(Color.GREEN);
		usuarioLabel.setBounds(79, 93, 33, 25);
		panel.add(usuarioLabel);
		
		userText = new JTextField();
		userText.setBackground(Color.WHITE);
		userText.setForeground(Color.BLACK);
		userText.setBounds(122, 93, 165, 25);
		panel.add(userText);
		
		senhaLabel = new JLabel("Pass:");
		senhaLabel.setForeground(Color.GREEN);
		senhaLabel.setBounds(79, 149, 33, 25);
		panel.add(senhaLabel);
		
		senhaTexto = new JPasswordField();
		senhaTexto.setBounds(122, 149, 165, 25);
		panel.add(senhaTexto);
		
		button = new JButton("Login");
		button.setBackground(Color.GRAY);
		button.setForeground(Color.GREEN);
		button.setBounds(343, 221, 80, 25);
		button.addActionListener(new LoginUsuario());
		panel.add(button);
		
		sucesso = new JLabel("");
		sucesso.setForeground(Color.GREEN);
		sucesso.setBounds(284, 257, 196, 25);
		panel.add(sucesso);
		
		user2 = new JTextField();
		user2.setBounds(521, 93, 165, 25);
		panel.add(user2);
		user2.setColumns(10);
		
		senha2 = new JPasswordField();
		senha2.setBounds(521, 149, 165, 25);
		panel.add(senha2);
		senha2.setColumns(10);
		
		lblNewLabel = new JLabel("User 2:");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(459, 98, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Pass 2:");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(459, 154, 46, 14);
		panel.add(lblNewLabel_1);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.main(null);
				frameLogin.dispose();
				
			}
		});
		btnVoltar.setForeground(Color.GREEN);
		btnVoltar.setBackground(Color.GRAY);
		btnVoltar.setBounds(629, 425, 80, 25);
		panel.add(btnVoltar);
		
		lblNewLabel_2 = new JLabel("Se estiver jogando sozinho!\r\n\r\n");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(23, 310, 333, 25);
		panel.add(lblNewLabel_2);
		
		lblColoqueSeuNome = new JLabel("Coloque seu nome de usuario no User e no User2.");
		lblColoqueSeuNome.setForeground(Color.GREEN);
		lblColoqueSeuNome.setBounds(23, 335, 333, 25);
		panel.add(lblColoqueSeuNome);
		
		lblSeEstiverJogando = new JLabel("Coloque sua senha no Pass e no Pass2.\r\n\r\n");
		lblSeEstiverJogando.setForeground(Color.GREEN);
		lblSeEstiverJogando.setBounds(23, 358, 333, 20);
		panel.add(lblSeEstiverJogando);
		
		label = new JLabel("Monster Dama!");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(247, 11, 233, 38);
		panel.add(label);
		
		
	
		
		frameLogin.setVisible(true);
		
	
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nome = userText.getText();
		@SuppressWarnings("deprecation")
		String senha = senhaTexto.getText();
		String nome2 = user2.getText();
		@SuppressWarnings("deprecation")
		String senhauser2 = senha2.getText();
		boolean checa = CadastrarUsuario.checkOnMap(nome);
		boolean checa2 = CadastrarUsuario.checkOnMap(nome2);
		
			if(checa == true && checa2 == true ) {
				if (CadastrarUsuario.userMap.get(nome).getSenha().equals(senha) && CadastrarUsuario.userMap.get(nome2).getSenha().equals(senhauser2)) {
					sucesso.setText("login realizado com Sucesso");
					
					usuarioLogado[0] = nome;
					usuarioLogado[1] = nome2;
					frameLogin.dispose();
					MenuUsuario.menu2();
					
				}else {
					sucesso.setText("usuario ou senha invalido.");
					
					
				}
			}else {
				sucesso.setText("usuario ou senha invalido.");
				
			}
	  
	      }
}
