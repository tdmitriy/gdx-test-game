package com.hasw3ll.game.actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class FlyBat extends AnimatedActor {

    private static final int FRAMES = 4;
    private static final int FRAME_WIDTH = 16;
    private static final int FRAME_HEIGHT = 16;
    private static final float FRAME_DURATION = 0.3f;

    private static final int SPRITE_WIDTH = 50;
    private static final int SPRITE_HEIGHT = 50;

    public FlyBat(TextureAtlas textureAtlas) {
        super(textureAtlas);

        setBounds(50, 50, SPRITE_WIDTH, SPRITE_HEIGHT);

        addAnimation(AnimationType.MOVE_RIGHT, createAnimation("fly_anim_spritesheet"));
    }

    private Animation<Sprite> createAnimation(String regionName) {
        return createAnimation(regionName, FRAMES, FRAME_WIDTH, FRAME_HEIGHT, FRAME_DURATION);
    }
}
