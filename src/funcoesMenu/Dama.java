package funcoesMenu;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Dama extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L; 
	public static int width = 720, height = width; //parametro de quadrado
	public static final int tamanhoCasa = width/8; //8 casas para o tabuleiro
	public static final int casasPorLinha = width/tamanhoCasa; 
	public static int[][] baseGameData = new int[casasPorLinha][casasPorLinha]; //guarda o layout do tabuleiro 8x8
	public static int[][] gameData = new int[casasPorLinha][casasPorLinha]; //guarda as pecas no tabuleiro 8x8
	public static final int VAZIO = 0, VERDE = 1, DAMA_VERDE = 2, BRANCO = 3, DAMA_BRANCA = 4; //Representacao de pecas por valores pro tabuleiro
	public static JFrame frameDama;
	public static boolean gameInProgress = true;
	public static int jogadorAtual = VERDE;
	public boolean jogando = false; //verifica se alguem esta fazendo uma jogada
	public static int[][] jogadasPossiveis = new int[casasPorLinha][casasPorLinha]; //guarda as possiveis jogadas para peca clicada
	public int guardaLinha, guardaCol;
	public boolean pular = false;
	static BufferedImage crownImage = null;
	public int pontos;
	public static int pontosVerde;
	public static int pontosBranco;

	public static  void dama(){
		try {
			crownImage = ImageIO.read(new File("crown.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		new Dama();
	}
	
	public  Dama(){
		janela(width, height, this);
		jogadorAtual = VERDE;
		inicializaTabuleiro();
		repaint(); 
	}
	
	public boolean gameOver(){ 
		return gameOverInterno(0, 0, 0, 0);
	}
	
	public boolean gameOverInterno(int col, int linha, int verde, int branco){ 
		if(gameData[col][linha] == VERDE || gameData[col][linha] == DAMA_VERDE)
			verde += 1;
		if(gameData[col][linha] == BRANCO || gameData[col][linha] == DAMA_BRANCA)
			branco += 1;
		if(col == casasPorLinha-1 && linha == casasPorLinha-1){
			if(verde == 0 || branco == 0)
				return true;
			else return false;
		}
		if(col == casasPorLinha-1){
			linha += 1;
			col = -1;
		}
		return gameOverInterno(col+1, linha, verde, branco);
	}
	
	public void janela(int width, int height, Dama game){
		frameDama = new JFrame();
		frameDama.setSize(width, height);
		frameDama.setIconImage(crownImage);
		frameDama.setBackground(Color.cyan);
		frameDama.setLocationRelativeTo(null);
		frameDama.pack();
		Insets insets = frameDama.getInsets(); // insets é a representacao das bordas do tabuleiro
		int frameBordaEsquerda = insets.left;
		int frameBordaDireita = insets.right;
		int frameBordaCima = insets.top;
		int frameBordaBaixo = insets.bottom;
		frameDama.setPreferredSize(new Dimension(width + frameBordaEsquerda + frameBordaDireita, height + frameBordaBaixo + frameBordaCima));
		frameDama.setMaximumSize(new Dimension(width + frameBordaEsquerda + frameBordaDireita, height + frameBordaBaixo + frameBordaCima));
		frameDama.setMinimumSize(new Dimension(width + frameBordaEsquerda + frameBordaDireita, height + frameBordaBaixo + frameBordaCima));
		frameDama.setLocationRelativeTo(null);
		frameDama.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);    
		frameDama.addMouseListener(this);
		frameDama.requestFocus();
		frameDama.setVisible(true);
		frameDama.getContentPane().add(game);
		
	}
	

	
	
	public void inicializaTabuleiro(){
		//updata o tabuleiro na inicializacao
				
				for(int col = 0 ; col < (casasPorLinha); col++) {
					gameData[col][3] = VAZIO;
					gameData[col][4] = VAZIO;
				}
				
				
				for(int col=0; col < (casasPorLinha); col+=2){
					gameData[col][5] = VERDE;
					gameData[col][7] = VERDE;
				}
				for(int col=1; col < (casasPorLinha); col+=2)
					gameData[col][6] = VERDE;
				for(int col=1; col < (casasPorLinha); col+=2){
					gameData[col][0] = BRANCO;
					gameData[col][2] = BRANCO;
				}	
				for(int col=0; col < (casasPorLinha); col+=2)
					gameData[col][1] = BRANCO;
	}
	
	public static void desenhaPeca(int col, int linha, Graphics g, Color color){
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setColor(color);
		// These 2 and 4 values are arbitrary values that compensate for a smaller piece size than tileSize
		g.fillOval((col*tamanhoCasa)+2, (linha*tamanhoCasa)+2, tamanhoCasa-4, tamanhoCasa-4);
	}
	
	public void paint(Graphics g){ // metodo para desenhar no tabuleiro// repaint chama essa funcao toda vez que e feito um movimento e checa se o jogo acabou. 
		//desenha o tabuleiro e as pecas.
		super.paintComponent(g);
		for(int linha = 0; linha < casasPorLinha; linha++){
			for(int col = 0; col < casasPorLinha; col++){
				if((linha%2 == 0 && col%2 == 0) || (linha%2 != 0 && col%2 != 0)){ // atribui o padrao do tabuleiro. 
					baseGameData[col][linha] = 0;
					g.setColor(Color.gray);
					g.fillRect(col*tamanhoCasa, linha*tamanhoCasa, tamanhoCasa, tamanhoCasa);
				}
				else{
					baseGameData[col][linha] = 1;
					g.setColor(Color.darkGray);
					g.fillRect(col*tamanhoCasa, linha*tamanhoCasa, tamanhoCasa, tamanhoCasa);
				}
				if(checaPecaDoTime(col, linha) ==  true){			
					g.setColor(Color.darkGray.darker());
					g.fillRect(col*tamanhoCasa, linha*tamanhoCasa, tamanhoCasa, tamanhoCasa);
				}
				if(jogadasPossiveis[col][linha] == 1){
					g.setColor(Color.CYAN.darker());
					g.fillRect(col*tamanhoCasa, linha*tamanhoCasa, tamanhoCasa, tamanhoCasa);
				}
				if(gameData[col][linha] == BRANCO)
					desenhaPeca(col, linha, g, Color.white);
				else if(gameData[col][linha] == DAMA_BRANCA){
					desenhaPeca(col, linha, g, Color.white);
					g.drawImage(crownImage, (col*tamanhoCasa)+6, (linha*tamanhoCasa)+6, tamanhoCasa-12, tamanhoCasa-12, null);
				}
				else if(gameData[col][linha] == VERDE)
					desenhaPeca(col, linha, g, Color.green);
				else if(gameData[col][linha] == DAMA_VERDE){
					desenhaPeca(col, linha, g, Color.green);
				g.drawImage(crownImage, (col*tamanhoCasa)+6, (linha*tamanhoCasa)+6, tamanhoCasa-12, tamanhoCasa-12, null);
				}
			}
		}
		
		if(jogadorAtual == VERDE) {//verifica se é o turno do jogador com as pecas vermelhas, caso seja renderiza o indicador na tela
			TelaInfoPartida.vezVerde();
		
		}
		if(jogadorAtual == BRANCO) {//verifica se é o turno do jogador com as pecas  bracas, caso seja renderiza o indicador na tela
			TelaInfoPartida.vezBranco();
			
		}
		
		//
		if(gameOver() == true) {
			
			if (pontosVerde > pontosBranco) {
				TelaFinalDeJogo.ganhador = LoginUsuario.usuarioLogado[0];
			}else {
				TelaFinalDeJogo.ganhador = LoginUsuario.usuarioLogado[1];
			}
			CadastrarUsuario.userMap.get(LoginUsuario.usuarioLogado[0]).setPontos(Dama.pontosVerde);
			CadastrarUsuario.userMap.get(LoginUsuario.usuarioLogado[1]).setPontos(Dama.pontosBranco);
			
			TelaFinalDeJogo.TelaFinal();
			TelaInfoPartida.frameInfoPartida.dispose();
		}
			
	}	
	
	public void telaDeFimDeJogo(Graphics g) { //mostra game over em cima do tabuleiro
		 String msg = "Game Over";
	     Font small = new Font("Helvetica", Font.BOLD, 20);
	     FontMetrics metr = getFontMetrics(small);
	     g.setColor(Color.white);
	     g.setFont(small);
	     g.drawString(msg, (width - metr.stringWidth(msg)) / 2, width / 2);
	}
	
	
	public void resetaJogada(){
		guardaCol = 0;
		guardaLinha = 0;
		jogando = false;
		pular = false;
		for(int linha = 0; linha < casasPorLinha; linha++){
			
			for(int col = 0; col < casasPorLinha; col++){
				jogadasPossiveis[col][linha] = 0;
			}
		}
		repaint();
	}
	
	public void mousePressed(java.awt.event.MouseEvent evt) {
    	int col = (evt.getX()-8) / tamanhoCasa; // frame esquerdo 8 comprimento
        int linha = (evt.getY()-30) / tamanhoCasa; // frame superior 30 comprimento
		if(jogando == false && gameData[col][linha] != 0 || jogando == true && checaPecaDoTime(col, linha) == true){
			resetaJogada();
			guardaCol = col;
			guardaLinha = linha; 
			pegaJogadasDisponiveis(col, linha);
			
		}
		else if(jogando == true && jogadasPossiveis[col][linha] == 1){
			jogada(col, linha, guardaCol, guardaLinha);
		}
		else if(jogando == true && jogadasPossiveis[col][linha] == 0){
			resetaJogada();
		}
	}
	
	public void trocaJogador(){
		if(jogadorAtual == VERDE) {
			jogadorAtual = BRANCO;
			
		} 
	 else jogadorAtual = VERDE;
		
	}
	

	public void jogada(int col, int linha, int guardaCol, int guardaLinha){
		int x = gameData[guardaCol][guardaLinha]; //troca a peca para a nova casa
		gameData[col][linha] = x;
		gameData[guardaCol][guardaLinha] = VAZIO; //muda a casa antigada da peca para vazio
		criaDama(col, linha);
		if(pular == true)
			
			removePeca(col, linha, guardaCol, guardaLinha);
		 	resetaJogada();
		 	trocaJogador();
	}
	
	public boolean damaPecaCheck(int col, int linha){
		if(gameData[col][linha] == DAMA_VERDE || gameData[col][linha] == DAMA_BRANCA){
			return true;
		}
		else return false;
	}
	
	public int oponenteCheck(int col, int linha){
		if(gameData[col][linha] == VERDE || gameData[col][linha] ==  DAMA_VERDE)
			return BRANCO;
		else
			return VERDE;
	}
	
	public void checkExtraPulos(int col, int linha){
		int oponente = oponenteCheck(col, linha);
		int oponenteDama = oponenteCheck(col, linha) + 1;
		if(gameData[col-1][linha-1] == oponente || gameData[col-1][linha-1] == oponenteDama){
			jogadasPossiveis[col-1][linha-1] = 1;
		}
		else if(gameData[col+1][linha-1] == oponente || gameData[col+1][linha-1] == oponenteDama){
			jogadasPossiveis[col+1][linha-1] = 1;
		}
		else if(gameData[col-1][linha+1] == oponente || gameData[col-1][linha+1] == oponenteDama){
			jogadasPossiveis[col-1][linha+1] = 1;
		}
		else if(gameData[col+1][linha+1] == oponente || gameData[col+1][linha+1] == oponenteDama){
			jogadasPossiveis[col+1][linha+1] = 1;
		}
		repaint();
	}
	
	public void criaDama(int col, int linha){
		if(gameData[col][linha] == VERDE && linha == 0)
			gameData[col][linha] = DAMA_VERDE;
		else if(gameData[col][linha] == BRANCO && linha == casasPorLinha-1)
			gameData[col][linha] = DAMA_BRANCA;
		else return;
	}
	
	public void removePeca(int col, int linha, int guardaCol, int guardaLinha){ //remove peca baseado na posicao das pecas no tabuleiro
		int pecaLinha = -1; 
		int pecaCol = -1;
		//variavel pra checkar se o movimento comeu uma peca
		boolean comeu = false;
		
		if(col > guardaCol && linha > guardaLinha){
			pecaLinha = linha-1;
			pecaCol = col-1;
			if (gameData[pecaCol][pecaLinha] != VAZIO) { // se a casa no gamedata estiver preenchida comeu se torna verdadeiro
				comeu = true;
			}
			
			
		}
		if(col > guardaCol && linha < guardaLinha){
			pecaLinha = linha+1;
			pecaCol = col-1;
			if (gameData[pecaCol][pecaLinha] != VAZIO) {
				comeu = true;
			}
		}
		if(col < guardaCol && linha > guardaLinha){
			pecaLinha = linha-1;
			pecaCol = col+1;
			if (gameData[pecaCol][pecaLinha] != VAZIO) {
				comeu = true;
			}
		}
		if(col < guardaCol && linha < guardaLinha){
			pecaLinha = linha+1;
			pecaCol = col+1;
			if (gameData[pecaCol][pecaLinha] != VAZIO) {
				comeu = true;
			}
		}
		
		
		gameData[pecaCol][pecaLinha] = VAZIO;
		 
			if(comeu == true) { //se comeu for verdadeiro, adiciona os pontos pro usuario que efetuou o movimento checando qual peca/cor fez o movimento
				
				 if(gameData[col][linha] == VERDE ||gameData[col][linha] == DAMA_VERDE) {
					 
					 	pontosVerde = pontosVerde + 100;
						TelaInfoPartida.pontosVerde();
				 }else if(gameData[col][linha] == BRANCO || gameData[col][linha] == DAMA_BRANCA) {
											
							pontosBranco = pontosBranco +100;
							TelaInfoPartida.pontosBranco();
					  }
					}
				
			}
			
			
			
	
	
	public void pegaJogadasDisponiveis(int col, int linha){
		jogando = true;
		if((checaPecaDoTime(col, linha) == true)){ //checa se a peca e do jogador atual
			if(gameData[col][linha] == VERDE){  // so vai pra cima.
				vaiPraCima(col, linha);
			}
			if(gameData[col][linha] == BRANCO){ // so vai pra baixo
				vaiPraBaixo(col, linha);
			}
			if(gameData[col][linha] == DAMA_VERDE || gameData[col][linha] == DAMA_BRANCA){ //vai pra cima ou pra baixo
				vaiPraCima(col, linha);
			  
				vaiPraBaixo(col, linha); 
			}
			
			
		repaint();
		}
	}
	
	public void vaiPraCima(int col, int linha){ 
		int linhaCima = linha-1;
		if(col == 0 && linha != 0){ //X=0, Y nao é 0
			for(int i = col; i < col+2; i++){ //checa pra direita
				if(gameData[col][linha] != 0 && gameData[i][linhaCima] != 0){
					if(podePular(col, linha, i, linhaCima) == true){
						int pulaCol = pegaPulo(col, linha, i, linhaCima)[0];
						int pulaLinha = pegaPulo(col, linha, i, linhaCima)[1];
						
						jogadasPossiveis[pulaCol][pulaLinha] = 1;
					}
				}
				else if(baseGameData[i][linhaCima] == 1 && gameData[i][linhaCima] == 0)
					jogadasPossiveis[i][linhaCima] = 1;
				   
			}
		}
		else if(col == (casasPorLinha - 1) && linha != 0){ //X=max, Y nao é 0
				if(gameData[col][linha] != 0 && gameData[col-1][linhaCima] != 0){
					if(podePular(col, linha, col-1, linhaCima) == true){
						int pulaCol = pegaPulo(col, linha, col-1, linhaCima)[0];
						int pulaLinha = pegaPulo(col, linha, col-1, linhaCima)[1];
						jogadasPossiveis[pulaCol][pulaLinha] = 1;
						
					}
				}
				else if(baseGameData[col-1][linhaCima] == 1 && gameData[col-1][linhaCima] == 0)
					jogadasPossiveis[col-1][linhaCima] = 1;
				
		}
		else if(col != casasPorLinha - 1 && col != 0 && linha != 0){
			for(int i = col-1; i <= col+1; i++){
				if(gameData[col][linha] != 0 && gameData[i][linhaCima] != 0){
					if(podePular(col, linha, i, linhaCima) == true){
						int pulaCol = pegaPulo(col, linha, i, linhaCima)[0];
						int pulaLinha = pegaPulo(col, linha, i, linhaCima)[1];
						jogadasPossiveis[pulaCol][pulaLinha] = 1;
						
					}
				}
				else if(baseGameData[i][linhaCima] == 1 && gameData[i][linhaCima] == 0)
					jogadasPossiveis[i][linhaCima] = 1;
				
			}
		}
	}
	
	public void vaiPraBaixo(int col, int linha){
		int linhaBaixo = linha+1;
		if(col == 0 && linha != casasPorLinha-1){
				if(gameData[col][linha] != 0 && gameData[col+1][linhaBaixo] != 0){
					if(podePular(col, linha, col+1, linhaBaixo) == true){
						int pulaCol = pegaPulo(col, linha, col+1, linhaBaixo)[0];
						int pulaLinha = pegaPulo(col, linha, col+1, linhaBaixo)[1];
						jogadasPossiveis[pulaCol][pulaLinha] = 1;
					}
				}
				else if(baseGameData[col+1][linhaBaixo] == 1 && gameData[col+1][linhaBaixo] == 0)
					jogadasPossiveis[col+1][linhaBaixo] = 1;
		}
		else if(col == casasPorLinha - 1 && linha != casasPorLinha-1){
				if(gameData[col][linha] != 0 && gameData[col-1][linhaBaixo] != 0){
					if(podePular(col, linha, col-1, linhaBaixo) == true){
						int pulaCol = pegaPulo(col, linha, col-1, linhaBaixo)[0];
						int pulaLinha = pegaPulo(col, linha, col-1, linhaBaixo)[1];
						jogadasPossiveis[pulaCol][pulaLinha] = 1;
					}
				}
				else if(baseGameData[col-1][linhaBaixo] == 1 && gameData[col-1][linhaBaixo] == 0)
					jogadasPossiveis[col-1][linhaBaixo] = 1;
		}
		else if(col != casasPorLinha-1 && col != 0 && linha != casasPorLinha-1){
			for(int i = col-1; i <= col+1; i++){
				if(gameData[col][linha] != 0 && gameData[i][linhaBaixo] != 0){
					if(podePular(col, linha, i, linhaBaixo) == true){
						int puloCol = pegaPulo(col, linha, i, linhaBaixo)[0];
						int puloLinha = pegaPulo(col, linha, i, linhaBaixo)[1];
						jogadasPossiveis[puloCol][puloLinha] = 1;
					}
				}
				else if(baseGameData[i][linhaBaixo] == 1 && gameData[i][linhaBaixo] == 0)
					jogadasPossiveis[i][linhaBaixo] = 1;
			}
		}
	}
	
	public boolean checaPecaDoTime(int col, int linha){
		if(jogadorAtual == VERDE && (gameData[col][linha] == VERDE || gameData[col][linha] == DAMA_VERDE)) //baixo
			return true;
		if(jogadorAtual == BRANCO && (gameData[col][linha] == BRANCO || gameData[col][linha] == DAMA_BRANCA)) //cima
			return true;
		else
			return false;
	}
	
	public boolean posMovimentoValido(int col, int linha){
		if(linha < 0 || linha >= casasPorLinha || col < 0 || col >= casasPorLinha)
			return false;
		else return true;
	}
	
	public boolean podePular(int col, int linha, int oponenteCol, int oponenteLinha){
		//pacos para checar seu pode pular é verdadeiro: 
		//determina qual peca com o movimento. 
		//checa se é uma peca do oponente. 
		//checa se a casa atras esta vazia e nos limites do tabuleiro
		
		// 4 condicoes no IF baseado na linha e coluna em relacao com as outras pecas.
		if(((gameData[col][linha] == BRANCO || gameData[col][linha] == DAMA_BRANCA) && (gameData[oponenteCol][oponenteLinha] == VERDE || gameData[oponenteCol][oponenteLinha] == DAMA_VERDE)) || (gameData[col][linha] == VERDE || gameData[col][linha] == DAMA_VERDE) && (gameData[oponenteCol][oponenteLinha] == BRANCO || gameData[oponenteCol][oponenteLinha] == DAMA_BRANCA)){ 
			//se a peca for Branca/Verde e a do oponente for o contrario.
			if(oponenteCol == 0 || oponenteCol == casasPorLinha-1 || oponenteLinha == 0 || oponenteLinha == casasPorLinha-1)
				return false;
			int[] toData = pegaPulo(col, linha, oponenteCol, oponenteLinha);
		    if(posMovimentoValido(toData[0],toData[1]) == false) //checa se esta fora dos limites do tabuleiro
		        return false;
		    if(gameData[toData[0]][toData[1]] == 0){
		    	pular = true;
		    	return true;
	
		    }
		}
		return false;
	}
	
	public int[] pegaPulo(int col, int linha, int oponenteCol, int oponenteLinha){
		if(col > oponenteCol && linha > oponenteLinha && gameData[col-2][linha-2] == 0) {
			
			return new int[] {col-2, linha-2};
		}
			
		else if(col > oponenteCol && linha < oponenteLinha && gameData[col-2][linha+2] == 0) {
			
			return new int[] {col-2, linha+2};
		}
			
		else if(col < oponenteCol && linha > oponenteLinha && gameData[col+2][linha-2] == 0) {
			
			return new int[] {col+2, linha-2};
		}
			
		else {
			
			if((gameData[col][linha] == BRANCO  && gameData[col+1][linha+1] != VAZIO)|| (gameData[col][linha] == DAMA_BRANCA && gameData[col+1][linha+1] != VAZIO)|| (gameData[col][linha] == DAMA_VERDE  && gameData[col+2][linha+2] == 0 && gameData[col+1][linha+1] != VAZIO) ) {
				return new int[] {col+2, linha+2};
			}
			return new int[] {col, linha};
		}
			
	}
	
	// Metodos Obrigatorios  para os eventos de Mouse Funcionar
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {}

}	