package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
<<<<<<< HEAD:core/src/com/mygdx/game/PlayOnlineMenuScreen.java
import com.mygdx.graphic.Chess;
import com.mygdx.graphic.*;
=======
import com.mygdx.game.ChessTable;
import com.mygdx.game.Util;
>>>>>>> 1c540b9376d1726ebf2f70c7c62de5b388f7cfc7:core/src/com/mygdx/graphic/PlayOnlineMenuScreen.java

/**
 * Created by Iago on 10/27/2017.
 */

public class PlayOnlineMenuScreen implements Screen {

    Chess game;
    Texture logo;
    Texture backGameActive;
    Texture backGameInactive;

    private Stage stage;
    private TextField input;
    public String username = "DASAAS";

    public PlayOnlineMenuScreen(Chess game){
        this.game = game;
        logo = new Texture("logo.jpg");
        backGameActive = new Texture("button_backA.png");
        backGameInactive = new Texture("button_backI.png");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        TextButton inpButton = new TextButton("Username", skin);
        inpButton.setPosition(Util.SCREEN_WIDTH / 2 - 146, 350);
        inpButton.setSize(292, 50);
        inpButton.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                username = input.getText();
                //System.out.println(username);
            }
        });

        input = new TextField("", skin);
        input.setPosition(Util.SCREEN_WIDTH / 2 - 146, 300);
        input.setSize(292, 37);
        stage.addActor(input);
        stage.addActor(inpButton);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        game.sb.begin();
        if (username != "DASAAS") {
            this.dispose();
<<<<<<< HEAD:core/src/com/mygdx/game/PlayOnlineMenuScreen.java
            ChessTable ct = new ChessTable(1,  true);
            BoardDrawer db = new BoardDrawer(ct, game.sb);
            EventHandler eventHandler = new EventHandler(ct, db);
            game.setScreen(new GameScreen(game, eventHandler, ct,1,true));
=======
            //Dinâmica de criação de um jogo. PARA TESTES
            //ChessTable ct = new ChessTable(1, "alex", "jorge", true);

            //BoardDrawer db = new BoardDrawer(ct, game.sb);
            //EventHandler eventHandler = new EventHandler(ct, db);
            //game.setScreen(new GameScreen(game, eventHandler, ct, 1, true));
>>>>>>> 1c540b9376d1726ebf2f70c7c62de5b388f7cfc7:core/src/com/mygdx/graphic/PlayOnlineMenuScreen.java
        }
        if(Gdx.input.getX() > 154 && Gdx.input.getX() < 446 && Gdx.input.getY() > 350 && Gdx.input.getY() < 417) {
            game.sb.draw(backGameActive, Util.SCREEN_WIDTH / 2 - 146, 183, 292, 67);
            if(Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        }else
            game.sb.draw(backGameInactive, Util.SCREEN_WIDTH/2 - 146, 183, 292, 67);
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
