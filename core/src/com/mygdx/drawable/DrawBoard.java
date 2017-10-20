package com.mygdx.drawable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ChessBoard;
import com.mygdx.game.Position;
import com.mygdx.game.Square;
import com.mygdx.game.Util;
import com.mygdx.pieces.Piece;
import com.mygdx.pieces.PieceCode;

public class DrawBoard extends Drawable {

    ChessBoard cb;
    public SpriteBatch sb;
    public DrawSquare[][] squares = new DrawSquare[8][8];

    public DrawBoard(ChessBoard cb, SpriteBatch sb){
        this.cb = cb;
        this.sb = sb;

        for(int i = 0; i<8; i++){

            for(int j=0; j<8; j++){
                if((i+j)%2==0){
                    squares[i][j] = new DrawSquare("black_square.png",
                    (float)i* Util.SQUARE_WIDTH, (float)j*Util.SQUARE_HEIGHT);
                }else{
                    squares[i][j] = new DrawSquare("white_square.png",
                            (float)i* Util.SQUARE_WIDTH, (float)j*Util.SQUARE_HEIGHT);
                }

            }

        }


    }

    public void drawBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.draw(squares[i][j].getTexture(), squares[i][j].getX(), squares[i][j].getY());
            }
        }
    }
    public void drawPieces(){
        for(int i =0; i<8; i++){
            for(int j=0; j<8; j++){
                if(cb.getSquare(i,j).hasPiece()){
                    sb.draw(byPiece(cb.getSquare(i,j).getPiece()),
                            (float)i* Util.SQUARE_WIDTH, (float)j*Util.SQUARE_HEIGHT);
                }
            }
        }
    }

    private Texture byPiece(Piece piece){
        PieceCode code = piece.getPieceCode();
        int num = piece.getNumPlayer();
        switch(code){
            case BSP:
                if(num==1){
                    return new Texture(Gdx.files.internal("bishop_black.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("bishop_white.png"));
                }
                break;
            case KNG:
                if(num==1){
                    return new Texture(Gdx.files.internal("king_black.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("king_white.png"));
                }
                break;
            case KNT:
                if(num==1){
                    return new Texture(Gdx.files.internal("knight_black.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("knight_white.png"));
                }
                break;
            case PAW:
                if(num==1){
                    return new Texture(Gdx.files.internal("pawn_black.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("pawn_white.png"));
                }
                break;
            case QEN:
                if(num==1){
                    return new Texture(Gdx.files.internal("queen_black.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("queen_white.png"));
                }
                break;
            case ROK:
                if(num==1){
                    return new Texture(Gdx.files.internal("rook_black.png"));
                }else if(num==2){
                    return new Texture(Gdx.files.internal("rook_white.png"));
                }
                break;
        }
        return null;
    }

    public DrawSquare byPosition(Position pos){
        if(pos.isValidPosition())
            return squares[pos.getX()][pos.getY()];
        return null;
    }


}
