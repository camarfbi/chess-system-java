package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece [][] pieces; //matriz de pecas
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	//metodo para retornar a peca em uma linha/coluna
	public Piece piece(int row, int column) { //retorna um objeto Piece com o metodo piece, recebendo int row e column
		return pieces[row][column]; //retorna matriz pieces na linha e coluna
	}
	//sobrecarga do metodo informando linha e coluna
	public Piece piece(Position position) { //retorna um objeto Piece com o metodo piece, recebendo (Position position) retornando o metodo pela posicao
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//metodo para implementar uma peca no tabuleiro
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece; //pega a matriz pieces[na posicao dada] = e atribui a peca que infomou
		piece.position = position; //informar que não esta na posicao nula, recebe a posicao informada no metodo public void placePiece(Piece piece, Position position)
	}
}
