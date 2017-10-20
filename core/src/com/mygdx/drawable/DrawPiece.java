package com.mygdx.drawable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.pieces.PieceCode;

public class DrawPiece extends Drawable{

    public DrawPiece(int num, PieceCode code, float x, float y){
        super();
        this.setPosition(x,y);
        switch(code){
            case BSP:
                if(num==1){
                    super.setTexture(new Texture(Gdx.files.internal("bishop_black.png")));
                }else if(num==2){
                    super.setTexture(new Texture(Gdx.files.internal("bishop_white.png")));
                }
                break;
            case KNG:
                if(num==1){
                    super.setTexture(new Texture(Gdx.files.internal("king_black.png")));
                }else if(num==2){
                    super.setTexture(new Texture(Gdx.files.internal("king_white.png")));
                }
                break;
            case KNT:
                if(num==1){
                    super.setTexture(new Texture(Gdx.files.internal("knight_black.png")));
                }else if(num==2){
                    super.setTexture(new Texture(Gdx.files.internal("knight_white")));
                }
                break;
            case PAW:
                if(num==1){
                    super.setTexture(new Texture(Gdx.files.internal("pawn_black.png")));
                }else if(num==2){
                    super.setTexture(new Texture(Gdx.files.internal("pawn_white.png")));
                }
                break;
            case QEN:
                if(num==1){
                    super.setTexture(new Texture(Gdx.files.internal("queen_black.png")));
                }else if(num==2){
                    super.setTexture(new Texture(Gdx.files.internal("queen_white.png")));
                }
                break;
            case ROK:
                if(num==1){
                    super.setTexture(new Texture(Gdx.files.internal("rook_black.png")));
                }else if(num==2){
                    super.setTexture(new Texture(Gdx.files.internal("rook_white.png")));
                }
                break;
        }
    }


    public DrawPiece(String pathToImage) {
        super(pathToImage);
    }

    public DrawPiece(String pathToImage, float x, float y) {
        super(pathToImage, x, y);
    }
}
