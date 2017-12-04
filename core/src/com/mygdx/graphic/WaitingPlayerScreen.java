package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Player;
import com.mygdx.game.Util;
import com.mygdx.web.Web;

/**
 * Created by felipecosta on 11/6/17.
 */
public class WaitingPlayerScreen implements Screen {

    private Chess game;
    private BitmapFont font;
    private int count = 0;
    private final int MAX_COUNT = 180;

    public WaitingPlayerScreen(Chess game) {
        this.game = game;
        font = new BitmapFont();
        font.getData().setScale(2);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.game.sb.begin();
        count++;
        if(count >= MAX_COUNT) {
            count = 0;
            if(Web.gotGame().startsWith("yes")) {
                this.dispose();
                ChessTable ct = new ChessTable(1, true);

                BoardDrawer db = new BoardDrawer(ct,game.sb);
                EventHandler eventHandler = new EventHandler(ct, db);
                game.setScreen(new GameScreen(game, eventHandler, ct, 1, true));
            }
        }

        if(count <= MAX_COUNT/3) {
            font.draw(this.game.sb, "Procurando jogo .", Util.SCREEN_WIDTH/2 - 100, Util.SCREEN_HEIGHT/2);
        } else if (count <= 2*MAX_COUNT/3) {
            font.draw(this.game.sb, "Procurando jogo ..", Util.SCREEN_WIDTH/2 - 100, Util.SCREEN_HEIGHT/2);
        } else {
            font.draw(this.game.sb, "Procurando jogo ...", Util.SCREEN_WIDTH/2 - 100, Util.SCREEN_HEIGHT/2);
        }
        this.game.sb.end();
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
        font.dispose();
    }
}
