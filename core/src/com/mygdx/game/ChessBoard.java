package com.mygdx.game;

import com.mygdx.pieces.*;

/*
*
* Esta Classe implementa um tabuleiro de Xadrez com seus métodos.
* O Tabuleiro é uma matriz de Squares.
*
* */


public class ChessBoard {
    private Square[][] board = new Square[8][8];

    ChessLogic chessLogic = new ChessLogic();
    public ChessBoard(){

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                board[i][j] = new Square(i,j);
            }
        }

    }

    protected void move(Position source, Position destination){
        Piece piece = this.getSquareByPosition(source).getPiece();
        this.getSquareByPosition(destination).putPiece(piece);
        this.getSquareByPosition(piece.getPosition()).setEmpty();
        piece.setPosition(destination);
    }

    /*Este método imprime o tabuleiro na linha de comando num formato "bonitinho"*/
    public void printBoard(){
        for(int j=7; j>-1; j--){
            System.out.println();
            System.out.print(" "+(j+1)+" ");
            for(int i=0; i<8; i++){
                if(board[i][j].isEmpty()){
                    System.out.print("  X   ");
                }else{
                        System.out.print(" " + board[i][j].getPiece().getPieceCode()
                                + board[i][j].getPiece().getNumPlayer()+ " ");
                }
            }
            System.out.println();

        }
        System.out.print("   ");
        for( int i=0; i<8; i++){
            System.out.print("  "+(char)(65 + i) +"   ");
        }
        System.out.println();
    }

    public Square getSquareByPosition(Position pos){
        if(pos.isValidPosition())
            return board[pos.getX()][pos.getY()];
        return null;
    }

    public Square getSquare(int i, int j) {
        return board[i][j];
    }

    public Square[][] getBoard() {
        return board;
    }
}
