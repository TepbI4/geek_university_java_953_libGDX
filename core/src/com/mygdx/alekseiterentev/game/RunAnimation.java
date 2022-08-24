package com.mygdx.alekseiterentev.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RunAnimation {

    private Texture img;
    private Animation<TextureRegion> animation;
    private float time;

    public RunAnimation(String pictureName, int col, int row, Animation.PlayMode playMode) {
        img = new Texture(pictureName);

        TextureRegion region = new TextureRegion(img);

        int xCnt = region.getRegionWidth() / col;
        int yCnt = region.getRegionHeight() / row;
        TextureRegion[][] sprites = region.split(xCnt, yCnt);
        TextureRegion[] runSprites = new TextureRegion[sprites[0].length];
        int cnt = 0;
        for (int j = 0; j < sprites[0].length; j++) {
            runSprites[cnt] = sprites[0][j];
            cnt++;
        }

        animation = new Animation<>(1/60f, runSprites);
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
