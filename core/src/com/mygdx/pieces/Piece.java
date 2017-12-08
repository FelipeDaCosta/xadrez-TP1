package com.mygdx.pieces;

import com.mygdx.game.*;

/**
 *
 * Classe abstrata to objeto tipo Peça, que possui uma posição, um jogador (dono)
 * a informação OnTheGame (indica se a peça tá viva)
 *
 *
 * Obs:
 * Anteriormente a classe piece estendia a Drawable, eu desacoplei totalmente a lógica do jogo da parte gráfica,
 * a classe que desenha peça na tela agora é a DrawPiece (idealmente só quem desenhará peça serão os clientes, não o servidor)
 *
 */
public abstract class Piece{
    private PieceCode pieceCode;
    private Position position;
    private boolean onTheGame = true;
    protected Player player;
    protected int numPlayer;

    public Piece(PieceCode pieceCode, char X, int Y) {
        this.pieceCode = pieceCode;
        position = new Position(X,Y);
    }
    public Piece(PieceCode pieceCode, Position pos) {
        this.pieceCode = pieceCode;
        position = new Position(pos.getX(), pos.getY());
    }
    public void setPosition(char X, int Y){
        position.setPosition(X,Y);
    }

    public void setPosition(Position p){
        this.position = p;
    }
    public Position getPosition(){
        return position;
    }

    public void kill(){
        this.onTheGame = false;
    }
    public void revive(){
        this.onTheGame = true;
    }

    public PieceCode getPieceCode() {
        return this.pieceCode;
    }

    public int getPlayerNumber(){
        return this.player.getNumber();
    }
    public Player getPlayer(){
        return this.player;
    }

    public boolean isEnemy(Piece p){
        if(p.getPlayer()==this.player)
            return false;
        return true;
    }

    public boolean isOnTheGame(){
        return this.onTheGame;
    }

    public void promotePawn(/*Piece p,*/ int choice,ChessBoard cb){
        Piece p = this;
        Player owner = p.getPlayer();
        Position pos = p.getPosition();
        cb.getSquareByPosition(pos).getPiece().kill();
        cb.getSquareByPosition(pos).setEmpty();
        
        if(p.getPieceCode()!=PieceCode.PAW || choice > 4 || choice <1) return;

        p.kill();

        switch (choice) {
            case (1):
                p = new Queen(owner, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
            case (2):
                p = new Rook(owner, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
            case (3):
                p = new Knight(owner, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
            case (4):
                p = new Bishop(owner, (char) (pos.getX() + 65), pos.getY() + 1);
                break;
        }
        owner.getPieces().add(p);
        cb.getSquareByPosition(pos).putPiece(p);
    }

    public abstract PositionList canGo(ChessBoard cb);

}
