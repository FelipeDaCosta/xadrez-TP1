package com.mygdx.game;


import com.mygdx.pieces.*;
import java.util.ArrayList;

public class Player {

    private String name;
    private int numPlayer;
    private boolean myTurn=false;
    private  PieceList pieces;
    private  Pawn pawn1;
    private  Pawn pawn2;
    private  Pawn pawn3;
    private  Pawn pawn4;
    private  Pawn pawn5;
    private  Pawn pawn6;
    private Pawn pawn7;
    private  Pawn pawn8;
    private  King king;
    private  Knight knight1;
    private  Knight knight2;
    private  Queen queen;
    private Rook rook1;
    private Rook rook2;
    private  Bishop bishop1;
    private  Bishop bishop2;


    public Player(int numPlayer){
        this.name = "Player "+numPlayer;
        this.numPlayer = numPlayer;
        pawn1 = new Pawn(this,'A',2);
        pawn2 = new Pawn(this,'B',2);
        pawn3 = new Pawn(this,'C',2);
        pawn4 = new Pawn(this,'D',2);
        pawn5 = new Pawn(this,'E', 2);
        pawn6 = new Pawn(this,'F', 2);
        pawn7 = new Pawn(this,'G', 2);
        pawn8 = new Pawn(this,'H', 2);
        king = new King(this,'E', 1);
        queen = new Queen(this,'D', 1);
        knight1 = new Knight(this,'B', 1);
        knight2 = new Knight(this,'G', 1);
        rook1 = new Rook(this,'A', 1);
        rook2 = new Rook(this,'H', 1);
        bishop1 = new Bishop(this,'C', 1);
        bishop2 = new Bishop(this,'F', 1);
        pieces = new PieceList();

        if(numPlayer==2){
            king.setPosition('D',1);
            queen.setPosition('E',1);
        }

        pieces.add(pawn1);
        pieces.add(pawn2);
        pieces.add(pawn3);
        pieces.add(pawn4);
        pieces.add(pawn5);
        pieces.add(pawn6);
        pieces.add(pawn7);
        pieces.add(pawn8);
        pieces.add(rook1);
        pieces.add(rook2);
        pieces.add(bishop1);
        pieces.add(bishop2);
        pieces.add(knight1);
        pieces.add(knight2);
        pieces.add(king);
        pieces.add(queen);
    }

    public void setTurn(boolean b){
        this.myTurn = b;
    }

    public void refresh(){
        for(int i=0; i<pieces.size(); i++){
            if(!pieces.get(i).isOnTheGame()){
                pieces.remove(pieces.get(i));
            }
        }
    }

    public boolean getTurn(){
        return myTurn;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public int getNumber(){
        return numPlayer;
    }

    public PieceList getPieces() {
        return pieces;
    }
}
