package com.mygdx.game;


import com.mygdx.pieces.*;

import java.util.ArrayList;
import java.util.List;

/*
* Esta classe implementa o objeto jogador que basicamente tem uma lista de peças, a variável que diz se é sua vez
* o seu nome e seu número (1 ou 2) que indica em qual lado do tabuleiro ele joga (na hora de desenhar na tela também
* decide qual cor terão suas peças)
* */


public class Player {
    private String name;
    public boolean whitePieces;
    private int num;
    public  boolean isEnemy = false;
    private boolean myTurn=false;
    private boolean underCheck=false;
    private PieceList alivePieces;
    private PieceList piecesList = new PieceList();
    public  Player enemy;



    public Player(boolean whitePieces, boolean isEnemy){
        this.whitePieces = whitePieces;
        this.isEnemy = isEnemy;

        piecesList.add(new Pawn(this,'A',2));
        piecesList.add(new Pawn(this,'B',2));
        piecesList.add(new Pawn(this,'C',2));
        piecesList.add(new Pawn(this,'D',2));
        piecesList.add(new Pawn(this,'E',2));
        piecesList.add(new Pawn(this,'F',2));
        piecesList.add(new Pawn(this,'G',2));
        piecesList.add(new Pawn(this,'H',2));
        piecesList.add(new Knight(this,'B',1));
        piecesList.add(new Knight(this,'G',1));
        piecesList.add(new Rook(this,'A',1));
        piecesList.add(new Rook(this,'H',1));
        piecesList.add(new Bishop(this,'C',1));
        piecesList.add(new Bishop(this,'F',1));

        if(whitePieces) {
            myTurn=true;
            this.name = "Player 1";
            piecesList.add(new King(this, 'E', 1));
            piecesList.add(new Queen(this, 'D', 1));
        }
        else{
            this.name = "Player 2";
            piecesList.add(new King(this,'D',1));
            piecesList.add(new Queen(this,'E',1));
        }

        if(isEnemy) piecesList.invertAll();

        alivePieces = new PieceList();
        alivePieces.addAll(piecesList);
    }

    public void setTurn(boolean b){
        this.myTurn = b;
    }

    public void refresh(){

        this.alivePieces.clear();
        for(int i=0 ;i<piecesList.size();i++){
            if(piecesList.get(i).isOnTheGame()) {
                alivePieces.add(piecesList.get(i));
            }
        }
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
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

    public Position getKingPosition(){
        for(int i=0; i<piecesList.size(); i++)
            if(piecesList.get(i).getPieceCode()==PieceCode.KNG) {
                return piecesList.get(i).getPosition();
            }
        return null;
    }

    public int getNumber(){
        return this.num;
    }

    public PieceList getPieces() {
        return alivePieces;
    }

    public void setUnderCheck(boolean underCheck) {
        this.underCheck = underCheck;
    }
}
