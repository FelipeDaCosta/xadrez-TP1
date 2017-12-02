package com.mygdx.pieces;

import com.mygdx.game.ChessBoard;
import com.mygdx.game.Player;
import com.mygdx.game.Position;
import com.mygdx.game.PositionList;

/*
* Todas as peças individuais estendem à Piece, e implementam um construtor (que recebe o jogador e a posição inicial)
* E um método canGo que basicamente implementa a Lógica de movimentação da peça.
* Este método canGo recebe um tabuleiro e, a partir dele, a peça, sabendo sua posição, retorna uma lista
* de posições para onde ela pode ir.
* */
public class King extends Piece {

    private boolean hasMoved=false;
    private boolean hasMadeCastling=false;

    public King(Player p, char X, int Y){
        super(PieceCode.KNG, X, Y);
        super.player = p;
        super.numPlayer = p.getNumber();
    }

    public PositionList canGo(ChessBoard cb) {

        PositionList list = new PositionList();
        Position p = new Position(this.getPosition());

        p.moveUpRight();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }
            }
        }

        p.setPosition(this.getPosition());

        p.moveUpLeft();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }
            }
        }

        p.setPosition(this.getPosition());
        p.moveDownRight();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }
            }
        }

        p.setPosition(this.getPosition());
        p.moveDownLeft();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }
            }
        }

        p.setPosition(this.getPosition());
        p.moveUp();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }

            }
        }

        p.setPosition(this.getPosition());
        p.moveDown();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }
            }
        }

        p.setPosition(this.getPosition());
        p.moveRight();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }
            }
        }

        p.setPosition(this.getPosition());
        p.moveLeft();
        if (p.isValidPosition()) {
            if (cb.getSquareByPosition(p).isEmpty()) {
                list.add(new Position(p));
            }else{
                if(isEnemy(cb.getSquareByPosition(p).getPiece())){
                    list.add(new Position(p));
                }

            }
        }


        return list;
    }
}
