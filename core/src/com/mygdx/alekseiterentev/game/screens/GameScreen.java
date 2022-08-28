package com.mygdx.alekseiterentev.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.alekseiterentev.game.Main;

public class GameScreen implements Screen {

    private final Main game;
    private final SpriteBatch batch;

    public GameScreen(Main game) {
        this.game = game;
        this.batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLUE);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            dispose();
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }
}
