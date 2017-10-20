package com.mygdx.game;

import com.mygdx.pieces.*;

import java.util.ArrayList;

public class ChessBoard {
    private int numPlayers=0;
    private Square[][] squares = new Square[8][8];
    ChessLogic chessLogic = new ChessLogic();
    int whoseTurn=1;
    Player player1;
    Player player2;

    //Construtor feito para testes TODO apagar

    public Square getSquare(int i, int j) {
        return squares[i][j];
    }

    public ChessBoard(){

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                squares[i][j] = new Square(i,j);
            }
        }

    }

    public Player join(){
        if(numPlayers==0) {
            player1 = new Player(1);
            for(int i=0; i < player1.getPieces().size(); i++){
                this.byPosition(player1.getPieces().get(i).getPosition()).putPiece(player1.getPieces().get(i));
            }
            player1.setTurn(true);
            numPlayers++;
            return player1;
        }
        if(numPlayers==1){
            player2 = new Player(2);
            for(int i=0; i < player2.getPieces().size(); i++){
                this.byPosition(player2.getPieces().get(i).getPosition().toInverted()).putPiece(player2.getPieces().get(i));
            }
            player2.setTurn(false);
            numPlayers++;
            return player2;
        }else{
            System.out.println("Tabuleiro ocupado");
            return null;
        }
    }

    private void move(Position source, Position destination){
        Piece piece = this.byPosition(source).getPiece();
        this.byPosition(destination).putPiece(piece);
        this.byPosition(piece.getPosition()).setEmpty();
        piece.setPosition(destination);
    }

    public boolean requestMove(Player p, Position source, Position dest){

        if(this.byPosition(source).isEmpty()){
            System.out.println("Não há peça na casa de origem do movimento");
            return false;
        }

        if(!chessLogic.moveAnalisys(this, p, this.byPosition(source).getPiece(),dest)) {
            System.out.println("Jogada não consentida.");
            return false;
        }
        if(this.byPosition(dest).hasPiece()){
            this.byPosition(dest).getPiece().kill();
            this.byPosition(dest).getPiece().getPlayer().refresh();
        }
        move(source, dest);
        p.refresh();
        //changeTurn();
        return true;
    }

    public Square byPosition(Position pos){
        if(pos.isValidPosition())
            return squares[pos.getX()][pos.getY()];
        return null;
    }

    public void printBoard(){
        for(int j=7; j>-1; j--){
            System.out.println();
            System.out.print(" "+(j+1)+" ");
            for(int i=0; i<8; i++){
                if(squares[i][j].isEmpty()){
                    System.out.print("  X   ");
                }else{
                        System.out.print(" " + squares[i][j].getPiece().getPieceCode() + squares[i][j].getPiece().getNumPlayer()+ " ");
                }
            }
            System.out.println();

        }
        System.out.print("   ");
        for( int i=0; i<8; i++){
            System.out.print("  "+(char)(65 + i) +"   ");
        }
        System.out.println();
    }

    public void changeTurn(){
        if(whoseTurn==1) whoseTurn = 2;
        else whoseTurn=1;
        player1.setTurn(!player1.getTurn());
        player2.setTurn(!player2.getTurn());
    }

    public void printListOfPieces(ArrayList<Piece> pieces, String name){
        System.out.println("Pieces of "+name);
        int size = pieces.size();
        for(int i=0; i<size; i++){
            System.out.print(pieces.get(i).getPieceCode()+" ");
        }
        System.out.println();
    }

    public int getWhoseTurn(){
        return whoseTurn;
    }

    public Square[][] getSquareBoard() {
        return squares;
    }
}
