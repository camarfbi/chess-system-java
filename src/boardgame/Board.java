package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece [][] pieces; //matriz de pecas
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1){//programacao defenciva nos metodos do board, verificando se existe linhas e colunas
		throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}
	
	//public void setRows(int rows) { removido para nao permitir alteracao de linhas, prog defenciva
	public int getColumns() {
		return columns;
	}
	
	//metodo para retornar a peca em uma linha/coluna
	public Piece piece(int row, int column) { //retorna um objeto Piece com o metodo piece, recebendo int row e column
		if(!positionExists(row, column)) { //prog defenciva, verifa se a pos existe no board
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column]; //retorna matriz pieces na linha e coluna
	}


	//sobrecarga do metodo informando linha e coluna
	public Piece piece(Position position) { //retorna um objeto Piece com o metodo piece, recebendo (Position position) retornando o metodo pela posicao
		if(!positionExists(position)) { //prog defesenciva, verifica se a posicao da peca existe 
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//metodo para implementar uma peca no tabuleiro
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) { //prog defenciva, verifica se ja existe uma peca na posicao
			throw new BoardException("There is already a piece " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece; //pega a matriz pieces[na posicao dada] = e atribui a peca que infomou
		piece.position = position; //informar que não esta na posicao nula, recebe a posicao informada no metodo public void placePiece(Piece piece, Position position)
	}
	
	//metodo aux para facilitar o teste por linha e coluna
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns; //condicao para ver se uma posicao existe
	} 
	
	//funcao positionExists para testar se uma posicao existe
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn()); //reaproveitando o metodo anterior que testa as linhas e colunas
	}
	
	//metodo para testar se ja tem uma peca na posicao
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) { //prog defesenciva, verifica se a posicao da peca existe 
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null; //testa se a peca na posicao e diferente de nulo (piece(position)) reaproveita o metodo Piece
	}
}
