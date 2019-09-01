package com.hasw3ll.game.actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class AnimatedActor extends BaseActor {

    private float elapsedAnimationTime = 0;
    private AnimationType activeAnimationType;
    private Animation<Sprite> activeAnimation;
    private Map<AnimationType, Animation<Sprite>> animations;

    public AnimatedActor(TextureAtlas textureAtlas) {
        super(textureAtlas);
        animations = new HashMap<>();
    }

    public void addAnimation(AnimationType type, Animation<Sprite> animation) {
        animations.put(type, animation);
        if (activeAnimation == null)
            setActiveAnimation(type);
    }

    public AnimationType getActiveAnimationType() {
        return activeAnimationType;
    }

    public void setActiveAnimation(AnimationType type) {
        activeAnimationType = type;
        activeAnimation = animations.get(type);
        elapsedAnimationTime = 0;
    }

    @Override
    public void act(float dt) {
        elapsedAnimationTime += dt;
        super.act(dt);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        textureRegion.setRegion(activeAnimation.getKeyFrame(elapsedAnimationTime, true));
        super.draw(batch, parentAlpha);
    }

    protected Animation<Sprite> createAnimation(String regionName, int framesCount, int frameWidth, int frameHeight, float frameDuration) {
        Array<Sprite> frames = new Array<>();

        for (int i = 0; i < framesCount; i++) {
            Sprite texture = new Sprite(textureAtlas.findRegion(regionName), i * frameWidth, 0, frameWidth, frameHeight);
            texture.setSize(frameWidth, frameHeight);
            frames.add(texture);
        }

        return new Animation<>(frameDuration, frames);
    }

    @Override
    public void dispose() {

    }

    public enum AnimationType {
        IDLE, MOVE_RIGHT, MOVE_LEFT, MOVE_UP, MOVE_DOWN
    }
}
