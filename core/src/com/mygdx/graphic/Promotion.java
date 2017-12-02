package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Player;
import com.mygdx.game.Util;

/**
 * Created by Iago on 11/19/2017.
 * Tela que aparece quando algum peão de algum jogador
 * chega na última casa do inimigo
 */

public class Promotion implements Screen {

    Chess game;
    EventHandler eventHandler;
    ChessTable ct;
    Texture fundo;
    Texture whiteQ;
    Texture whiteB;
    Texture whiteR;
    Texture whiteK;
    Texture blackQ;
    Texture blackB;
    Texture blackR;
    Texture blackK;
    Texture whiteTile;
    Texture blackTile;

    public Promotion(Chess game, EventHandler eventHandler, ChessTable ct, String name, Player p) {
        this.game = game;
        this.eventHandler = eventHandler;
        this.ct = ct;
        fundo = new Texture("promotion.jpg");
        whiteQ = new Texture("queen_white.jpg");
        whiteB = new Texture("bishop_white.jpg");
        whiteR = new Texture("rook_white.png");
        whiteK = new Texture("knight_white.png");
        blackQ = new Texture("queen_black.jpg");
        blackB = new Texture("bishop_black.jpg");
        blackR = new Texture("rook_black.png");
        blackK = new Texture("knight_black.png");
        whiteTile = new Texture("white_square.png");
        blackTile = new Texture("black_square.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.sb.begin();
        game.sb.draw(fundo, 0, 0, 600, 600);
        if (ct.whoseTurn == 1){
            game.sb.draw(blackTile, Util.SCREEN_WIDTH / 2 - 146, 200, 292, 67);
            game.sb.draw(whiteQ, Util.SCREEN_WIDTH / 2 - 146, 200, 292, 67);
            if(Gdx.input.getX() > 154 && Gdx.input.getX() < 446 && Gdx.input.getY() > 333 && Gdx.input.getY() < 400) {
                if(Gdx.input.isTouched()) {
                    //ct.
                }
            }/*else{
            //game.sb.draw(gameoverw, 0, 0, 600, 600);*/
        }
        /*if(Gdx.input.getX() > 154 && Gdx.input.getX() < 446 && Gdx.input.getY() > 333 && Gdx.input.getY() < 400) {
            game.sb.draw(mmenuActive, Util.SCREEN_WIDTH / 2 - 146, 200, 292, 67);
            if(Gdx.input.isTouched()) {
                game.setScreen(new MainMenuScreen(game));
            }
        }else
            game.sb.draw(mmenuInactive, Util.SCREEN_WIDTH/2 - 146, 200, 292, 67);
        if(Gdx.input.getX() > 154 && Gdx.input.getX() < 446 && Gdx.input.getY() > 467 && Gdx.input.getY() < 534) {
            game.sb.draw(exitGameActive, Util.SCREEN_WIDTH / 2 - 146, 66, 292, 67);
            if(Gdx.input.isTouched())
                Gdx.app.exit();
        }else
            game.sb.draw(exitGameInactive, Util.SCREEN_WIDTH/2 - 146, 66, 292, 67);*/
            game.sb.end();


        }

        @Override
        public void resize(int width, int height) {

        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void hide() {

        }

        @Override
        public void dispose() {

        }
    }
