package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.*;
import com.mygdx.pieces.Piece;
import com.mygdx.web.Web;

import static com.mygdx.pieces.PieceCode.PAW;

public class EventHandler {

    ChessTable ct;
    SpriteBatch sb;
    BoardDrawer db;
    PositionList posList=null;
    Piece selected=null;
<<<<<<< HEAD
=======
    Player pl;
    Position pos;
    Position pd;
    Player p;
    int k;
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095

    public EventHandler(ChessTable ct, BoardDrawer db)
    {
        this.ct = ct;
        this.db = db;
    }



    public void listen() {

        if(!ct.getMyTurn()) return;

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            int i = Gdx.input.getX()/ Util.SQUARE_WIDTH;
            int j = (Util.SCREEN_HEIGHT - Gdx.input.getY())/ Util.SQUARE_HEIGHT;
            selectionHandler( i, j);
        }
    }

    private void selectionHandler(int i, int j){

        if(selected == null) {
<<<<<<< HEAD
            if (ct.getSquare(i, j).hasPiece()){
                if(ct.getSquare(i,j).getPiece().getPlayer() == ct.Me) {
=======
            if (ct.getSquare(i, j).hasPiece()) {
                //comentado para que o usuario jogue pelos 2
                //if(ct.getSquare(i,j).getPiece().getPlayer() == pl) {
                if (ct.getSquare(i, j).getPiece().getPlayer().getNumber() == ct.getWhoseTurn()) {
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095
                    selected = ct.getSquare(i, j).getPiece();
                    posList = selected.canGo(ct);
                    return;
                }
<<<<<<< HEAD
            }else{
                return;
            }
        }else if(ct.requestMove(ct.Me, selected.getPosition(), new Position( i, j))){
=======
                //}
            } else {
                return;
            }
        }else{
            //if(ct.chessLogic.pawnPromotion(ct, selected.getPosition())) {
            //    ct.gphchoice = promote();
            //}
            if (ct.requestMove(selected.getPlayer(), selected.getPosition(), new Position(i, j))) {
                if(ct.promotion == 1) {
                    pos = selected.getPosition();
                    pd = new Position(i, j);
                    p = selected.getPlayer();
                }
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095
                selected = null;
                posList = null;
                return;
            }
        }
        selected = null;
        posList=null;

        if(ct.getSquare(i,j).hasPiece()){
            if(ct.getSquare(i,j).getPiece().getPlayer()==ct.Me) {
                selected = ct.getSquare(i, j).getPiece();
                posList = selected.canGo(ct);
            }
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

    public void promote(){
        System.out.println("PJJJJJJJ");
        ct.moveIntricacies(p, pos, pd);
        ct.promotion = 0;
    }

}
