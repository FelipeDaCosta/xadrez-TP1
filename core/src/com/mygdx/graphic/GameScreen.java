package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Util;

/**
 * Created by felipecosta on 10/2/17.
 */
public class GameScreen implements Screen{

    boolean onLine;
    Chess game;
    ChessTable ct;
    EventHandler eventHandler;
    BoardDrawer board;
    OrthographicCamera camera;
    public String username;
    int count=0;
    public int promotion = 0;
    private int promochoice;


    public GameScreen(Chess game, EventHandler eventHandler, ChessTable ct, String name, boolean onLine) {
        this.onLine = onLine;
        this.game = game;
        this.ct = ct;
        this.eventHandler=eventHandler;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Util.SCREEN_WIDTH, Util.SCREEN_HEIGHT);
        board = new BoardDrawer(ct, game.sb);
        username = name;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.5f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*Esse trecho de código deixa a renderização mais lenta, pois os cliques do mouse eram interpre
        * tados como multiplos cliques
        **/
        Gdx.graphics.setContinuousRendering(false);
        if(Gdx.graphics.getDeltaTime()>5)
            Gdx.graphics.requestRendering();

        camera.update();
        game.sb.setProjectionMatrix(camera.combined);


        if (ct.Me.getTurn() || !onLine) eventHandler.listen();
        else ct.verifyEnemyMove();
        if (ct.EndOfTheGame) game.setScreen(new GameOver(game, ct.winner));


        game.sb.begin();
        board.drawBoard();
        eventHandler.pathHighLighter();
        board.drawPieces();
        if(ct.needPromotion && (ct.Me.getTurn() || !onLine)) board.drawPromotion();
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
        game.dispose();
    }
}
