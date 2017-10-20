package com.mygdx.pieces;

import java.util.ArrayList;

public class PieceList extends ArrayList<Piece> {


    public void printListPositions(String headmessage){
        int size = this.size();
        char X; int Y;
        System.out.println(headmessage);
        for(int i=0; i<size; i++){
            X = (char) (this.get(i).getPosition().getX()+65);
            Y = this.get(i).getPosition().getY()+1;
            System.out.print("("+X+","+Y+") ");
        }
        System.out.println();
    }
    public void printListPieces(String headmessage){
        int size = this.size();
        char X; int Y;
        System.out.print(headmessage);
        for(int i=0; i<size; i++){
            System.out.print(" "+this.get(i).getPieceCode()+this.get(i).getPlayer().getNumber()+" ");
        }
        System.out.println();
    }
}
