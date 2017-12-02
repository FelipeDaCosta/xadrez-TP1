package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ChessBoard;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Util;
import com.mygdx.pieces.King;
import com.mygdx.pieces.Pawn;
import com.mygdx.web.Web;

/**
 * Created by felipecosta on 10/2/17.
 */
public class GameScreen implements Screen{

    Chess game;
    ChessTable ct;
    EventHandler eventHandler;
    BoardDrawer board;
    OrthographicCamera camera;
    public String username;
    int count=0;


    public GameScreen(Chess game, EventHandler eventHandler, ChessTable ct, String name) {
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
        * */
        Gdx.graphics.setContinuousRendering(false);
        if(Gdx.graphics.getDeltaTime()>5)
            Gdx.graphics.requestRendering();
<<<<<<< HEAD

=======
        if(ct.promotion != 1)
            eventHandler.listen();
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095

        camera.update();
        game.sb.setProjectionMatrix(camera.combined);

        ct.verifyEnemyMove();
        eventHandler.listen();


        if(ct.cMate==1){
            game.setScreen(new GameOver(game, ct.whoseTurn));
        }

        if(ct.gphchoice != 10)
            eventHandler.promote();

        game.sb.begin();

        /*Imprime as texturas em camadas (ordem importa)*/
        board.drawBoard();
        eventHandler.pathHighLighter();
        board.drawPieces();
        if(ct.promotion == 1)
            ct.gphchoice = board.promotion(ct);
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
        Web.finishGame();
        board.dispose();
        game.dispose();
    }
}
