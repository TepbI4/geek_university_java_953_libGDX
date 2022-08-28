package com.mygdx.alekseiterentev.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.alekseiterentev.game.Main;
import com.mygdx.alekseiterentev.game.RunAnimation;

public class GameScreen implements Screen {

    private final Main game;
    private final SpriteBatch batch;
    RunAnimation runAnimation;
    float x = 0f;
    boolean direction = true;

    public GameScreen(Main game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.runAnimation = new RunAnimation("atlas/hero_run_atlas.atlas", Animation.PlayMode.LOOP);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        runAnimation.setTime(Gdx.graphics.getDeltaTime());
        if (direction && x >= 0 && x + runAnimation.getFrame().getRegionWidth() <= Gdx.graphics.getWidth()) {
            if (runAnimation.getFrame().isFlipX()) runAnimation.getFrame().flip(direction, false);
            batch.draw(runAnimation.getFrame(), x,0);
            x = x + 15;
        } else {
            direction = false;
        }
        if (!direction && x > 0) {
            if (!runAnimation.getFrame().isFlipX()) runAnimation.getFrame().flip(!direction, false);
            batch.draw(runAnimation.getFrame(), x,0);
            x = x - 15;
        } else {
            direction = true;
        }
        batch.end();

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
