package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //classe com as regras do jogo de xadrez; Quem tem que saber a dimencao de um tabuleiro e a ChessMatch
	
	private Board board;
	//construtor padrao
	public ChessMatch() {
		board = new Board(8, 8); //definindo o tamanho do tabuleiro
		initialSetup(); //chama para posicionar as pecas
	}
	//metodo para retornar uma matriz de pecas de xadrez correspondente a essa partida
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i < board.getRows(); i++) {
			for(int j=0; j < board.getColumns();j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); //fez Downcast para interpretar como peca de xadres e nao uma peca comum
			}
		}
		return mat;
	}
	
	private void initialSetup(){
		board.placePiece(new Rook(board, Color.WHITE), new Position(0, 0));
		board.placePiece(new Rook(board, Color.WHITE), new Position(0, 7));
		board.placePiece(new Rook(board, Color.BLACK), new Position(7, 0));
		board.placePiece(new Rook(board, Color.BLACK), new Position(7, 7));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
