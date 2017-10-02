package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Chess;
import com.mygdx.game.Util;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Util.SCREEN_WIDTH;
		config.height = Util.SCREEN_HEIGHT;
		new LwjglApplication(new Chess(), config);
	}
}
