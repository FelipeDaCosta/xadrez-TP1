package com.mygdx.pieces;

import com.mygdx.game.ChessBoard;
import com.mygdx.game.Player;
import com.mygdx.game.Position;
import com.mygdx.game.PositionList;
import com.mygdx.game.Square;

/*
* Todas as peças individuais estendem à Piece, e implementam um construtor (que recebe o jogador e a posição inicial)
* E um método canGo que basicamente implementa a Lógica de movimentação da peça.
* Este método canGo recebe um tabuleiro e, a partir dele, a peça, sabendo sua posição, retorna uma lista
* de posições para onde ela pode ir.
* */
public class Pawn extends Piece {

    private Square[][] board = new Square[8][8];

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
                if (cb.getSquareByPosition(p).isEmpty()) {
                    list.add(new Position(p));

                    if (this.getPosition().getY() == 1) {
                        p.moveUp();
                        if (p.isValidPosition()) {
                            if (cb.getSquareByPosition(p).isEmpty()) {
                                list.add(new Position(p));
                            }
                        }
                        p.moveDown();
                    }
                }
            }
            p.moveLeft();
            if (p.isValidPosition()) {
                if (!cb.getSquareByPosition(p).isEmpty()) {
                    if (isEnemy(cb.getSquareByPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }
            p.moveRight(2);
            if (p.isValidPosition()) {
                if (!cb.getSquareByPosition(p).isEmpty()) {
                    if (isEnemy(cb.getSquareByPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }

        }
        if(numPlayer==2) {
            p.moveDown();
            if (p.isValidPosition()) {
                if (cb.getSquareByPosition(p).isEmpty()) {
                    list.add(new Position(p));

                if (this.getPosition().getY() == 6) {
                    p.moveDown();
                    if (p.isValidPosition()) {
                        if (cb.getSquareByPosition(p).isEmpty()) {
                            list.add(new Position(p));
                        }
                    }
                    p.moveUp();
                }

                }
            }
            p.moveLeft();
            if (p.isValidPosition()) {
                if (!cb.getSquareByPosition(p).isEmpty()) {
                    if (isEnemy(cb.getSquareByPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }
            p.moveRight(2);
            if (p.isValidPosition()) {
                if (!cb.getSquareByPosition(p).isEmpty()) {
                    if (isEnemy(cb.getSquareByPosition(p).getPiece())) {
                        list.add(new Position(p));
                    }
                }
            }

        }
        return list;
    }


}
