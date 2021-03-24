package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import funcoesMenu.ComoJogar;
import funcoesMenu.Dama;
import funcoesMenu.LoginUsuario;
import funcoesMenu.Rank;
import funcoesMenu.TelaInfoPartida;
import mainpack.Main;
import java.awt.Font;

public class MenuUsuario implements ActionListener{
	
	private static JTextField textField;
	private static JFrame frameMenuUsuario;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void menu2(){
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
		frameMenuUsuario = new JFrame();
		frameMenuUsuario.setSize(750, 500);
		frameMenuUsuario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameMenuUsuario.setLocation(500, 250);
		
		frameMenuUsuario.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(213, 200, 37, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnEscolher = new JButton("Escolher");
		btnEscolher.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEscolher.setForeground(Color.GREEN);
		btnEscolher.setBackground(Color.GRAY);
		btnEscolher.setBounds(260, 199, 89, 23);
		btnEscolher.addActionListener(new MenuUsuario());
		panel.add(btnEscolher);
		
		JLabel lblJogar = new JLabel("1 - JOGAR");
		lblJogar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJogar.setForeground(Color.GREEN);
		lblJogar.setBounds(207, 81, 97, 14);
		panel.add(lblJogar);
		
		JLabel lblRank = new JLabel("2 - RANK");
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRank.setForeground(Color.GREEN);
		lblRank.setBounds(207, 106, 167, 14);
		panel.add(lblRank);
		
		JLabel lblComoJogar = new JLabel("3 - COMO JOGAR");
		lblComoJogar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComoJogar.setForeground(Color.GREEN);
		lblComoJogar.setBounds(207, 131, 117, 14);
		panel.add(lblComoJogar);
		
		JLabel lblLogout = new JLabel("4 - LOGOUT");
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogout.setForeground(Color.GREEN);
		lblLogout.setBounds(217, 156, 79, 14);
		panel.add(lblLogout);
		
		JLabel lblBemVindo = new JLabel("Bem - vindos");
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBemVindo.setForeground(Color.GREEN);
		lblBemVindo.setBounds(509, 59, 124, 14);
		panel.add(lblBemVindo);
		
		JLabel lblNomeUser1 = new JLabel("");
		lblNomeUser1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeUser1.setForeground(Color.GREEN);
		lblNomeUser1.setBounds(509, 84, 152, 23);
		panel.add(lblNomeUser1);
		frameMenuUsuario.setVisible(true);
		lblNomeUser1.setText(LoginUsuario.usuarioLogado[0]);
		
		JLabel lblNomeUser2 = new JLabel((String)LoginUsuario.usuarioLogado[1]);
		lblNomeUser2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeUser2.setForeground(Color.GREEN);
		lblNomeUser2.setBounds(509, 109, 152, 23);
		panel.add(lblNomeUser2);
		
		JLabel lblMonsterDama = new JLabel("Monster Dama!");
		lblMonsterDama.setForeground(Color.GREEN);
		lblMonsterDama.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMonsterDama.setBounds(186, 11, 233, 38);
		panel.add(lblMonsterDama);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String escolha = textField.getText();
		switch (escolha) {
		
		case "1":
			frameMenuUsuario.dispose();
			Dama.pontosBranco = 0;
			Dama.pontosVerde = 0;
			TelaInfoPartida.submenu();
			Dama.dama();
			
			break;
		case "2": 
			frameMenuUsuario.dispose();
			Rank.rank();
			break;
		case "3":
			frameMenuUsuario.dispose();
			ComoJogar.comoJogar();
			break;
		case "4":
			Main.main(null);
			frameMenuUsuario.dispose();
			break;
		default:
			
			
			
		}
		
	}
}
