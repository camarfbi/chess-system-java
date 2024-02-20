package boardgame;

public class Piece {
	
	protected Position position; //nao permite visibilidade na camada xadrez
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null; //posicao de uma paca recem criada = nulo (não precisa informar, por padrao o valor e null)
	}


	protected Board getBoard() { //somente classe dentro do mesmo pacote e subclasses pode acessar o tabuleiro de uma peca 
		return board;
	}
}
