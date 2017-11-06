package com.mygdx.game;


import com.mygdx.pieces.*;

/*
* Esta classe implementa o objeto jogador que basicamente tem uma lista de peças, a variável que diz se é sua vez
* o seu nome e seu número (1 ou 2) que indica em qual lado do tabuleiro ele joga (na hora de desenhar na tela também
* decide qual cor terão suas peças)
* */


public class Player {
    private String name;
    private int numPlayer;
    private boolean myTurn=false;
    private boolean underCheck=false;
    private  PieceList alivePieces;
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
    Player enemy;


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
        alivePieces = new PieceList();

        if(numPlayer==2){
            king.setPosition('D',1);
            queen.setPosition('E',1);
        }

        alivePieces.add(pawn1);
        alivePieces.add(pawn2);
        alivePieces.add(pawn3);
        alivePieces.add(pawn4);
        alivePieces.add(pawn5);
        alivePieces.add(pawn6);
        alivePieces.add(pawn7);
        alivePieces.add(pawn8);
        alivePieces.add(rook1);
        alivePieces.add(rook2);
        alivePieces.add(bishop1);
        alivePieces.add(bishop2);
        alivePieces.add(knight1);
        alivePieces.add(knight2);
        alivePieces.add(king);
        alivePieces.add(queen);
    }

    public void setTurn(boolean b){
        this.myTurn = b;
    }

    public void refresh(){

        this.alivePieces.clear();

        if(pawn1.isOnTheGame()) {
            alivePieces.add(pawn1);
        }
        if(pawn2.isOnTheGame()) {
            alivePieces.add(pawn2);
        }
        if(pawn3.isOnTheGame()) {
            alivePieces.add(pawn3);
        }
        if(pawn4.isOnTheGame()) {
            alivePieces.add(pawn4);
        }
        if(pawn5.isOnTheGame()) {
            alivePieces.add(pawn5);
        }
        if(pawn6.isOnTheGame()) {
            alivePieces.add(pawn6);
        }
        if(pawn7.isOnTheGame()) {
            alivePieces.add(pawn7);
        }
        if(pawn8.isOnTheGame()) {
            alivePieces.add(pawn8);
        }
        if(rook1.isOnTheGame()) {
            alivePieces.add(rook1);
        }
        if(rook2.isOnTheGame()) {
            alivePieces.add(rook2);
        }
        if(bishop1.isOnTheGame()) {
            alivePieces.add(bishop1);
        }
        if(bishop2.isOnTheGame()) {
            alivePieces.add(bishop2);
        }
        if(knight1.isOnTheGame()) {
            alivePieces.add(knight1);
        }
        if(knight2.isOnTheGame()) {
            alivePieces.add(knight2);
        }
        if(king.isOnTheGame()) {
            alivePieces.add(king);
        }
        if(queen.isOnTheGame()) {
            alivePieces.add(queen);
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
        return king.getPosition();
    }

    public int getNumber(){
        return numPlayer;
    }

    public PieceList getPieces() {
        return alivePieces;
    }

    public void setUnderCheck(boolean underCheck) {
        this.underCheck = underCheck;
    }
}
