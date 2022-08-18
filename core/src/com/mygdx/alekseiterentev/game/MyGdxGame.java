package com.mygdx.alekseiterentev.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Integer clicksCount = 0;
	String originalTitle;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("witcher.jpg");
		Gdx.input.setCursorPosition(img.getWidth() / 2, Gdx.graphics.getHeight() - img.getHeight() / 2);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			clicksCount++;
		}

		Gdx.graphics.setTitle("Clicked " + clicksCount + " times.");

		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
