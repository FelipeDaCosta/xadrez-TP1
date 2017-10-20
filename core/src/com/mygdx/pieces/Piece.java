package com.mygdx.pieces;

import com.mygdx.drawable.Drawable;
import com.mygdx.game.*;

import java.util.ArrayList;

/**
 * Created by felipecosta on 10/2/17.
 */
public abstract class Piece extends Drawable {
    private PieceCode pieceCode;
    private Position position;
    private boolean onTheGame = true;
    protected int numPlayer;
    protected Player player;
    Util util = new Util();

    public Piece(PieceCode pieceCode, char X, int Y) {
        this.pieceCode = pieceCode;
        position = new Position(X,Y);
    }

    /*
    * public Piece(PieceCode pieceCode, String pathToImage) {
        super(pathToImage);
        this.pieceCode = pieceCode;
    }

    public void drawAtSquare(SpriteBatch sb, Square sq) {
        this.setPosition(sq.getX(), sq.getY());
        this.draw(sb);
    }
    * */

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
        if(p.getNumPlayer()==this.numPlayer)
            return false;
        return true;
    }

    public boolean isOnTheGame(){
        return this.onTheGame;
    }

    public PositionList canGo(ChessBoard cb){
        return null;
    }

}
