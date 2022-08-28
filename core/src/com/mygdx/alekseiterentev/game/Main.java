package com.mygdx.alekseiterentev.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.alekseiterentev.game.screens.MenuScreen;

public class Main extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }
}
