package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ChessBoard;
import com.mygdx.game.Position;
import com.mygdx.game.Util;
import com.mygdx.pieces.Piece;
import com.mygdx.pieces.PieceCode;

/*
* Classe que desenha o tabuleiro na tela dado um ChessBoard(ou Table) e um SpriteBatch
*
* */


public class BoardDrawer extends Drawable {

    ChessBoard cb;
    public SpriteBatch sb;

    public BoardDrawer(ChessBoard cb, SpriteBatch sb){
        this.cb = cb;
        this.sb = sb;
    }

    public void drawBoard() {

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                sb.draw(textureByPosition(i,j),
                        (float)i* Util.SQUARE_WIDTH, (float)j*Util.SQUARE_HEIGHT);
            }
        }

    }
    public void drawPieces(){
        for(int i =0; i<8; i++){
            for(int j=0; j<8; j++){
                if(cb.getSquare(i,j).hasPiece()){
                    sb.draw(textureByPiece(cb.getSquare(i,j).getPiece()),
                            (float)i* Util.SQUARE_WIDTH, (float)j*Util.SQUARE_HEIGHT);
                }
            }
        }
    }

    private Texture textureByPiece(Piece piece){
        PieceCode code = piece.getPieceCode();
        int num = piece.getNumPlayer();
        switch(code){
            case BSP:
                if(num==2){
                    return new Texture(Gdx.files.internal("bishop_black.png"));
                }else if(num==1){
                    return new Texture(Gdx.files.internal("bishop_white.png"));
                }
                break;
            case KNG:
                if(num==2){
                    return new Texture(Gdx.files.internal("king_black.png"));
                }else if(num==1){
                    return new Texture(Gdx.files.internal("king_white.png"));
                }
                break;
            case KNT:
                if(num==2){
                    return new Texture(Gdx.files.internal("knight_black.png"));
                }else if(num==1){
                    return new Texture(Gdx.files.internal("knight_white.png"));
                }
                break;
            case PAW:
                if(num==2){
                    return new Texture(Gdx.files.internal("pawn_black.png"));
                }else if(num==1){
                    return new Texture(Gdx.files.internal("pawn_white.png"));
                }
                break;
            case QEN:
                if(num==2){
                    return new Texture(Gdx.files.internal("queen_black.png"));
                }else if(num==1){
                    return new Texture(Gdx.files.internal("queen_white.png"));
                }
                break;
            case ROK:
                if(num==2){
                    return new Texture(Gdx.files.internal("rook_black.png"));
                }else if(num==1){
                    return new Texture(Gdx.files.internal("rook_white.png"));
                }
                break;
        }
        return null;
    }

    private Texture textureByPosition(int i, int j) {
        if ((i + j) % 2 == 0)
            return new Texture(Gdx.files.internal("black_square.png"));
        return new Texture(Gdx.files.internal("white_square.png"));
    }

}
