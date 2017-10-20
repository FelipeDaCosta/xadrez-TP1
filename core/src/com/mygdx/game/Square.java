package com.mygdx.game;

import com.mygdx.drawable.Drawable;
import com.mygdx.pieces.*;

/**
 * Created by felipecosta on 10/2/17.
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

    /*Temporarios*/
    public void setEmpty(){
        this.empty=true;
    }
    public void putPieceByForce(Piece p){
        this.piece = p;
        this.empty=false;
    }

    public Piece takePiece() {
        if (!empty) {
            empty = true;
            return piece;
        }
        System.out.println("Erro, você tentou tirar uma peça da casa "+X+" "+Y+" que esta vazia!");
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
