package com.mygdx.pieces;

import com.mygdx.game.ChessBoard;
import com.mygdx.game.Player;
import com.mygdx.game.Position;
import com.mygdx.game.PositionList;

public class Rook extends Piece {


    public Rook(Player p, char X, int Y){

        super(PieceCode.ROK, X, Y);
        super.player = p;
        super.numPlayer = p.getNumber();
    }

    public PositionList canGo(ChessBoard cb) {

        PositionList list = new PositionList();
        Position p = new Position(this.getPosition());

        while (true){
            p.moveUp();
            if (p.isValidPosition()) {
                if (cb.byPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.byPosition(p).getPiece())){
                        list.add(new Position(p));
                    }
                    break;
                }
            }else{
                break;
            }
        }

        p.setPosition(this.getPosition());

        while (true){
            p.moveDown();
            if (p.isValidPosition()) {
                if (cb.byPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.byPosition(p).getPiece())){
                        list.add(new Position(p));
                    }
                    break;
                }
            }else{
                break;
            }
        }

        p.setPosition(this.getPosition());
        while (true){
            p.moveRight();
            if (p.isValidPosition()) {
                if (cb.byPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.byPosition(p).getPiece())){
                        list.add(new Position(p));
                    }
                    break;
                }
            }else{
                break;
            }
        }

        p.setPosition(this.getPosition());
        while (true){
            p.moveLeft();
            if (p.isValidPosition()) {
                if (cb.byPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.byPosition(p).getPiece())){
                        list.add(new Position(p));
                    }
                    break;
                }
            }else{
                break;
            }
        }
        return list;
    }


}