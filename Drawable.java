package com.mygdx.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by felipecosta on 10/2/17.
 */
public abstract class Drawable extends Sprite{

    Texture texture;

    public Drawable() {
        super();
    }

    public Drawable(String pathToImage) {
        super(new Texture(Gdx.files.internal(pathToImage)));
        texture = this.getTexture();
        this.setPosition(0, 0);
    }

    public Drawable(String pathToImage, float x, float y) {
        super(new Texture(Gdx.files.internal(pathToImage)));
        texture = this.getTexture();
        this.setPosition(x, y);
    }


    public void dispose() {
        this.texture.dispose();
    }
}
