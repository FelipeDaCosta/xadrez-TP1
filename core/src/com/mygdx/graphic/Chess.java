package com.mygdx.graphic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ChessTable;
import com.mygdx.game.Player;
import com.mygdx.web.Web;

public class Chess extends Game {
	public SpriteBatch sb;

	@Override
	public void create() {
        sb = new SpriteBatch();
        this.setScreen(new MainMenuScreen(this));
	}

    public void render() {
        super.render();
    }

    public void dispose() {
        Web.finishGame();
	    sb.dispose();
    }
}
