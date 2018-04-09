package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Target {
    Texture house,earth;
    Vector2 positionH, positionE;

    public Target() {
        this.house = new Texture("House.png");
        this.earth = new Texture("Earth.png");
        this.positionH = new Vector2(1100, 250);
        this.positionE = new Vector2(1100,90);
    }

    public void render (SpriteBatch batch){
        batch.draw(house, positionH.x - house.getWidth()/2, positionH.y - house.getHeight()/2,74,90,148,180,1,1,0,0,0,148,180,false,false);
        batch.draw(earth, positionE.x - earth.getWidth()/2, positionE.y - earth.getHeight()/2,110 ,73,219,146,1,1,0,0,0,219,146,false,false);
    }

    public void update(float dt){

        }
    }

