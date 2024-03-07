package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //classe com as regras do jogo de xadrez; Quem tem que saber a dimencao de um tabuleiro e a ChessMatch
	
	private int turn;
	private Color currentPlayer;
	private Board board;
	
	//construtor padrao
	public ChessMatch() {
		board = new Board(8, 8); //definindo o tamanho do tabuleiro
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup(); //chama para posicionar as pecas
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
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
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	
	//aula 189 - retirar peca da pocicao de origem e colocar na posicao de destino
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source); //validando posicao de origem, se nao existir lanca exessao
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);//recebe o resultado do makeMovie e realiza o movimento da peca
		nextTurn();
		return (ChessPiece)capturedPiece; //retorna peca capturada e faz downcasting para ChessPiece
	}
		
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("The chose piece is not your");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	//metodo recebe coordenadas do xadrez
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup(){
		placeNewPiece('a', 1, new Rook(board, Color.WHITE));//passando as posicoes do xadrez
		placeNewPiece('h', 1, new Rook(board, Color.WHITE));
		placeNewPiece('a', 8, new Rook(board, Color.BLACK));
		placeNewPiece('h', 8, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
}
