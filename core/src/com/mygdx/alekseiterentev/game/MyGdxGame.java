package com.mygdx.alekseiterentev.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	RunAnimation runAnimation;
	Animation<TextureRegion> animation_run_left;
	int xCnt = 0;
	int yCnt = 0;
	float time;
	float x = 0f;
	boolean direction = true;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		runAnimation = new RunAnimation("hero_run.png", 8, 2, Animation.PlayMode.LOOP);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		runAnimation.setTime(Gdx.graphics.getDeltaTime());
		if (direction && x >= 0 && x + runAnimation.getFrame().getRegionWidth() <= Gdx.graphics.getWidth()) {
			runAnimation.getFrame().flip(!direction, false);
			batch.draw(runAnimation.getFrame(), x,0);
			x = x + 15;
		} else {
			direction = false;
		}
		if (!direction && x > 0) {
			runAnimation.getFrame().flip(!direction, false);
			batch.draw(runAnimation.getFrame(), x,0);
			x = x - 15;
		} else {
			direction = true;
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		runAnimation.dispose();
	}
}
