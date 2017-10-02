package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.Chess;
import com.mygdx.game.Util;
import com.mygdx.pieces.King;
import com.mygdx.pieces.Pawn;

/**
 * Created by felipecosta on 10/2/17.
 */
public class MenuScreen implements Screen{

    Chess game;
    OrthographicCamera camera;
    Pawn pawn;
    King king;

    public MenuScreen(Chess game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Util.SCREEN_WIDTH, Util.SCREEN_HEIGHT);
        pawn = new Pawn();
        pawn.setPosition(20, 20);
        king = new King();
        king.setPosition(100, 100);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.5f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.sb.setProjectionMatrix(camera.combined);

        game.sb.begin();
        pawn.draw(game.sb);
        king.draw(game.sb);
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
        pawn.dispose();
    }
}
