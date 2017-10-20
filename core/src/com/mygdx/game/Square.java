package com.mygdx.game;

import com.mygdx.pieces.*;

/*
*   Classe Square, basicamente, um tabuleiro será uma matriz de Squares
*   Atributos: posição X e Y (0-7,0-7), vazio, e peça (se houver)
*
 */
public class Square{

    private int X;
    private int Y;
    private boolean empty = true;
    private Piece piece;


    public Square(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public boolean hasPiece(){
        return !empty;
    }
    public boolean isEmpty(){
        return empty;
    }

    public void putPiece(Piece p){
        this.piece = p;
        this.empty=false;;

    }

    public void setEmpty(){
        this.empty=true;
    }

    public Piece takePiece() {
        if (!empty) {
            empty = true;
            return piece;
        }
        return null;
    }

    public Piece getPiece(){

        return this.piece;
    }

     public int getX() { return X; }

     public int getY() { return Y; }

     public Position getPosition(){
        return new Position(X,Y);
     }


}
