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
    public void setPosition(char X, int Y){
        position.setPosition(X,Y);
    }

    public void setPosition(Position p){
        position = p;
    }
    public Position getPosition(){
        return position;
    }

    public void kill(){
        this.onTheGame = false;
    }

    public PieceCode getPieceCode() {
        return this.pieceCode;
    }

    public int getNumPlayer(){
        return player.getNumber();
    }
    public Player getPlayer(){
        return this.player;
    }

    public boolean isEnemy(Piece p){
        if(p.getNumPlayer()==this.player.getNumber())
            return false;
        return true;
    }

    public boolean isOnTheGame(){
        return this.onTheGame;
    }


    /*
    * Não sabia como declarar um método que DEVE ser implementado pelos filhos de outro jeito.. =/
    * */
    public PositionList canGo(ChessBoard cb){
        return null;
    }

}
