package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Player;
import com.mygdx.game.Util;
import com.mygdx.web.Web;

/**
 * Created by Iago on 10/27/2017.
 */

public class MainMenuScreen implements Screen {

    Chess game;
    Texture logo;
    Texture startGameActive;
    Texture startGameInactive;
    Texture startOnlineGameActive;
    Texture startOnlineGameInactive;
    Texture exitGameActive;
    Texture exitGameInactive;

    public MainMenuScreen(Chess game){
        this.game = game;
        logo = new Texture("logo.jpg");
        startGameActive = new Texture("button_playA.png");
        startGameInactive = new Texture("button_playI.png");
        startOnlineGameActive = new Texture("button_play-onlineA.png");
        startOnlineGameInactive = new Texture("button_play-onlineI.png");
        exitGameActive = new Texture("button_exitA.png");
        exitGameInactive = new Texture("button_exitI.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.sb.begin();
        game.sb.draw(logo, 0, 0, 600, 600);
        if(Gdx.input.getX() > 154 && Gdx.input.getX() < 446 && Gdx.input.getY() > 233 && Gdx.input.getY() < 300) {
            game.sb.draw(startGameActive, Util.SCREEN_WIDTH / 2 - 146, 300, 292, 67);
            if(Gdx.input.isTouched()) {
                this.dispose();
                ChessTable ct = new ChessTable(1, false);
                BoardDrawer db = new BoardDrawer(ct,game.sb);
                EventHandler eventHandler = new EventHandler(ct, db);
                //game.setScreen(new GameOver(game, ct.Me));
                game.setScreen(new GameScreen(game, eventHandler, ct, 0, false));
            }
        }else
            game.sb.draw(startGameInactive, Util.SCREEN_WIDTH/2 - 146, 300, 292, 67);
        if(Gdx.input.getX() > 154 && Gdx.input.getX() < 446 && Gdx.input.getY() > 350 && Gdx.input.getY() < 417) {
            game.sb.draw(startOnlineGameActive, Util.SCREEN_WIDTH / 2 - 146, 183, 292, 67);
            if(Gdx.input.isTouched()) {
                this.dispose();
                //game.setScreen(new PlayOnlineMenuScreen(game));
                String resp = Web.findGame();
                if(resp.equals("ok/1")) // First player
                    game.setScreen(new WaitingPlayerScreen(game));
                if(resp.equals("ok/2")) { // Second player
                    this.dispose();
                    /* Dinâmica de criação de um jogo. PARA TESTES */
                    ChessTable ct = new ChessTable(2, true);

                    BoardDrawer db = new BoardDrawer(ct,game.sb);
                    EventHandler eventHandler = new EventHandler(ct, db);
                    game.setScreen(new GameScreen(game, eventHandler, ct, 2, true));
                }
            }
        }else
            game.sb.draw(startOnlineGameInactive, Util.SCREEN_WIDTH/2 - 146, 183, 292, 67);
        if(Gdx.input.getX() > 154 && Gdx.input.getX() < 446 && Gdx.input.getY() > 467 && Gdx.input.getY() < 534) {
            game.sb.draw(exitGameActive, Util.SCREEN_WIDTH / 2 - 146, 66, 292, 67);
            if(Gdx.input.isTouched())
                Gdx.app.exit();
        }else
            game.sb.draw(exitGameInactive, Util.SCREEN_WIDTH/2 - 146, 66, 292, 67);
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
