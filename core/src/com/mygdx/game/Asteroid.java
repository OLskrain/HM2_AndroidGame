package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    Texture textureA;
    Vector2 positionA, posAfromH, posAfromE, posAfromHnor, posAfromEnor;
    Vector2 velocityA;
    int counter = 0;
    float l, l2;

    Target target = new Target();

    public Asteroid(float x, float y, float vx, float vy) {
        this.textureA = new Texture("asteroid64.png");
        this.positionA = new Vector2(x, y);
        this.velocityA = new Vector2(vx, vy);
    }

    public void render (SpriteBatch batch){
        batch.draw(textureA, positionA.x - textureA.getWidth()/2, positionA.y - textureA.getHeight()/2,32,32,64,64,1,1,0,0,0,64,64,false,false);
    }

    public void update(float dt){
        interplay();
        positionA.mulAdd(velocityA, dt);
        velocityA.y -= 200 * dt;
        if(positionA.y - 32 < 0){
            counter++;
            positionA.y = 32;
            velocityA.y *= - 0.8f;
            if(counter > 1) velocityA.x *= 0.6f;
        }

    }
    public void interplay(){
        //взаимодействие астеройда с домом
        posAfromH = target.positionH.cpy().sub(positionA);
        //значене 100 взято спец. и не равно ((widthHouse + heightHouse)/4 + (widthAsteroid + heightasteroid)/4), так как изображение не занимают
        //всю площадь картинки.
        l = 100 - posAfromH.len();
        if(l > 0){
          positionA.set(-32,752);
          velocityA.set(0,0);
        }
        //взаимодействие астеройда с землей
        posAfromE = target.positionE.cpy().sub(positionA);
        l2 = 130 - posAfromE.len();
        if(l2 > 0){
            posAfromEnor = posAfromE.cpy().nor();
            positionA.mulAdd(posAfromEnor, - (l2/2));
            velocityA.x *= -0.6f;
        }
    }
}
