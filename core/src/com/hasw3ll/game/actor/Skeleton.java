package com.hasw3ll.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Skeleton extends AnimatedActor {

    private static final int FRAMES = 6;
    private static final int FRAME_WIDTH = 16;
    private static final int FRAME_HEIGHT = 17;
    private static final float FRAME_DURATION = 0.3f;

    private static final int SPRITE_WIDTH = 35;
    private static final int SPRITE_HEIGHT = 35;

    public Skeleton(TextureAtlas textureAtlas) {
        super(textureAtlas);

        setBounds(150, 150, SPRITE_WIDTH, SPRITE_HEIGHT);

        addAnimation(AnimationType.MOVE_RIGHT, createAnimation("Skel_walk_right"));
        addAnimation(AnimationType.MOVE_LEFT, createAnimation("Skel_walk_left"));
        addAnimation(AnimationType.MOVE_UP, createAnimation("Skel_walk_up"));
        addAnimation(AnimationType.MOVE_DOWN, createAnimation("Skel_walk_down"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setActiveAnimation(AnimationType.MOVE_RIGHT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setActiveAnimation(AnimationType.MOVE_LEFT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            setActiveAnimation(AnimationType.MOVE_UP);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            setActiveAnimation(AnimationType.MOVE_DOWN);
        }

        super.draw(batch, parentAlpha);
    }

    private Animation<Sprite> createAnimation(String regionName) {
        return createAnimation(regionName, FRAMES, FRAME_WIDTH, FRAME_HEIGHT, FRAME_DURATION);
    }
}
