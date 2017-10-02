package com.mygdx.pieces;

/**
 * Created by felipecosta on 10/2/17.
 */
public class King extends Piece {

    private boolean hasMoved;

    public King() {
        super(PieceCode.KING, "king_black.png");
        hasMoved = false;
    }

    public void moved() { this.hasMoved = true; }
}
