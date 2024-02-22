package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece{
		private Color color;

		public ChessPiece(Board board, Color color) {
			super(board);
			this.color = color;
		}
		//somente acesso a cor da peça, nao pode ser modificada
		public Color getColor() {
			return color;
		}
		
		
}
