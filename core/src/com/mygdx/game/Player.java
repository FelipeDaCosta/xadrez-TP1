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
    public int queenProms = 0;
    public int rookProms = 0;
    public int knightProms = 0;
    public int bishopProms = 0;
    private String name;
    private int numPlayer;
    private boolean myTurn=false;
    private boolean underCheck=false;
    public boolean isEnemy = false;
    private  PieceList alivePieces;
    PieceList piecesList = new PieceList();
    public Player enemy;


    public Player(int numPlayer, boolean isEnemy){
        this.name = "Player "+numPlayer;
        this.numPlayer = numPlayer;
        this.isEnemy = isEnemy;
        piecesList.add(new Pawn(this,'A',2));
        piecesList.add(new Pawn(this,'B',2));
        piecesList.add(new Pawn(this,'C',2));
        piecesList.add(new Pawn(this,'D',2));
        piecesList.add(new Pawn(this,'E',2));
        piecesList.add(new Pawn(this,'F',2));
        piecesList.add(new Pawn(this,'G',2));
        piecesList.add(new Pawn(this,'H',2));
        piecesList.add(new King(this,'E',1));
        piecesList.add(new Queen(this,'D',1));
        piecesList.add(new Knight(this,'B',1));
        piecesList.add(new Knight(this,'G',1));
        piecesList.add(new Rook(this,'A',1));
        piecesList.add(new Rook(this,'H',1));
        piecesList.add(new Bishop(this,'C',1));
        piecesList.add(new Bishop(this,'F',1));


        if(numPlayer==1) {
            piecesList.add(new King(this, 'E', 1));
            piecesList.add(new Queen(this, 'D', 1));
        }
        if(numPlayer==2){
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

    public void promotedPieces(Position pos, ChessBoard cb, int choice, Piece piece){
        switch (choice) {
            case (1):
                piece = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
            case (2):
                piece = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
            case (3):
                piece = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
            case (4):
                piece = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
        }
        piece.revive();
        alivePieces.add(piece);
        cb.getSquareByPosition(pos).putPiece(piece);
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
        return piecesList.get(8).getPosition();
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
