package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Util;
import com.mygdx.web.Web;

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
    public int playerNum;
    int count=0;
    private String player_name = "";
    private String enemy_name = "";


    public GameScreen(Chess game, EventHandler eventHandler, ChessTable ct, int playerNum, boolean onLine) {
        this.onLine = onLine;
        this.game = game;
        this.ct = ct;
        this.eventHandler=eventHandler;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Util.SCREEN_WIDTH, Util.SCREEN_HEIGHT);
        board = new BoardDrawer(ct, game.sb);
        this.playerNum = playerNum;
        if(ct.myNumber==1){
            ct.Me.setName("Brancas");
            ct.Enemy.setName("Pretas");
        }else{
            ct.Me.setName("Pretas");
            ct.Enemy.setName("Brancas");
        }
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
        if(Gdx.graphics.getDeltaTime()>11)
            Gdx.graphics.requestRendering();

        camera.update();
        game.sb.setProjectionMatrix(camera.combined);


        if (ct.Me.getTurn() || !onLine) eventHandler.listen();
        else{
            count++;
            if(count>10) {
                System.out.println("Verificou Web");
                ct.verifyEnemyMove();
                count=0;
            }
        }
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
