package com.mygdx.game;

import com.mygdx.drawable.Drawable;

/**
 * Created by felipecosta on 10/2/17.
 */
public class Square extends Drawable{

    private float x;
    private float y;

    public Square(String pathToImage, float x, float y) {
        super(pathToImage);
        this.setPosition(x, y);
        this.x = x;
        this.y = y;
    }

    public float getX() { return x; }

    public void setX(float x) { this.x = x; }

    public float getY() { return y; }

    public void setY(float y) { this.y = y; }
}
