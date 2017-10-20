package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.drawable.DrawBoard;

import java.util.concurrent.TimeUnit;

public class EventHandler {

    ChessBoard cb;
    SpriteBatch sb;
    DrawBoard db;
    Player pl;
    PositionList posList=null;
    Square selected;
    int k;

    public EventHandler(ChessBoard cb, DrawBoard db, Player pl) {
        this.cb = cb;
        this.db = db;
        this.pl = pl;
    }


    public void listen() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {


        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {


        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {


        }

        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {


        }

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            int i = Gdx.input.getX()/Util.SQUARE_WIDTH;
            int j = (Util.SCREEN_HEIGHT - Gdx.input.getY())/ Util.SQUARE_HEIGHT;
            selectionHandler( i, j);
        }


    }

    private void selectionHandler(int i, int j){
        if(selected == null) {
            if (cb.getSquare(i, j).hasPiece()) {
                selected = cb.getSquare(i, j);
                posList = selected.getPiece().canGo(cb);
            }else{
                return;
            }
        }else if(cb.requestMove(pl,selected.getPosition(), new Position(i,j))){
                selected = null;
                posList = null;
                return;
        }

        selected = null;
        posList=null;

        if(cb.getSquare(i,j).hasPiece()){
            if(cb.getSquare(i,j).getPiece().getPlayer() == pl){
                selected = cb.getSquare(i,j);
                posList = selected.getPiece().canGo(cb);
            }
        }
    }


    public void highLightPath(){
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
