package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.*;
import com.mygdx.pieces.Piece;

public class EventHandler {

    ChessTable ct;
    SpriteBatch sb;
    BoardDrawer db;
    PositionList posList=null;
    Piece selected=null;
    Player pl;
    int k;

    public EventHandler(ChessTable ct, BoardDrawer db, Player pl)
    {
        this.pl = pl;
        this.ct = ct;
        this.db = db;
    }


    public void listen() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            int i = Gdx.input.getX()/ Util.SQUARE_WIDTH;
            int j = (Util.SCREEN_HEIGHT - Gdx.input.getY())/ Util.SQUARE_HEIGHT;
            selectionHandler( i, j);
        }
    }

    private void selectionHandler(int i, int j){
        if(selected == null) {
            if (ct.getSquare(i, j).hasPiece()){
                //comentado para que o usuario jogue pelos 2
                //if(ct.getSquare(i,j).getPiece().getPlayer() == pl) {
                    if(ct.getSquare(i,j).getPiece().getPlayer().getNumber()==ct.getWhoseTurn()) {
                        selected = ct.getSquare(i, j).getPiece();
                        posList = selected.canGo(ct);
                        return;
                    }
                //}
            }else{
                return;
            }
        }else if(ct.requestMove(selected.getPlayer(), selected.getPosition(), new Position(i,j))){
                selected = null;
                posList = null;
                return;
        }

        selected = null;
        posList=null;

        if(ct.getSquare(i,j).hasPiece()){
            // comentado pra que o usuario jogue pelos 2
            //if(ct.getSquare(i,j).getPiece().getPlayer() == pl){
                if(ct.getSquare(i,j).getPiece().getPlayer().getNumber()==ct.getWhoseTurn()) {
                    selected = ct.getSquare(i, j).getPiece();
                    posList = selected.canGo(ct);
                }
            //}
        }
    }


    public void pathHighLighter(){
        if(posList!=null){
            for(int i=0; i<posList.size(); i++){
                if((posList.get(i).getY()+posList.get(i).getX())%2==0) {
                    db.sb.draw(new Texture(Gdx.files.internal("black_square_highlighted.png")),
                            posList.get(i).getX()*Util.SQUARE_WIDTH, posList.get(i).getY()*Util.SQUARE_WIDTH);

                }else {
                    db.sb.draw(new Texture(Gdx.files.internal("white_square_highlighted.png")),
                            posList.get(i).getX()*Util.SQUARE_WIDTH, posList.get(i).getY()*Util.SQUARE_WIDTH);
                }
            }
        }

    }
}
