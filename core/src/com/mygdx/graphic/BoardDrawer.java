package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ChessBoard;
import com.mygdx.game.ChessTable;
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
                if(num==1){
                    return new Texture(Gdx.files.internal("bishop_white.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("bishop_black.png"));
                }
                break;
            case KNG:
                if(num==1){
                    return new Texture(Gdx.files.internal("king_white.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("king_black.png"));
                }
                break;
            case KNT:
                if(num==1){
                    return new Texture(Gdx.files.internal("knight_white.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("knight_black.png"));
                }
                break;
            case PAW:
                if(num==1){
                    return new Texture(Gdx.files.internal("pawn_white.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("pawn_black.png"));
                }
                break;
            case QEN:
                if(num==1){
                    return new Texture(Gdx.files.internal("queen_white.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("queen_black.png"));
                }
                break;
            case ROK:
                if(num==1){
                    return new Texture(Gdx.files.internal("rook_white.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("rook_black.png"));
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

    public int promotion(ChessTable ct){
        System.out.println("JJJJJJJJJJ");
        sb.draw(new Texture(Gdx.files.internal("promNorm.png")), Util.SCREEN_WIDTH / 2 - 235,
                Util.SCREEN_HEIGHT / 2 - 85, 470, 171);
        if(Gdx.input.getX() > 72 && Gdx.input.getX() < 150 && Gdx.input.getY() > 305 && Gdx.input.getY() < 385) {
            sb.draw(new Texture(Gdx.files.internal("promNormQ.png")), Util.SCREEN_WIDTH / 2 - 235,
                    Util.SCREEN_HEIGHT / 2 - 85, 470, 171);
            if(Gdx.input.isTouched()) {
                ct.promotion = 0;
                return 1;
            }
        }
        if(Gdx.input.getX() > 195 && Gdx.input.getX() < 288 && Gdx.input.getY() > 305 && Gdx.input.getY() < 385) {
            sb.draw(new Texture(Gdx.files.internal("promNormR.png")), Util.SCREEN_WIDTH / 2 - 235,
                    Util.SCREEN_HEIGHT / 2 - 85, 470, 171);
            if(Gdx.input.isTouched()) {
                ct.promotion = 0;
                return 2;
            }
        }
        if(Gdx.input.getX() > 325 && Gdx.input.getX() < 408 && Gdx.input.getY() > 325 && Gdx.input.getY() < 385) {
            sb.draw(new Texture(Gdx.files.internal("promNormB.png")), Util.SCREEN_WIDTH / 2 - 235,
                    Util.SCREEN_HEIGHT / 2 - 85, 470, 171);
            if(Gdx.input.isTouched()) {
                ct.promotion = 0;
                return 4;
            }
        }
        if(Gdx.input.getX() > 455 && Gdx.input.getX() < 538 && Gdx.input.getY() > 315 && Gdx.input.getY() < 385) {
            sb.draw(new Texture(Gdx.files.internal("promNormK.png")), Util.SCREEN_WIDTH / 2 - 235,
                    Util.SCREEN_HEIGHT / 2 - 85, 470, 171);
            if(Gdx.input.isTouched()) {
                ct.promotion = 0;
                return 3;
            }
        }
        return 10;
    }

}
