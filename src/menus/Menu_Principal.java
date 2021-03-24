package menus;



import funcoesMenu.CadastrarUsuario;
import funcoesMenu.LoginUsuario;

import funcoesMenu.Tutorial;

public  class  Menu_Principal {
	
	
	

	public static void Cadastrar() {
		CadastrarUsuario.cadastro();
	}
	public static void Login() {
		LoginUsuario.logar();
	}
	
	
	
	public static void Tutorial() {
		//chamar tutorial
		Tutorial.tutorial();
		
	}
	
	
}
