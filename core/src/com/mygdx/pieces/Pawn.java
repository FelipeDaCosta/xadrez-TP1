package com.mygdx.pieces;

import com.mygdx.game.ChessBoard;
import com.mygdx.game.Player;
import com.mygdx.game.Position;
import com.mygdx.game.PositionList;

import java.util.ArrayList;

/**
 * Created by felipecosta on 10/2/17.
 */
public class Pawn extends Piece {

    public Pawn(Player p, char X, int Y){
        super(PieceCode.PAW, X,Y);
        super.player = p;
        super.numPlayer = p.getNumber();
    }

    public PositionList canGo(ChessBoard cb){

        PositionList list = new PositionList();
        Position p = new Position(this.getPosition());

        if(numPlayer==1) {
            p.moveUp();
            if (p.isValidPosition()) {
                if (cb.byPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }
            }
            p.moveLeft();
            if (p.isValidPosition()) {
                if (!cb.byPosition(p).isEmpty()) {
                    if (isEnemy(cb.byPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }
            p.moveRight(2);
            if (p.isValidPosition()) {
                if (!cb.byPosition(p).isEmpty()) {
                    if (isEnemy(cb.byPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }
            if (this.getPosition().getY() == 1) {
                p.moveUpLeft();
                if (p.isValidPosition()) {
                    if (cb.byPosition(p).isEmpty()) {
                        list.add(new Position(p));
                    }
                }
            }
        }
        if(numPlayer==2) {
            p.moveDown();
            if (p.isValidPosition()) {
                if (cb.byPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }
            }
            p.moveLeft();
            if (p.isValidPosition()) {
                if (!cb.byPosition(p).isEmpty()) {
                    if (isEnemy(cb.byPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }
            p.moveRight(2);
            if (p.isValidPosition()) {
                if (!cb.byPosition(p).isEmpty()) {
                    if (isEnemy(cb.byPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }
            if (this.getPosition().getY() == 6) {
                p.moveDownLeft();
                if (p.isValidPosition()) {
                    if (cb.byPosition(p).isEmpty()) {
                        list.add(new Position(p));
                    }
                }
            }
        }

        return list;
    }


}
