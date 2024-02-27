package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) { //prog defensiva: testar se a coluna e linha é menor que o tabuleiro
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	
	//sem set para não permitir alteracao de linha
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected Position toPosition() { //converte o ChessPosition para o Position normal
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {//converte a posicao da matriz para posicao de xadrez (static pq esta sublinhada)
		return new ChessPosition((char)('a' - position.getColumn()),8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row; //string vazio para concatenar, forca o compilador a entender que é uma concatenacao de strings
	}
}
