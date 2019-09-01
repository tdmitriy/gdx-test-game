package com.hasw3ll.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public abstract class BaseActor extends Actor implements Disposable {
    protected TextureRegion textureRegion;
    protected TextureAtlas textureAtlas;

    public BaseActor(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
        textureRegion = new TextureRegion();
    }

    public void setTexture(Texture texture) {
        setWidth(texture.getWidth());
        setHeight(texture.getHeight());
        textureRegion.setRegion(texture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
