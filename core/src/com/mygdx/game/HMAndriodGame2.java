package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * AndroidGame home work 2.
 * @author Andrey Ievlev.
 * @version  9 April, 2018.
 * @Link
 */
public class HMAndriodGame2 extends ApplicationAdapter {
	SpriteBatch batch;
	Asteroid asteroid;
	Target target;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		asteroid = new Asteroid(-32,680,0,0);
		target = new Target();
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		updete(dt);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		asteroid.render(batch);
		target.render(batch);
		batch.end();
	}

	public void updete(float dt){
		if(Gdx.input.isTouched()){
			asteroid.positionA.set(-32, 720-752);
			//скорость астеройда специально определяеться положением мыши, чтобы было интереснее
			asteroid.velocityA.set(Gdx.input.getX(), 720 - Gdx.input.getY());
		}
		asteroid.update(dt);
		target.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		}
}
