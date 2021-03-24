package funcoesMenu;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import mainpack.Main;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import usuario.Usuario;
import java.awt.Font;





public class CadastrarUsuario implements ActionListener {
	private static JLabel usuarioLabel;
	private static JTextField userText;
	private static JLabel senhaLabel;
	private static JTextField senhaTexto;
	private static JButton btnCadastrar;
	private static JLabel sucesso;
	static JFrame frame;
	private static JPanel panel;
	private static JButton btnFinalizar;

	public static HashMap<String,Usuario> userMap = new  HashMap<String, Usuario>();
	private static JLabel label;
	
	

	
	public CadastrarUsuario (HashMap<String, Usuario> userMap) {
		super();
		CadastrarUsuario.userMap = userMap;
	}



	public HashMap<String, Usuario> getUserMap() {
		return userMap;
	}

	public static void setUserMap(String nome, Usuario usuario) {
		CadastrarUsuario.userMap.put(nome, usuario);
	}
	public static boolean checkOnMap(String nome ) {
		return userMap.containsKey(nome);
	}
	
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */

	

	public static void cadastro() {
		
		
		
		String cleanNome = "";
		String cleanSenha = "32141241251412312";
		for(int i = 0; i < 4; i++) {
			Usuario usuario = new Usuario(cleanNome, cleanSenha);
			setUserMap(cleanNome+i, usuario);
			
		}
		
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
		frame = new JFrame();
		frame.setSize(750, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);     
		frame.setLocation(500, 250);

		frame.getContentPane().add(panel);

		panel.setLayout(null);
		usuarioLabel = new JLabel("Nome:");
		usuarioLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		usuarioLabel.setBackground(Color.GREEN);
		usuarioLabel.setForeground(Color.GREEN);
		usuarioLabel.setBounds(193, 122, 48, 25);
		panel.add(usuarioLabel);

		userText = new JTextField();
		userText.setBackground(Color.WHITE);
		userText.setForeground(Color.BLACK);
		userText.setBounds(251, 122, 165, 25);
		panel.add(userText);


		senhaLabel = new JLabel("Pass:");
		senhaLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		senhaLabel.setForeground(Color.GREEN);
		senhaLabel.setBounds(193, 158, 55, 25);
		panel.add(senhaLabel);

		senhaTexto = new JTextField();
		senhaTexto.setBounds(251, 152, 165, 25);
		panel.add(senhaTexto);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBackground(Color.GRAY);
		btnCadastrar.setForeground(Color.GREEN);
		btnCadastrar.setBounds(293, 188, 104, 25);
		btnCadastrar.addActionListener(new CadastrarUsuario(userMap));
		panel.add(btnCadastrar);

		sucesso = new JLabel("");
		sucesso.setFont(new Font("Tahoma", Font.BOLD, 11));
		sucesso.setForeground(Color.GREEN);
		sucesso.setBounds(243, 224, 196, 25);
		panel.add(sucesso);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent bntFinalizar) {
				sucesso.setText("");
				Main.main(null);
				frame.dispose();
				
			}
		});
		btnFinalizar.setForeground(Color.GREEN);
		btnFinalizar.setBackground(Color.GRAY);
		btnFinalizar.setBounds(601, 397, 104, 25);
		panel.add(btnFinalizar);
		
		label = new JLabel("Monster Dama!");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(206, 23, 233, 38);
		panel.add(label);

		
		




		frame.setVisible(true);

		//-------------------------------------------------------------//
		//LOGICA//
		




	}

	@Override
	public void actionPerformed(ActionEvent btnCadastrar ) {
		
		
		
		String nome1 = userText.getText();
		String senha1 = senhaTexto.getText();

		boolean checa = checkOnMap(nome1);

		if (checa == true) {
			sucesso.setText("usuario invalido");
		}
		else{
			Usuario usuario = new Usuario(nome1, senha1);
			setUserMap(nome1, usuario);
			sucesso.setText("Usuario cadastrado com sucesso!");	
			
		}
		
		

	}
}
