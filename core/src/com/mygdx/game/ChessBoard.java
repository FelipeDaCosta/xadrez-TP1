package com.mygdx.game;

import com.mygdx.pieces.*;

import java.util.Scanner;

/*
*
* Esta Classe implementa um tabuleiro de Xadrez com seus métodos.
* O Tabuleiro é uma matriz de Squares.
*
* */


public class ChessBoard {
    private Square[][] board = new Square[8][8];
    private Piece lastKilled=null;
    private Position lastSource;
    private Position lastDestination;

    public ChessBoard(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                board[i][j] = new Square(i,j);
            }
        }
    }

    protected void move(Position source, Position destination){
        if(this.getSquareByPosition(source).isEmpty())
            return;

        if(this.getSquareByPosition(destination).hasPiece()){
            lastKilled = this.getSquareByPosition(destination).getPiece();
            this.getSquareByPosition(destination).getPiece().kill();
        }else{
            lastKilled = null;
        }

        Piece piece = this.getSquareByPosition(source).takePiece();
        this.getSquareByPosition(destination).putPiece(piece);
        this.getSquareByPosition(source).setEmpty();
        piece.setPosition(destination);
        lastSource = source;
        lastDestination = destination;
    }

    protected void unmove(){
        Piece piece = this.getSquareByPosition(this.lastDestination).takePiece();
        this.getSquareByPosition(this.lastSource).putPiece(piece);
        this.getSquareByPosition(this.lastDestination).setEmpty();
        piece.setPosition(this.lastSource);

        if(this.lastKilled!=null){
            this.lastKilled.revive();
            this.getSquareByPosition(this.lastDestination).putPiece(this.lastKilled);
            this.lastKilled=null;
        }
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

    public void placePieces(PieceList list){
        for(int i = 0; i < list.size(); i++){
            getSquareByPosition(list.get(i).getPosition()).putPiece(list.get(i));
        }
    }
}
