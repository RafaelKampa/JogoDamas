package mainpack;
import menus.Menu_Principal;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;





public class Main implements ActionListener {
	
	
	private static JTextField textField;
	private static JFrame frameMain;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		//labels e botoes do jFrame
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.BLACK);
		frameMain = new JFrame();
		frameMain.setSize(750, 500);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocation(500, 250);
		
		frameMain.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(294, 179, 37, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnEscolher = new JButton("Escolher");
		btnEscolher.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEscolher.setForeground(Color.GREEN);
		btnEscolher.setBackground(Color.GRAY);
		btnEscolher.setBounds(341, 178, 91, 23);
		btnEscolher.addActionListener(new Main());
		panel.add(btnEscolher);
		
		JLabel lblCadastrar = new JLabel("1 - CADASTRAR");
		lblCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrar.setForeground(Color.GREEN);
		lblCadastrar.setBounds(284, 63, 111, 14);
		panel.add(lblCadastrar);
		
		JLabel lblLogin = new JLabel("2 - LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setForeground(Color.GREEN);
		lblLogin.setBounds(284, 88, 79, 14);
		panel.add(lblLogin);
		
		JLabel lblTutorial = new JLabel("3 - TUTORIAL");
		lblTutorial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTutorial.setForeground(Color.GREEN);
		lblTutorial.setBounds(284, 113, 100, 14);
		panel.add(lblTutorial);
		
		JLabel lblSair = new JLabel("4 - SAIR");
		lblSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSair.setForeground(Color.GREEN);
		lblSair.setBounds(294, 145, 79, 14);
		panel.add(lblSair);
		
		JLabel lblCriadoPorLeonardo = new JLabel("Desenvolvido por Leonardo Almeida e Rafel Kampa");
		lblCriadoPorLeonardo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCriadoPorLeonardo.setForeground(Color.GREEN);
		lblCriadoPorLeonardo.setBounds(395, 430, 317, 20);
		panel.add(lblCriadoPorLeonardo);
		
		JLabel lblBemvindosAMonster = new JLabel("Bem-vindos a Monster Dama!");
		lblBemvindosAMonster.setForeground(Color.GREEN);
		lblBemvindosAMonster.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBemvindosAMonster.setBounds(224, 11, 317, 38);
		panel.add(lblBemvindosAMonster);
		
		
		frameMain.setVisible(true);
		
		
	}
//click do botao, e menu do programa principal.

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String escolha = textField.getText();
		switch (escolha) {
		
		case "1":
			Menu_Principal.Cadastrar();
			frameMain.dispose();
			break;
			
		case "2": 
			Menu_Principal.Login();
			frameMain.dispose();
			break;
			
		case "3":
			Menu_Principal.Tutorial();
			frameMain.dispose();
			break;
		
			
		
		case "4":
			
			System.exit(0);
			break;
		default:
			
			
			
		}
	
	}
}
