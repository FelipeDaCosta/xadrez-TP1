package com.mygdx.game;

import com.mygdx.pieces.Piece;

import java.util.ArrayList;

public class PositionList extends ArrayList<Position> {


    public void printListPositions(String headmessage){
        int size = this.size();
        char X; int Y;
        System.out.println(headmessage);
        for(int i=0; i<size; i++){
            X = (char) (this.get(i).getX()+65);
            Y = this.get(i).getY()+1;
            System.out.print("("+X+","+Y+") ");
        }
        System.out.println();
    }

    public void printListPieces(String headmessage, ChessBoard cb){
        Piece piece;
        int size = this.size();
        char X; int Y;
        System.out.print(headmessage);
        for(int i=0; i<size; i++){
            if(cb.byPosition(this.get(i)).hasPiece()) {
                piece = cb.byPosition(this.get(i)).getPiece();
                System.out.print(" " + piece.getPieceCode() + piece.getPlayer().getNumber() + " ");
            }else{
                System.out.print(" NONE ");
            }
        }
        System.out.println();
    }
}
