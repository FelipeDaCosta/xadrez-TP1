package com.mygdx.graphic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Player;

public class Chess extends Game {
	public SpriteBatch sb;

	@Override
	public void create() {
        sb = new SpriteBatch();

        /* Dinâmica de criação de um jogo. PARA TESTES */
        Player p1;
        Player p2;
        ChessTable ct = new ChessTable();
        p1 = ct.join();
        p2 = ct.join();

        BoardDrawer db = new BoardDrawer(ct,sb);
        EventHandler eventHandler = new EventHandler(ct, db, p1);
        this.setScreen(new MenuScreen(this, eventHandler, ct));
	}

    public void render() {
        super.render();
    }

    public void dispose() {
        sb.dispose();
    }
}
