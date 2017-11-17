package com.mygdx.game;


import com.mygdx.pieces.*;

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
    public  Knight knightp1;
    public  Knight knightp2;
    public  Knight knightp3;
    public  Knight knightp4;
    public  Knight knightp5;
    public  Knight knightp6;
    public  Knight knightp7;
    public  Knight knightp8;
    private  Queen queen;
    public  Queen queenp1;
    public  Queen queenp2;
    public  Queen queenp3;
    public  Queen queenp4;
    public  Queen queenp5;
    public  Queen queenp6;
    public  Queen queenp7;
    public  Queen queenp8;
    private Rook rook1;
    private Rook rook2;
    public Rook rookp1;
    public Rook rookp2;
    public Rook rookp3;
    public Rook rookp4;
    public Rook rookp5;
    public Rook rookp6;
    public Rook rookp7;
    public Rook rookp8;
    private  Bishop bishop1;
    private  Bishop bishop2;
    public  Bishop bishopp1;
    public  Bishop bishopp2;
    public  Bishop bishopp3;
    public  Bishop bishopp4;
    public  Bishop bishopp5;
    public  Bishop bishopp6;
    public  Bishop bishopp7;
    public  Bishop bishopp8;
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
        if(rookProms == 1 && rookp1.isOnTheGame()) {
            alivePieces.add(rookp1);
        }
        if(rookProms == 2 && rookp2.isOnTheGame()) {
            alivePieces.add(rookp2);
        }
        if(rookProms == 3 && rookp3.isOnTheGame()) {
            alivePieces.add(rookp3);
        }
        if(rookProms == 4 && rookp4.isOnTheGame()) {
            alivePieces.add(rookp4);
        }
        if(rookProms == 5 && rookp5.isOnTheGame()) {
            alivePieces.add(rookp5);
        }
        if(rookProms == 6 && rookp6.isOnTheGame()) {
            alivePieces.add(rookp6);
        }
        if(rookProms == 7 && rookp7.isOnTheGame()) {
            alivePieces.add(rookp7);
        }
        if(rookProms == 8 && rookp8.isOnTheGame()) {
            alivePieces.add(rookp8);
        }
        if(bishop1.isOnTheGame()) {
            alivePieces.add(bishop1);
        }
        if(bishop2.isOnTheGame()) {
            alivePieces.add(bishop2);
        }
        if(bishopProms == 1 && bishopp1.isOnTheGame()) {
            alivePieces.add(bishopp1);
        }
        if(bishopProms == 2 && bishopp2.isOnTheGame()) {
            alivePieces.add(bishopp2);
        }
        if(bishopProms == 3 && bishopp3.isOnTheGame()) {
            alivePieces.add(bishopp3);
        }
        if(bishopProms == 4 && bishopp4.isOnTheGame()) {
            alivePieces.add(bishopp4);
        }
        if(bishopProms == 5 && bishopp5.isOnTheGame()) {
            alivePieces.add(bishopp5);
        }
        if(bishopProms == 6 && bishopp6.isOnTheGame()) {
            alivePieces.add(bishopp6);
        }
        if(bishopProms == 7 && bishopp7.isOnTheGame()) {
            alivePieces.add(bishopp7);
        }
        if(bishopProms == 8 && bishopp8.isOnTheGame()) {
            alivePieces.add(bishopp8);
        }
        if(knight1.isOnTheGame()) {
            alivePieces.add(knight1);
        }
        if(knight2.isOnTheGame()) {
            alivePieces.add(knight2);
        }
        if(knightProms == 1 && knightp1.isOnTheGame()) {
            alivePieces.add(knightp1);
        }
        if(knightProms == 2 && knightp2.isOnTheGame()) {
            alivePieces.add(knightp2);
        }
        if(knightProms == 3 && knightp3.isOnTheGame()) {
            alivePieces.add(knightp3);
        }
        if(knightProms == 4 && knightp4.isOnTheGame()) {
            alivePieces.add(bishopp4);
        }
        if(knightProms == 5 && knightp5.isOnTheGame()) {
            alivePieces.add(knightp5);
        }
        if(knightProms == 6 && knightp6.isOnTheGame()) {
            alivePieces.add(knightp6);
        }
        if(knightProms == 7 && knightp7.isOnTheGame()) {
            alivePieces.add(knightp7);
        }
        if(knightProms == 8 && knightp8.isOnTheGame()) {
            alivePieces.add(knightp8);
        }
        if(king.isOnTheGame()) {
            alivePieces.add(king);
        }
        if(queen.isOnTheGame()) {
            alivePieces.add(queen);
        }
        if(queenProms == 1 && queenp1.isOnTheGame()) {
            alivePieces.add(queenp1);
        }
        if(queenProms == 2 && queenp2.isOnTheGame()) {
            alivePieces.add(queenp2);
        }
        if(queenProms == 3 && queenp3.isOnTheGame()) {
            alivePieces.add(queenp3);
        }
        if(queenProms == 4 && queenp4.isOnTheGame()) {
            alivePieces.add(queenp4);
        }
        if(queenProms == 5 && queenp5.isOnTheGame()) {
            alivePieces.add(queenp5);
        }
        if(queenProms == 6 && queenp6.isOnTheGame()) {
            alivePieces.add(queenp6);
        }
        if(queenProms == 7 && queenp7.isOnTheGame()) {
            alivePieces.add(queenp7);
        }
        if(queenProms == 8 && queenp8.isOnTheGame()) {
            alivePieces.add(queenp8);
        }
    }

    public void promotedPieces(Position pos, ChessBoard cb, int choice){
        Piece piece;
        switch (choice) {
            case (1):
                if (queenProms == 1) {
                    queenp1 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp1.revive();
                    alivePieces.add(queenp1);
                    cb.getSquareByPosition(pos).putPiece(queenp1);
                } else if (queenProms == 2){
                    queenp2 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp2.revive();
                    alivePieces.add(queenp2);
                    cb.getSquareByPosition(pos).putPiece(queenp2);
                } else if (queenProms == 3){
                    queenp3 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp3.revive();
                    alivePieces.add(queenp3);
                    cb.getSquareByPosition(pos).putPiece(queenp3);
                } else if (queenProms == 4) {
                    queenp4 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp4.revive();
                    alivePieces.add(queenp4);
                    cb.getSquareByPosition(pos).putPiece(queenp4);
                } else if (queenProms == 5) {
                    queenp5 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp5.revive();
                    alivePieces.add(queenp5);
                    cb.getSquareByPosition(pos).putPiece(queenp5);
                } else if (queenProms == 6) {
                    queenp6 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp6.revive();
                    alivePieces.add(queenp6);
                    cb.getSquareByPosition(pos).putPiece(queenp6);
                } else if (queenProms == 7) {
                    queenp7 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp7.revive();
                    alivePieces.add(queenp7);
                    cb.getSquareByPosition(pos).putPiece(queenp7);
                } else if (queenProms == 8) {
                    queenp8 = new Queen(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    queenp8.revive();
                    alivePieces.add(queenp8);
                    cb.getSquareByPosition(pos).putPiece(queenp8);
                }
                break;
            case (2):
                if (rookProms == 1) {
                    rookp1 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp1.revive();
                    alivePieces.add(rookp1);
                    cb.getSquareByPosition(pos).putPiece(rookp1);
                } else if (rookProms == 2){
                    rookp2 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp2.revive();
                    alivePieces.add(rookp2);
                    cb.getSquareByPosition(pos).putPiece(rookp2);
                } else if (rookProms == 3){
                    rookp3 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp3.revive();
                    alivePieces.add(rookp3);
                    cb.getSquareByPosition(pos).putPiece(rookp3);
                } else if (rookProms == 4) {
                    rookp4 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp4.revive();
                    alivePieces.add(rookp4);
                    cb.getSquareByPosition(pos).putPiece(rookp4);
                } else if (rookProms == 5) {
                    rookp6 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp1.revive();
                    alivePieces.add(rookp6);
                    cb.getSquareByPosition(pos).putPiece(rookp6);
                } else if (rookProms == 6) {
                    rookp6 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp6.revive();
                    alivePieces.add(rookp6);
                    cb.getSquareByPosition(pos).putPiece(rookp6);
                } else if (rookProms == 7) {
                    rookp7 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp7.revive();
                    alivePieces.add(rookp7);
                    cb.getSquareByPosition(pos).putPiece(rookp7);
                } else if (rookProms == 8) {
                    rookp8 = new Rook(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    rookp8.revive();
                    alivePieces.add(rookp8);
                    cb.getSquareByPosition(pos).putPiece(rookp8);
                }
                break;
            case (3):
                if (knightProms == 1) {
                    knightp1 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp1.revive();
                    alivePieces.add(knightp1);
                    cb.getSquareByPosition(pos).putPiece(knightp1);
                } else if (knightProms == 2){
                    knightp2 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp2.revive();
                    alivePieces.add(knightp2);
                    cb.getSquareByPosition(pos).putPiece(knightp2);
                } else if (knightProms == 3){
                    knightp3 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp3.revive();
                    alivePieces.add(knightp3);
                    cb.getSquareByPosition(pos).putPiece(knightp3);
                } else if (knightProms == 4) {
                    knightp4 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp4.revive();
                    alivePieces.add(knightp4);
                    cb.getSquareByPosition(pos).putPiece(knightp4);
                } else if (knightProms == 5) {
                    knightp5 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp5.revive();
                    alivePieces.add(knightp5);
                    cb.getSquareByPosition(pos).putPiece(knightp5);
                } else if (knightProms == 6) {
                    knightp6 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp6.revive();
                    alivePieces.add(knightp6);
                    cb.getSquareByPosition(pos).putPiece(knightp6);
                } else if (knightProms == 7) {
                    knightp7 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp7.revive();
                    alivePieces.add(knightp7);
                    cb.getSquareByPosition(pos).putPiece(knightp7);
                } else if (knightProms == 8) {
                    knightp8 = new Knight(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    knightp8.revive();
                    alivePieces.add(knightp8);
                    cb.getSquareByPosition(pos).putPiece(knightp8);
                }
                break;
            case (4):
                if (bishopProms == 1) {
                    bishopp1 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp1.revive();
                    alivePieces.add(bishopp1);
                    cb.getSquareByPosition(pos).putPiece(bishopp1);
                } else if (bishopProms == 2){
                    bishopp2 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp2.revive();
                    alivePieces.add(bishopp2);
                    cb.getSquareByPosition(pos).putPiece(bishopp2);
                } else if (bishopProms == 3){
                    bishopp3 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp3.revive();
                    alivePieces.add(bishopp3);
                    cb.getSquareByPosition(pos).putPiece(bishopp3);
                } else if (bishopProms == 4) {
                    bishopp4 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp4.revive();
                    alivePieces.add(bishopp4);
                    cb.getSquareByPosition(pos).putPiece(bishopp4);
                } else if (bishopProms == 5) {
                    bishopp5 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp5.revive();
                    alivePieces.add(bishopp5);
                    cb.getSquareByPosition(pos).putPiece(bishopp5);
                } else if (bishopProms == 6) {
                    bishopp6 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp6.revive();
                    alivePieces.add(bishopp6);
                    cb.getSquareByPosition(pos).putPiece(bishopp6);
                } else if (bishopProms == 7) {
                    bishopp7 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp7.revive();
                    alivePieces.add(bishopp7);
                    cb.getSquareByPosition(pos).putPiece(bishopp7);
                } else if (bishopProms == 8) {
                    bishopp8 = new Bishop(this, (char) (pos.getX() + 65), pos.getY() + 1);
                    bishopp8.revive();
                    alivePieces.add(bishopp8);
                    cb.getSquareByPosition(pos).putPiece(bishopp8);
                }
                break;
        }
        System.out.println("XXXXXXy");
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
