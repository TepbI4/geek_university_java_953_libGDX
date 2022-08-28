package com.mygdx.alekseiterentev.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RunAnimation {

    private TextureAtlas img;
    private Animation<TextureRegion> animation;
    private float time;

    public RunAnimation(String pictureName, Animation.PlayMode playMode) {
        img = new TextureAtlas(pictureName);

        animation = new Animation<TextureRegion>(1/60f, img.findRegions("hero_run"));
        animation.setFrameDuration(1/15f);
        animation.setPlayMode(playMode);

        time += Gdx.graphics.getDeltaTime();
    }

    public TextureRegion getFrame() {
        return animation.getKeyFrame(time);
    }

    public void setTime(float time) {
        this.time += time;
    }

    public void zeroTime() {
        time = 0;
    }

    public boolean isAnimationOver() {
        return animation.isAnimationFinished(time);
    }

    public void setPlayMode(Animation.PlayMode playMode) {
        animation.setPlayMode(playMode);
    }

    public void dispose() {
        img.dispose();
    }
}
