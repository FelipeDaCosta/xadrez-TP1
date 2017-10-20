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


public class Bishop extends Piece {

    public Bishop(Player p, char X, int Y){
        super(PieceCode.BSP, X, Y);
        super.player = p;
        super.numPlayer = p.getNumber();
    }


    public PositionList canGo(ChessBoard cb) {

        PositionList list = new PositionList();
        Position p = new Position(this.getPosition());

        while (true){
            p.moveUpRight();
            if (p.isValidPosition()) {
                if (cb.getSquareByPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.getSquareByPosition(p).getPiece())){
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
            p.moveUpLeft();
            if (p.isValidPosition()) {
                if (cb.getSquareByPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.getSquareByPosition(p).getPiece())){
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
            p.moveDownRight();
            if (p.isValidPosition()) {
                if (cb.getSquareByPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.getSquareByPosition(p).getPiece())){
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
            p.moveDownLeft();
            if (p.isValidPosition()) {
                if (cb.getSquareByPosition(p).isEmpty()) {
                    list.add(new Position(p));
                }else{
                    if(isEnemy(cb.getSquareByPosition(p).getPiece())){
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
