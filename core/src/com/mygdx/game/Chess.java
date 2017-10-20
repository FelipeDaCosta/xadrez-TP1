package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.drawable.DrawBoard;
import com.mygdx.screen.MenuScreen;

public class Chess extends Game {
	public SpriteBatch sb;

	@Override
	public void create() {
        sb = new SpriteBatch();
        Player p1;
        Player p2;
        ChessBoard cb = new ChessBoard();
        p1 = cb.join();
        p2 = cb.join();

        DrawBoard db = new DrawBoard(cb,sb);
        EventHandler eventHandler = new EventHandler(cb, db, p1);
        this.setScreen(new MenuScreen(this, eventHandler, cb));
	}

    public void render() {
        super.render();
    }

    public void dispose() {
        sb.dispose();
    }
}
