package boardgame;

public abstract class Piece {
	
	protected Position position; //nao permite visibilidade na camada xadrez
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null; //posicao de uma paca recem criada = nulo (não precisa informar, por padrao o valor e null)
	}

	protected Board getBoard() { //somente classe dentro do mesmo pacote e subclasses pode acessar o tabuleiro de uma peca 
		return board;
	}
	
	public abstract boolean [][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0; i < mat.length; i++) {
			for(int j=0; j < mat.length; j++) {
				if(mat[i][j]) {
				return true;
				}
			}
		}
		return false;
	}
}
